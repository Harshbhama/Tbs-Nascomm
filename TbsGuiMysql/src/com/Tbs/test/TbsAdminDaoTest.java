package com.Tbs.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Tbs.dao.TbsAdminDao;

public class TbsAdminDaoTest {

	TbsAdminDao tbsAdminDao = new TbsAdminDao();

	@Test
	public void testAdminRecord() {

		assertNotNull(tbsAdminDao.adminRecord());

	}

	@Test
	public void testAdminHome() {

		assertEquals(1, tbsAdminDao.adminHome(9450802763l, "naresh1234"));
	}

}
