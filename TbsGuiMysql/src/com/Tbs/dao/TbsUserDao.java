package com.Tbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.Tbs.factory.DbFactory;
import com.Tbs.gui.TbsGuiCustDetails;
import com.Tbs.gui.TbsGuiDelete;
import com.Tbs.gui.TbsGuiUserHome;
import com.Tbs.gui.TbsGuiUserLogin;
import com.Tbs.model.TbsBillTableVo;
import com.Tbs.model.TbsUserVo;

public class TbsUserDao {

	Connection connection;
	DbFactory dbFactory;
	PreparedStatement preparedStatement;
	int result = 0;
	ResultSet resultSet;

	public TbsUserDao() {

		dbFactory = new DbFactory();
		connection = dbFactory.setMysqlConnection();
	}

	public int newConnection(TbsUserVo tbsUserVo) {
		try {
			preparedStatement = connection.prepareStatement("insert into tbs_customer_table values(?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, tbsUserVo.getCustomerId());
			preparedStatement.setString(2, tbsUserVo.getCustomerName());
			preparedStatement.setInt(3, tbsUserVo.getCustomerAge());
			preparedStatement.setString(4, tbsUserVo.getCustomerDOJ());
			preparedStatement.setString(5, tbsUserVo.getCustomerAddress());
			preparedStatement.setLong(6, tbsUserVo.getCustomerPhone());
			preparedStatement.setString(7, tbsUserVo.getPlanName());
			preparedStatement.setString(8, tbsUserVo.getUserPassword());
			result = preparedStatement.executeUpdate();
			if (result > 0) {
				connection.commit();

			}

			dbFactory.closeMysqlConnection();

		} catch (SQLException exception) {
			exception.printStackTrace();
		}

		return result;
	}

	public int modifyName(TbsUserVo tbsUserVo) {
		try {
			preparedStatement = connection
					.prepareStatement("update tbs_customer_table set cust_name=? where cust_id=?");
			preparedStatement.setString(1, tbsUserVo.getCustomerName());
			preparedStatement.setInt(2, tbsUserVo.getCustomerId());
			result = preparedStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
			}
			dbFactory.closeMysqlConnection();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return result;
	}

	public int modifyAge(TbsUserVo tbsUserVo) {
		try {
			preparedStatement = connection.prepareStatement("update tbs_customer_table set cust_age=? where cust_id=?");
			preparedStatement.setInt(1, tbsUserVo.getCustomerAge());
			preparedStatement.setInt(2, tbsUserVo.getCustomerId());
			result = preparedStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
			}
			dbFactory.closeMysqlConnection();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}

		return result;
	}

	public int modifyDOJ(TbsUserVo tbsUserVo) {
		try {
			preparedStatement = connection.prepareStatement("update tbs_customer_table set cust_doj=? where cust_id=?");
			preparedStatement.setString(1, tbsUserVo.getCustomerDOJ());
			preparedStatement.setInt(2, tbsUserVo.getCustomerId());
			result = preparedStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
			}
			dbFactory.closeMysqlConnection();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}

