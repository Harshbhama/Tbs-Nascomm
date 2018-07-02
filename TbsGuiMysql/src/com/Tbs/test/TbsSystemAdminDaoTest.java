package com.Tbs.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Tbs.service.TbsSystemAdminService;

public class TbsSystemAdminDaoTest {

	TbsSystemAdminService tbsSystemAdminService = new TbsSystemAdminService();

	@Test
	public void systemAdminRecordTest() {

		assertNotNull(tbsSystemAdminService.systemAdminRecordService());

	}

	@Test

	public void systemAdminHomeTest() {

		assertEquals(1, tbsSystemAdminService.systemAdminHomeService(9450802762l, "linc1234"));

	}

}
