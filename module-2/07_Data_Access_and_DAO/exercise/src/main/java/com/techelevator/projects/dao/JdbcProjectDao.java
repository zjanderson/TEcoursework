package com.techelevator.projects.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(int projectId) {
//		return new Project(0, "Not Implemented Yet", null, null);
		Project project = null;

		//2. write the query, execute it.
		String sql = "" + "SELECT project_id, name, from_date, to_date FROM project WHERE project_id = ?;";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, projectId);

		//3. process the results
		if (rowSet.next()) {
			project = mapRowToProject(rowSet);
		}
		return project;
	}


	@Override
	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<>();
		String sql = "SELECT project_id, name, from_date, to_date FROM project;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			projects.add(mapRowToProject(results));
		}
		return projects;
	}

	@Override
	public Project createProject(Project newProject) {
		String sql = "INSERT INTO project (name, from_date, to_date) " +
					 "VALUES (?, ?, ?) RETURNING project_id;";
		int project_id =
				jdbcTemplate.queryForObject(sql, Integer.class, newProject.getName(), newProject.getFromDate(), newProject.getToDate());
		newProject.setId(project_id);
		return newProject;
	}

	@Override
	public void deleteProject(int projectId) {
		String deleteTimeSheetSql = "DELETE from timesheet WHERE project_id = ?;";
		jdbcTemplate.update(deleteTimeSheetSql, projectId);

		String deleteProjectEmployeeSql = "DELETE from project_employee WHERE project_id = ?;";
		jdbcTemplate.update(deleteProjectEmployeeSql, projectId); //these lines should delete foreign key pointers to projectId

		String deleteProjectIdSql = "DELETE from project WHERE project_id = ?;";
		jdbcTemplate.update(deleteProjectIdSql, projectId);
	}

	private Project mapRowToProject(SqlRowSet rowSet) {
		Project project = new Project();

		int projectId = rowSet.getInt("project_id");
		project.setId(projectId);

		String name = rowSet.getString("name");
		project.setName(name);

		Date fromDate = rowSet.getDate("from_date"); //the date can be null, can't call .operator on null, need to check
		if (fromDate != null) {
			LocalDate fromDateLocal = fromDate.toLocalDate();
			project.setFromDate(fromDateLocal);
		}

		Date toDate = rowSet.getDate("to_date"); //the date can be null, can't call .operator on null, need to check
		if (toDate != null) {
			LocalDate toDateLocal = toDate.toLocalDate();
			project.setToDate(toDateLocal);
		}

		return project;
	}
}