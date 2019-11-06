package com.cg.ems.project.web;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.project.dto.Project;
import com.cg.ems.project.exception.WrongDurationException;
import com.cg.ems.project.exception.WrongIDException;
import com.cg.ems.project.service.ProjectService;


@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService service;
	
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public Project addNewProject(@RequestBody Project project) throws WrongDurationException {
		return service.addProject(project);
	}

	@GetMapping(produces = "application/json")
	public List<Project> getAllProjects() {
		return service.fetchAll();
	}

	@GetMapping(value = "/projectCode/{projectCode}", produces = "application/json")
	public Project searchByProjectCode(@PathVariable int projectCode) throws WrongIDException{
		return service.searchById(projectCode);
	}
	

	@DeleteMapping(value = "/delete/{projectCode}", produces = "application/json")
	public boolean removeByprojectCode(@PathVariable int projectCode) throws WrongIDException {
		return service.deleteProject(projectCode);
	}
	
	@PutMapping(value = "/update")
	public String updateProject(@RequestParam int projectCode, String projectDescription,Date startDate,
			Date endDate,String businessUnit, String status) throws WrongIDException {
		int temp = service.modifyProject(projectCode,projectDescription,startDate, endDate, businessUnit, status);
		if (temp ==1)
			return "Successfull Modification";
		else 
			return "Couldn't Modify";
	}
}