package com.Tbs.service;

import java.util.List;

import com.Tbs.dao.TbsBillTableDao;
import com.Tbs.model.TbsBillTableVo;
import com.Tbs.model.TbsUserVo;

public class TbsBillTableService {

	TbsBillTableDao tbsBillTableDao;

	public TbsBillTableService() {
		tbsBillTableDao = new TbsBillTableDao();

	}

	public int modifyBillStatusService(int custId) {
		return tbsBillTableDao.modifyBillStatus(custId);
	}

	public List<TbsBillTableVo> billListService() {
		return tbsBillTableDao.billList();
	}

	public int generateBillService(TbsUserVo tbsUserVo) {
		return tbsBillTableDao.generateBill(tbsUserVo);
	}

	public List<TbsBillTableVo> viewBillService(int custId) {
		return tbsBillTableDao.viewBill(custId);
	}

	public int generateInvoiceService() {
		return tbsBillTableDao.generateInvoice();
	}

}
