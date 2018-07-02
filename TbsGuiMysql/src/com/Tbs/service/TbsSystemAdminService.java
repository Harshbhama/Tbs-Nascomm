package com.Tbs.service;

import java.util.List;

import com.Tbs.dao.TbsSystemAdminDao;
import com.Tbs.model.TbsSystemAdminVo;

public class TbsSystemAdminService {

	TbsSystemAdminDao tbsSystemAdminDao;

	public TbsSystemAdminService() {
		tbsSystemAdminDao = new TbsSystemAdminDao();

	}

	public List<TbsSystemAdminVo> systemAdminRecordService() {
		return tbsSystemAdminDao.systemAdminRecord();
	}

	public int systemAdminHomeService(long systemAdminPhone, String systemAdminPassword) {
		return tbsSystemAdminDao.systemAdminHome(systemAdminPhone, systemAdminPassword);
	}

}
