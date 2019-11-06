package com.cg.ems.service;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ems.dto.Project;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceImplTest {
	
	@Autowired
	private ProjectService service;

//	@Before
//	public void setUp() throws Exception {
//		service = new ProjectServiceImpl();
//	}

	@Test
	public void testAddProject() {
		Project p = new Project();
		p.setBusinessUnit("asdjasgbu");
		p.setEndDate(Date.valueOf(LocalDate.parse("2019-12-02")));
		p.setProjectCode(86543);
		p.setProjectDescription("asfdasfasfasfd");
		
		p.setStartDate(Date.valueOf(LocalDate.parse("2019-12-30")));
		p.setStatus("Completed");
		
		Project pro = service.addProject(p);
		System.out.println(pro.getProjectCode());
		
	}

}