		return result;
	}

	public int modifyAddress(TbsUserVo tbsUserVo) {
		try {
			preparedStatement = connection.prepareStatement("update tbs_customer_table set cust_add=? where cust_id=?");
			preparedStatement.setString(1, tbsUserVo.getCustomerAddress());
			preparedStatement.setInt(2, tbsUserVo.getCustomerId());
			result = preparedStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
			}
			dbFactory.closeMysqlConnection();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}

		return result;
	}

	public int modifyPhone(TbsUserVo tbsUserVo) {
		try {
			preparedStatement = connection
					.prepareStatement("update tbs_customer_table set cust_phone=? where cust_id=?");
			preparedStatement.setLong(1, tbsUserVo.getCustomerPhone());
			preparedStatement.setInt(2, tbsUserVo.getCustomerId());
			result = preparedStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
			}
			dbFactory.closeMysqlConnection();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}

		return result;
	}

	public int modifyPlan(TbsUserVo tbsUserVo) {

		try {
			preparedStatement = connection
					.prepareStatement("update tbs_customer_table set cust_plan=? where cust_id=?");
			preparedStatement.setInt(2, tbsUserVo.getCustomerId());
			preparedStatement.setString(1, tbsUserVo.getPlanName());

			result = preparedStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
			}
			dbFactory.closeMysqlConnection();

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return result;
	}

	public int modifyCustomerPassword(TbsUserVo tbsUserVo) {

		try {
			preparedStatement = connection
					.prepareStatement("update tbs_customer_table set cust_pass=? where cust_id=?");
			preparedStatement.setString(1, tbsUserVo.getUserPassword());
			preparedStatement.setInt(2, tbsUserVo.getCustomerId());
			result = preparedStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
			}

		} catch (SQLException exception) {
			exception.printStackTrace();
		}

		return result;
	}

	public int deleteRecord(int custId) {

		TbsBillTableDao tbsBillTableDao = new TbsBillTableDao();
		TbsUserDao tbsUserDao = new TbsUserDao();
		List<TbsBillTableVo> tbsBillTableVosList = new ArrayList<TbsBillTableVo>();
		tbsBillTableVosList = tbsBillTableDao.billList();
		List<TbsUserVo> tbsUserVosList = new ArrayList<TbsUserVo>();
		tbsBillTableVosList = tbsBillTableDao.billList();
		int f = 0;
		int f1 = 0;
		tbsUserVosList = tbsUserDao.displayRecord();

		for (TbsUserVo userVo : tbsUserVosList) {
			if (userVo.getCustomerId() == custId) {
				f1 = 1;
				break;
			} else {
				f1 = 2;
			}
		}

		if (f1 == 1) {

			for (TbsBillTableVo billTableVo : tbsBillTableVosList) {
				if (billTableVo.getCustomerId() == custId && billTableVo.getBillStatus().equals("paid")) {
					f = 1;

				} else if (billTableVo.getCustomerId() == custId && billTableVo.getBillStatus().equals("due")) {
					f = 2;
				}
			}

			if (f == 1) {

				try {
					preparedStatement = connection.prepareStatement("delete from tbs_customer_table where cust_id=?");
					preparedStatement.setInt(1, custId);
					result = preparedStatement.executeUpdate();
					if (result > 0) {
						connection.commit();

					}

					dbFactory.closeMysqlConnection();
				} catch (SQLException exception) {
					exception.printStackTrace();
				}
			} else if (f == 2) {

				JOptionPane.showMessageDialog(TbsGuiDelete.removeButton, "Please pay the bill first");

			} else {
				JOptionPane.showMessageDialog(TbsGuiDelete.removeButton, "Lifespan of connection is too short");

			}
		} else if (f1 == 2) {
			JOptionPane.showMessageDialog(TbsGuiDelete.removeButton, "Customer Not found");
		}

		return result;
	}

	public List<TbsUserVo> displayRecord() {
		List<TbsUserVo> tbsUserVoList = new ArrayList<TbsUserVo>();
		try {
			preparedStatement = connection.prepareStatement("select * from tbs_customer_table");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				TbsUserVo tvUserVo = new TbsUserVo();
				tvUserVo.setCustomerId(resultSet.getInt(1));
				tvUserVo.setCustomerName(resultSet.getString(2));
				tvUserVo.setCustomerAge(resultSet.getInt(3));
				tvUserVo.setCustomerDOJ(resultSet.getString(4));
				tvUserVo.setCustomerAddress(resultSet.getString(5));
				tvUserVo.setCustomerPhone(resultSet.getLong(6));
				tvUserVo.setPlanName(resultSet.getString(7));
				tvUserVo.setUserPassword(resultSet.getString(8));
				tbsUserVoList.add(tvUserVo);
			}
			// dbFactory.closeMysqlConnection();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return tbsUserVoList;

	}

	public List<TbsUserVo> customerDetails(int customerId) {

		List<TbsUserVo> tbsUserVoList = new ArrayList<TbsUserVo>();
		tbsUserVoList = displayRecord();
		int f = 0;
		for (TbsUserVo userVo : tbsUserVoList) {

			if (userVo.getCustomerId() == customerId) {
				f = 1;
				break;
			} else {
				f = 2;
			}

		}

		List<TbsUserVo> tbsUserVosList = new ArrayList<TbsUserVo>();

		if (f == 1) {
			try {
				preparedStatement = connection.prepareStatement("select * from tbs_customer_table where cust_id=?");
				preparedStatement.setInt(1, customerId);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					TbsUserVo tbsUserVo = new TbsUserVo();
					tbsUserVo.setCustomerId(resultSet.getInt(1));
					tbsUserVo.setCustomerName(resultSet.getString(2));
					tbsUserVo.setCustomerAge(resultSet.getInt(3));
					tbsUserVo.setCustomerDOJ(resultSet.getString(4));
					tbsUserVo.setCustomerAddress(resultSet.getString(5));
					tbsUserVo.setCustomerPhone(resultSet.getLong(6));
					tbsUserVo.setPlanName(resultSet.getString(7));
					tbsUserVosList.add(tbsUserVo);
				}
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		} else if (f == 2) {
			JOptionPane.showMessageDialog(TbsGuiCustDetails.viewButton, "Customer not found");
		}

		return tbsUserVosList;

	}

	public int userHome(long userPhone, String userPassword) {

		List<TbsUserVo> userList = new ArrayList<TbsUserVo>();

		userList = displayRecord();

		for (TbsUserVo userVo : userList) {

			if (userVo.getCustomerPhone() == userPhone && userVo.getUserPassword().equals(userPassword)) {

				TbsGuiUserLogin.frame.setVisible(false);
				new TbsGuiUserHome(userVo.getCustomerId());
				result++;
			}

		}
		return result;

	}

	public TbsUserVo displayProfile(int customerId) {
		TbsUserVo tvTbsUserVo = new TbsUserVo();
		List<TbsUserVo> tbsUserVosList = new ArrayList<TbsUserVo>();
		tbsUserVosList = displayRecord();
		for (TbsUserVo userVo : tbsUserVosList) {
			if (userVo.getCustomerId() == customerId) {
				tvTbsUserVo.setCustomerId(customerId);
				tvTbsUserVo.setCustomerName(userVo.getCustomerName());
				tvTbsUserVo.setCustomerAge(userVo.getCustomerAge());
				tvTbsUserVo.setCustomerDOJ(userVo.getCustomerDOJ());
				tvTbsUserVo.setCustomerAddress(userVo.getCustomerAddress());
				tvTbsUserVo.setCustomerPhone(userVo.getCustomerPhone());
				tvTbsUserVo.setPlanName(userVo.getPlanName());

			}
		}

		return tvTbsUserVo;

	}

	public int generateCustomerId() {

		try {
			preparedStatement = connection.prepareStatement(
					"select max(cust_id) from (select cust_id from tbs_customer_table union  select billhistory_custid from tbs_billhistory_table ) as customer_id");
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				result = resultSet.getInt(1);
			}

		} catch (SQLException exception) {
			exception.printStackTrace();
		}

		return result + 1;
	}

}
