package com.Tbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Tbs.factory.DbFactory;
import com.Tbs.model.TbsPlanVo;

public class TbsPlanDao {

	Connection connection;
	DbFactory dbFactory;
	PreparedStatement preparedStatement;
	int result;
	ResultSet resultSet;

	public TbsPlanDao() {

		dbFactory = new DbFactory();
		connection = dbFactory.setMysqlConnection();
	}

	public List<TbsPlanVo> planList() {
		List<TbsPlanVo> tbsPlanVosList = new ArrayList<TbsPlanVo>();
		try {
			preparedStatement = connection.prepareStatement("select * from tbs_plan_table");
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				TbsPlanVo tvTbsPlanVo = new TbsPlanVo();
				tvTbsPlanVo.setPlanName(resultSet.getString(1));
				tvTbsPlanVo.setPlanCode(resultSet.getLong(2));
				tvTbsPlanVo.setPlanValidity(resultSet.getInt(3));
				tvTbsPlanVo.setCostPerMb(resultSet.getFloat(4));
				tvTbsPlanVo.setCostPerMin(resultSet.getFloat(5));
				tvTbsPlanVo.setBaseCost(resultSet.getFloat(6));
				tbsPlanVosList.add(tvTbsPlanVo);

			}

		} catch (SQLException exception) {
			exception.printStackTrace();
		}

		return tbsPlanVosList;

	}

}
