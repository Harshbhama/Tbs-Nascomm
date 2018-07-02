package com.Tbs.service;

import java.util.List;

import com.Tbs.dao.TbsAdminDao;
import com.Tbs.model.TbsAdminVo;



public class TbsAdminService {

	TbsAdminDao tbsAdminDao;
	
	public TbsAdminService(){
		tbsAdminDao=new TbsAdminDao();
		
	}
	
	
	public List<TbsAdminVo> adminRecordService(){
		return tbsAdminDao.adminRecord();
	}
	
	public int adminHomeService(long adminPhone,String adminPassword){
		return tbsAdminDao.adminHome(adminPhone, adminPassword);
	}
	
	
	
	
	
	
}
