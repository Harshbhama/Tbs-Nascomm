package com.Tbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Tbs.factory.DbFactory;
import com.Tbs.model.TbsBillHistoryVo;
import com.Tbs.model.TbsBillTableVo;
import com.Tbs.model.TbsUserVo;
import com.Tbs.service.TbsBillTableService;
import com.Tbs.service.TbsUserService;

public class TbsBillHistoryDao {

	Connection connection;
	DbFactory dbFactory;
	PreparedStatement preparedStatement;
	int result;
	ResultSet resultSet;

	public TbsBillHistoryDao() {

		dbFactory = new DbFactory();
		connection = dbFactory.setMysqlConnection();
	}

	public int payBill(TbsBillHistoryVo tbsBillHistoryVo) {

		String name = null;
		TbsUserService tbsUserService = new TbsUserService();
		List<TbsUserVo> tbsUserVosList = new ArrayList<TbsUserVo>();
		tbsUserVosList = tbsUserService.displayRecordService();

		for (TbsUserVo userVo : tbsUserVosList) {
			if (userVo.getCustomerId() == tbsBillHistoryVo.getCustomerId()) {
				name = userVo.getCustomerName();
			}
		}

		List<TbsBillTableVo> tbsBillTableVosList = new ArrayList<TbsBillTableVo>();

		TbsBillTableService tbsBillTableService = new TbsBillTableService();
		tbsBillTableVosList = tbsBillTableService.billListService();

		try {
			for (TbsBillTableVo billTableVo : tbsBillTableVosList) {
				if (billTableVo.getCustomerId() == tbsBillHistoryVo.getCustomerId()
						&& billTableVo.getBillStatus().equals("due")) {
					tbsBillTableService.modifyBillStatusService(tbsBillHistoryVo.getCustomerId());
				}
			}
			preparedStatement = connection.prepareStatement("insert into tbs_billhistory_table values(?,?,?,?,?)");
			preparedStatement.setInt(1, tbsBillHistoryVo.getCustomerId());
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, tbsBillHistoryVo.getPaymentMode());
			preparedStatement.setFloat(4, tbsBillHistoryVo.getAmount());
			preparedStatement.setString(5, tbsBillHistoryVo.getPaymentDate());
			result = preparedStatement.executeUpdate();

			if (result > 0) {
				connection.commit();
			}

		} catch (SQLException exception) {
			exception.printStackTrace();
		}

		return result;
	}

	public List<TbsBillHistoryVo> billHistory() {
		List<TbsBillHistoryVo> billHistoryList = new ArrayList<TbsBillHistoryVo>();
		try {
			preparedStatement = connection.prepareStatement("select * from tbs_billhistory_table");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				TbsBillHistoryVo tvBillHistoryVo = new TbsBillHistoryVo();

				tvBillHistoryVo.setCustomerId(resultSet.getInt(1));
				tvBillHistoryVo.setCustomerName(resultSet.getString(2));
				tvBillHistoryVo.setPaymentMode(resultSet.getString(3));
				tvBillHistoryVo.setAmount(resultSet.getFloat(4));
				tvBillHistoryVo.setPaymentDate(resultSet.getString(5));
				billHistoryList.add(tvBillHistoryVo);

			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}

		return billHistoryList;
	}

	public List<TbsBillHistoryVo> particularBillHistory(int custId) {
		List<TbsBillHistoryVo> particularList = new ArrayList<TbsBillHistoryVo>();

		try {
			preparedStatement = connection
					.prepareStatement("select * from tbs_billhistory_table where billhistory_custid=?");
			preparedStatement.setInt(1, custId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				TbsBillHistoryVo tvTbsBillHistoryVo = new TbsBillHistoryVo();
				tvTbsBillHistoryVo.setCustomerId(resultSet.getInt(1));
				tvTbsBillHistoryVo.setCustomerName(resultSet.getString(2));
				tvTbsBillHistoryVo.setPaymentMode(resultSet.getString(3));
				tvTbsBillHistoryVo.setAmount(resultSet.getFloat(4));
				tvTbsBillHistoryVo.setPaymentDate(resultSet.getString(5));
				particularList.add(tvTbsBillHistoryVo);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}

		return particularList;

	}

}
