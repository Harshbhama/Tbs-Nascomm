package com.Tbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Tbs.factory.DbFactory;
import com.Tbs.model.TbsBillTableVo;
import com.Tbs.model.TbsPlanVo;
import com.Tbs.model.TbsUserVo;

public class TbsBillTableDao {

	float costMin, costMb, baseCost;
	String customerName;

	Connection connection;
	DbFactory dbFactory;
	PreparedStatement preparedStatement;
	int result;
	ResultSet resultSet;

	public TbsBillTableDao() {

		dbFactory = new DbFactory();
		connection = dbFactory.setMysqlConnection();
	}

	public int modifyBillStatus(int custId) {
		try {
			preparedStatement = connection
					.prepareStatement("update tbs_bill_table set bill_status='paid' where bill_customerid=?");
			preparedStatement.setInt(1, custId);
			result = preparedStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return result;
	}

	public List<TbsBillTableVo> billList() {
		List<TbsBillTableVo> tbsBillTableVosList = new ArrayList<TbsBillTableVo>();
		try {
			preparedStatement = connection.prepareStatement("select * from tbs_bill_table");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				TbsBillTableVo tvBillTableVo = new TbsBillTableVo();
				tvBillTableVo.setCustomerId(resultSet.getInt(1));
				tvBillTableVo.setCustomerName(resultSet.getString(2));
				tvBillTableVo.setInvoice(resultSet.getInt(3));
				tvBillTableVo.setDurationMin(resultSet.getFloat(4));
				tvBillTableVo.setUsageMb(resultSet.getFloat(5));
				tvBillTableVo.setCost(resultSet.getFloat(6));
				tvBillTableVo.setBillStatus(resultSet.getString(7));
				tbsBillTableVosList.add(tvBillTableVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tbsBillTableVosList;
	}

	public int generateBill(TbsUserVo tbsUserVo) {

		TbsUserDao tbsUserDao = new TbsUserDao();
		List<TbsUserVo> tbsUserVosList = new ArrayList<TbsUserVo>();
		tbsUserVosList = tbsUserDao.displayRecord();
		String planName = null;
		int invoice = generateInvoice();

		for (TbsUserVo userVo : tbsUserVosList) {
			if (userVo.getCustomerId() == tbsUserVo.getCustomerId()) {
				planName = userVo.getPlanName();
			}
		}
		for (TbsUserVo userVo : tbsUserVosList) {
			if (userVo.getCustomerId() == tbsUserVo.getCustomerId()) {
				customerName = userVo.getCustomerName();
			}
		}

		TbsPlanDao tbsPlanDao = new TbsPlanDao();
		List<TbsPlanVo> planList = new ArrayList<TbsPlanVo>();
		planList = tbsPlanDao.planList();
		for (TbsPlanVo tbsPlanVo : planList) {
			if (tbsPlanVo.getPlanName().equals(planName)) {

				costMin = tbsPlanVo.getCostPerMin();
				costMb = tbsPlanVo.getCostPerMb();
				baseCost = tbsPlanVo.getBaseCost();
			}
		}
		float cost = (tbsUserVo.getDurationMin() * costMin) + (tbsUserVo.getUsageMb() * costMb) + baseCost;
		try {
			preparedStatement = connection.prepareStatement("insert into tbs_bill_table values(?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, tbsUserVo.getCustomerId());
			preparedStatement.setString(2, customerName);
			preparedStatement.setInt(3, invoice);
			preparedStatement.setFloat(4, tbsUserVo.getDurationMin());
			preparedStatement.setFloat(5, tbsUserVo.getUsageMb());
			preparedStatement.setFloat(6, cost);
			preparedStatement.setString(7, "due");

			result = preparedStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
			}

		} catch (SQLException exception) {
			exception.printStackTrace();
		}

		return result;
	}

	public List<TbsBillTableVo> viewBill(int custId) {
		List<TbsBillTableVo> tbsBillTableVosList = new ArrayList<TbsBillTableVo>();

		try {
			preparedStatement = connection
					.prepareStatement("select * from tbs_bill_table where bill_customerid=? and bill_status='due'");
			preparedStatement.setInt(1, custId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				TbsBillTableVo tvBillTableVo = new TbsBillTableVo();
				tvBillTableVo.setCustomerId(resultSet.getInt(1));
				tvBillTableVo.setCustomerName(resultSet.getString(2));
				tvBillTableVo.setInvoice(resultSet.getInt(3));
				tvBillTableVo.setDurationMin(resultSet.getFloat(4));
				tvBillTableVo.setUsageMb(resultSet.getFloat(5));
				tvBillTableVo.setCost(resultSet.getFloat(6));
				tvBillTableVo.setBillStatus(resultSet.getString(7));

				tbsBillTableVosList.add(tvBillTableVo);
			}
			dbFactory.closeMysqlConnection();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}

		return tbsBillTableVosList;
	}

	public int generateInvoice() {

		if (billList().isEmpty()) {
			result = 10000;
		} else {
			try {
				preparedStatement = connection.prepareStatement("select max(bill_invoice) from tbs_bill_table");
				resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					result = resultSet.getInt(1);
					result += 1;
				}

			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		return result;
	}

}
