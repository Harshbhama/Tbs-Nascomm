package com.Tbs.service;

import java.util.List;
import com.Tbs.dao.TbsBillHistoryDao;
import com.Tbs.model.TbsBillHistoryVo;

public class TbsBillHistoryService {

	TbsBillHistoryDao tbsBillHistoryDao;

	public TbsBillHistoryService() {
		tbsBillHistoryDao = new TbsBillHistoryDao();

	}

	public int payBillService(TbsBillHistoryVo tbsBillHistoryVo) {
		return tbsBillHistoryDao.payBill(tbsBillHistoryVo);
	}

	public List<TbsBillHistoryVo> billHistoryService() {
		return tbsBillHistoryDao.billHistory();
	}

	public List<TbsBillHistoryVo> particularBillHistoryService(int custId) {
		return tbsBillHistoryDao.particularBillHistory(custId);
	}

}
