package com.Tbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Tbs.factory.DbFactory;
import com.Tbs.gui.TbsGuiAdminHome;
import com.Tbs.gui.TbsGuiAdminLogin;
import com.Tbs.model.TbsAdminVo;

public class TbsAdminDao {

	Connection connection;
	DbFactory dbFactory;
	PreparedStatement preparedStatement;
	int result = 0;
	ResultSet resultSet;

	public TbsAdminDao() {

		dbFactory = new DbFactory();
		connection = dbFactory.setMysqlConnection();
	}

	public List<TbsAdminVo> adminRecord() {
		List<TbsAdminVo> tbsAdminVosList = new ArrayList<TbsAdminVo>();
		try {
			preparedStatement = connection.prepareStatement("select * from tbs_admin_table");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				TbsAdminVo tvTbsAdminVo = new TbsAdminVo();
				tvTbsAdminVo.setAdminId(resultSet.getInt(1));
				tvTbsAdminVo.setAdminName(resultSet.getString(2));
				tvTbsAdminVo.setAdminPhone(resultSet.getLong(3));
				tvTbsAdminVo.setAdminPassword(resultSet.getString(4));

				tbsAdminVosList.add(tvTbsAdminVo);
			}
			// dbFactory.closeMysqlConnection();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return tbsAdminVosList;

	}

	public int adminHome(long adminPhone, String adminPassword) {

		List<TbsAdminVo> AdminList = new ArrayList<TbsAdminVo>();
		AdminList = adminRecord();

		for (TbsAdminVo adminVo : AdminList) {
			if (adminVo.getAdminPhone() == adminPhone && adminVo.getAdminPassword().equals(adminPassword)) {

				TbsGuiAdminLogin.frame.setVisible(false);

				new TbsGuiAdminHome();
				result++;
			}
		}

		return result;
	}

}
