package com.Tbs.service;

import java.util.List;

import com.Tbs.dao.TbsPlanDao;
import com.Tbs.model.TbsPlanVo;

public class TbsPlanService {

	TbsPlanDao tbsPlanService;

	public TbsPlanService() {
		tbsPlanService = new TbsPlanDao();

	}

	public List<TbsPlanVo> planListService() {
		return tbsPlanService.planList();
	}

}
