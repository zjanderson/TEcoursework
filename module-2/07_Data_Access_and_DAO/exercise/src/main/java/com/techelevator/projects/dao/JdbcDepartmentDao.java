package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcDepartmentDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /*
     * Get a department from the datastore that belongs to the given id.
     * If the id is not found, return null.
     * @param departmentId the department id to get from the datastore
     * @return a filled out department object
     */

    @Override
    public Department getDepartment(int id) {
        Department department = null;
        String sql = "SELECT name, department_id FROM department " + "WHERE department_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if (result.next()) {
            department = mapRowToDepartment(result); //it didn't understand mapRowToDepartment so i built the method
        }
        return department;
//		return new Department(0, "Not Implemented Yet");
    }

    private Department mapRowToDepartment(SqlRowSet results) { //had to build this to satisfy above method call
        Department department = new Department();
        department.setId(results.getInt("department_id")); //getting error here for invalid column name
        department.setName(results.getString("name"));
        return department;
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT department_id, name FROM department;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            departments.add(mapRowToDepartment(results));
        }
        return departments;
    }

    @Override
    public void updateDepartment(Department updatedDepartment) {
        String sql = "UPDATE department SET name = ? " +
                "WHERE department_id = ?;";

                jdbcTemplate.update(sql, updatedDepartment.getName(), updatedDepartment.getId());
    }

}
