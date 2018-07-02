package com.Tbs.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.Tbs.dao.TbsBillTableDao;
import com.Tbs.model.TbsUserVo;

public class TbsBillTableDaoTest {

	TbsBillTableDao tbsBillTableDao = new TbsBillTableDao();
	TbsUserVo tbsUserVo = new TbsUserVo();

	@Test
	public void modifyBillStatusTest() {

		int custId = 2;
		tbsBillTableDao.modifyBillStatus(custId);

	}

	@Test
	public void billListTest() {

		assertNotNull(tbsBillTableDao.billList());
	}

	@Test

	public void generateBillTest() {

		tbsUserVo.durationMin = 456f;
		tbsUserVo.usageMb = 254;
		tbsUserVo.customerId = 2;

		assertEquals(1, tbsBillTableDao.generateBill(tbsUserVo));
	}

	@Test
	public void viewBillTest() {
		int custId = 2;
		assertNotNull(tbsBillTableDao.viewBill(custId));
	}

	@Test
	public void generateInvoiceTest() {

		assertNotNull(tbsBillTableDao.generateInvoice());
	}
}
