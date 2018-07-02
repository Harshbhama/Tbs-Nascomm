package com.Tbs.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.Tbs.dao.TbsBillHistoryDao;
import com.Tbs.model.TbsBillHistoryVo;

public class TbsBillHistoryDaoTest {

	TbsBillHistoryVo tbsBillHistoryVo = new TbsBillHistoryVo();
	TbsBillHistoryDao tbsBillHistoryDao = new TbsBillHistoryDao();

	@Test
	public void payBilltest() {

		tbsBillHistoryVo.customerId = 2;
		tbsBillHistoryVo.customerName = "Anuj";
		tbsBillHistoryVo.paymentMode = "Credit Card";
		tbsBillHistoryVo.amount = 1443f;
		tbsBillHistoryVo.paymentDate = "06/07/2017";

		tbsBillHistoryDao.payBill(tbsBillHistoryVo);

	}

	@Test
	public void billHistoryTest() {

		assertNotNull(tbsBillHistoryDao.billHistory());

	}

	@Test
	public void particularBillHistoryTest() {

		int custId = 2;
		tbsBillHistoryDao.particularBillHistory(custId);

	}

}
