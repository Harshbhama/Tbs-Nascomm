package com.Tbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Tbs.factory.DbFactory;
import com.Tbs.gui.TbsGuiSysAdminHome;
import com.Tbs.gui.TbsGuiSysAdminLogin;
import com.Tbs.model.TbsSystemAdminVo;

public class TbsSystemAdminDao {

	Connection connection;
	DbFactory dbFactory;
	PreparedStatement preparedStatement;
	int result = 0;
	ResultSet resultSet;

	public TbsSystemAdminDao() {

		dbFactory = new DbFactory();
		connection = dbFactory.setMysqlConnection();
	}

	public List<TbsSystemAdminVo> systemAdminRecord() {
		List<TbsSystemAdminVo> tbsSystemAdminVosList = new ArrayList<TbsSystemAdminVo>();
		try {
			preparedStatement = connection.prepareStatement("select * from tbs_systemadmin_table");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				TbsSystemAdminVo tbsSystemAdminVo = new TbsSystemAdminVo();
				tbsSystemAdminVo.setSystemAdminId(resultSet.getInt(1));
				tbsSystemAdminVo.setSystemAdminName(resultSet.getString(2));
				tbsSystemAdminVo.setSystemAdminPhone(resultSet.getLong(3));
				tbsSystemAdminVo.setSystemAdminPassword(resultSet.getString(4));

				tbsSystemAdminVosList.add(tbsSystemAdminVo);
			}

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return tbsSystemAdminVosList;

	}

	public int systemAdminHome(long systemAdminPhone, String systemAdminPassword) {
		List<TbsSystemAdminVo> systemAdminList = new ArrayList<TbsSystemAdminVo>();
		systemAdminList = systemAdminRecord();

		for (TbsSystemAdminVo adminVo : systemAdminList) {
			if (adminVo.getSystemAdminPhone() == systemAdminPhone
					&& adminVo.getSystemAdminPassword().equals(systemAdminPassword)) {

				TbsGuiSysAdminLogin.frame.setVisible(false);

				new TbsGuiSysAdminHome();
				result++;
			}
		}

		return result;
	}

}
