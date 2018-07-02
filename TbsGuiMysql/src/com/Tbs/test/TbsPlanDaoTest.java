package com.Tbs.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Tbs.service.TbsPlanService;

public class TbsPlanDaoTest {

	TbsPlanService tbsPlanService = new TbsPlanService();

	@Test
	public void planListTest() {

		assertNotNull(tbsPlanService.planListService());

	}

}
