package com.cg.ems.project.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.project.dto.Project;
import com.cg.ems.project.exception.WrongDurationException;
import com.cg.ems.project.exception.WrongIDException;
import com.cg.ems.project.repo.ProjectRepo;

@Service
@Transactional(rollbackOn = WrongIDException.class)
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepo repo;

	@Override
	public Project addProject(Project project) throws WrongDurationException {
		Date startDate = project.getStartDate();
		Date endDate = project.getEndDate();

		if (endDate.compareTo(startDate) > 0) {
			return repo.save(project);
		} else
			throw new WrongDurationException("Invalid Duration");
	}

	@Override
	public List<Project> fetchAll() {
		return repo.findAll();
	}

	@Override
	public Project searchById(int projectCode) throws WrongIDException {
		try {
			return repo.findById(projectCode).get();
		} catch (Exception e) {
			throw new WrongIDException("No Expense with Project Code " + projectCode + " found");
		}
	}

	@Override
	public Boolean deleteProject(int projectCode) throws WrongIDException {
		try {
			repo.deleteById(projectCode);
			return true;
		} catch (Exception e) {
			throw new WrongIDException("No Project with Project Code " + projectCode + " found");
		}
	}

	@Override
	public int modifyProject(Project project) throws WrongIDException, WrongDurationException {

		int projectCode = project.getProjectCode();
		String projectDescription = project.getProjectDescription();
		Date startDate = project.getStartDate();
		Date endDate = project.getEndDate();
		String businessUnit = project.getBusinessUnit();
		String status = project.getStatus();

		try {
//			Project p = repo.findById(projectCode).get();

			if (endDate.compareTo(startDate) > 0) {
				return repo.modifyProject(projectCode, projectDescription, startDate, endDate, businessUnit, status);
			} else
				throw new WrongDurationException("Invalid Duration");
		} catch (Exception e) {
			throw new WrongIDException("Project wtih code " + projectCode + " not found");
		}

	}

}
