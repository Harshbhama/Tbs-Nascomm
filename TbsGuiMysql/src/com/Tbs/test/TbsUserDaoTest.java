package com.Tbs.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Tbs.model.TbsPlanVo;
import com.Tbs.model.TbsUserVo;
import com.Tbs.service.TbsUserService;

public class TbsUserDaoTest {

	TbsUserService tbsUserService = new TbsUserService();
	TbsUserVo tbsUserVo = new TbsUserVo();
	TbsPlanVo tbsPlanVo = new TbsPlanVo();

	@Test
	public void newConectionTest() {

		tbsUserVo.customerId = 2;
		tbsUserVo.customerName = "Anuj";
		tbsUserVo.customerAge = 22;
		tbsUserVo.customerDOJ = "05/07/2017";
		tbsUserVo.customerAddress = "Saviour";
		tbsUserVo.customerPhone = 9650522606l;
		tbsUserVo.planName = "Basic Plan";
		tbsUserVo.userPassword = "anuj1234";

		assertEquals(1, tbsUserService.newConnectionService(tbsUserVo));

	}

	@Test

	public void modifyNameTest() {
		tbsUserVo.customerName = "Anuj";
		tbsUserVo.customerId = 2;

		assertNotNull(tbsUserService.modifyNameService(tbsUserVo));
	}

	@Test

	public void modifyAgeTest() {
		tbsUserVo.customerAge = 22;
		tbsUserVo.customerId = 2;

		assertNotNull(tbsUserService.modifyAgeService(tbsUserVo));
	}

	@Test

	public void modifyDojTest() {
		tbsUserVo.customerDOJ = "05/07/2017";
		tbsUserVo.customerId = 2;

		assertNotNull(tbsUserService.modifyDOJService(tbsUserVo));
	}

	@Test

	public void modifyAddressTest() {
		tbsUserVo.customerAddress = "Saviour";
		tbsUserVo.customerId = 2;

		assertNotNull(tbsUserService.modifyAddressService(tbsUserVo));
	}

	@Test

	public void modifyPhoneTest() {
		tbsUserVo.customerPhone = 9650522606l;
		tbsUserVo.customerId = 2;

		assertNotNull(tbsUserService.modifyPhoneService(tbsUserVo));
	}

	@Test

	public void modifyPlanTest() {
		tbsUserVo.planName = "Basic Plan";
		tbsUserVo.customerId = 2;

		assertNotNull(tbsUserService.modifyPlanService(tbsUserVo));
	}

	@Test

	public void modifyCustomerPasswordTest() {
		tbsUserVo.userPassword = "anuj1234";
		tbsUserVo.customerId = 2;

		assertNotNull(tbsUserService.modifyCustomerPasswordService(tbsUserVo));
	}

	@Test
	public void deleteCustomerTest() {
		int custId = 1;
		assertEquals(1, tbsUserService.deleteRecordService(custId));
	}

	@Test
	public void displayRecordTest() {
		assertNotNull(tbsUserService.displayRecordService());
	}

	@Test
	public void customerDetailsTest() {
		int customerId = 2;
		assertNotNull(tbsUserService.customerDetailsService(customerId));
	}

	@Test
	public void userHomeTest() {
		assertNotNull(tbsUserService.userHomeService(9650522606l, "anuj1234"));
	}

	@Test
	public void displayProfileTest() {
		assertNotNull(tbsUserService.displayProfileService(2));
	}

	@Test
	public void generateCustomerIdTest() {
		assertNotNull(tbsUserService.generateCustomerIdService());
	}
}
