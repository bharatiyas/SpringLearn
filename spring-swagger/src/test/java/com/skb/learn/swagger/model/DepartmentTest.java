package com.skb.learn.swagger.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DepartmentTest {

	private Department dept;
	
	@Before
	public void setUp() {
		dept = new Department(4L, "Finance");
	}
	
	@Test
	public void testGetDepartmentId() {
		Long deptId = 4l;
		assertEquals(deptId, dept.getDepartmentId());
	}

	@Test
	public void testGetName() {
		String deptName = "Finance";
		assertEquals(deptName, dept.getName());
	}

}
