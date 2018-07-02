package com.Tbs.service;

import java.util.List;

import com.Tbs.dao.TbsUserDao;
import com.Tbs.model.TbsUserVo;

public class TbsUserService {

	TbsUserDao tbsUserDao;

	public TbsUserService() {
		tbsUserDao = new TbsUserDao();

	}

	public int newConnectionService(TbsUserVo tbsUserVo) {
		return tbsUserDao.newConnection(tbsUserVo);
	}

	public int modifyNameService(TbsUserVo tbsUserVo) {
		return tbsUserDao.modifyName(tbsUserVo);
	}

	public int modifyAgeService(TbsUserVo tbsUserVo) {
		return tbsUserDao.modifyAge(tbsUserVo);
	}

	public int modifyDOJService(TbsUserVo tbsUserVo) {
		return tbsUserDao.modifyDOJ(tbsUserVo);
	}

	public int modifyAddressService(TbsUserVo tbsUserVo) {
		return tbsUserDao.modifyAddress(tbsUserVo);
	}

	public int modifyPhoneService(TbsUserVo tbsUserVo) {
		return tbsUserDao.modifyPhone(tbsUserVo);
	}

	public int modifyPlanService(TbsUserVo tbsUserVo) {
		return tbsUserDao.modifyPlan(tbsUserVo);
	}

	public int modifyCustomerPasswordService(TbsUserVo tbsUserVo) {
		return tbsUserDao.modifyCustomerPassword(tbsUserVo);
	}

	public int deleteRecordService(int custId) {
		return tbsUserDao.deleteRecord(custId);
	}

	public List<TbsUserVo> displayRecordService() {
		return tbsUserDao.displayRecord();
	}

	public List<TbsUserVo> customerDetailsService(int customerId) {
		return tbsUserDao.customerDetails(customerId);
	}

	public int userHomeService(long userPhone, String userPassword) {

		return tbsUserDao.userHome(userPhone, userPassword);
	}

	public TbsUserVo displayProfileService(int customerId) {
		return tbsUserDao.displayProfile(customerId);
	}

	public int generateCustomerIdService() {
		return tbsUserDao.generateCustomerId();
	}

}
