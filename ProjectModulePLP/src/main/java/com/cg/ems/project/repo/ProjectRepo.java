package com.cg.ems.project.repo;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.ems.project.dto.Project;

public interface ProjectRepo extends JpaRepository<Project ,Integer>{

	@Modifying
	@Query("UPDATE Project p SET p.projectDescription=:pD, p.startDate=:sD, p.endDate=:eD, p.businessUnit=:pB, p.status=:pS WHERE p.projectCode=:pC")
	int modifyProject(int pC, String pD, Date sD, Date eD, String pB, String pS); 

}
