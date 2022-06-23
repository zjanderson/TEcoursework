package com.techelevator.projects.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Project;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcEmployeeDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date FROM employee;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            employees.add(mapRowToEmployees(results));
        }
        return employees;
    }

    private Employee mapRowToEmployees(SqlRowSet results) { //had to build this to satisfy above method call
        Employee employee = new Employee();
        employee.setId(results.getInt("employee_id"));
        employee.setDepartmentId(results.getInt("department_id"));
        employee.setFirstName(results.getString("first_name"));
        employee.setLastName(results.getString("last_name"));
        Date birthDate = results.getDate("from_date"); //the date can be null, can't call .operator on null, need to check
        if (birthDate != null) {
            LocalDate birthDateLocal = birthDate.toLocalDate();
            employee.setBirthDate(birthDateLocal);
        }
//		employee.setBirthDate(results.getDate("birth_date")); //need to .toLocalDate for correct type
        Date hireDate = results.getDate("hire_date");
        if (hireDate != null) {
            LocalDate hireDateLocal = hireDate.toLocalDate();
            employee.setHireDate(hireDateLocal);
        }
//		employee.setHireDate(results.getDate("hire_date")); //need to .toLocalDate for correct type

        return employee;
    }


    @Override
    public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date " +
                     "FROM employee WHERE first_name ILIKE ?" + " AND last_name ILIKE ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, "%" +firstNameSearch + "%", "%" + lastNameSearch + "%");

        while(rowSet.next()) {
            int employeeId = rowSet.getInt("employee_id");
            int department_id = rowSet.getInt("department_id");
            String firstName = rowSet.getString("first_name");
            String lastName = rowSet.getString("last_name");
            Date birthDate = rowSet.getDate("birth_date");
            LocalDate birthDateLocal = null;
            if (birthDate != null) {
                birthDateLocal = birthDate.toLocalDate();
            }
            Date hireDate = rowSet.getDate("hire_date");
            LocalDate hireDateLocal = null;
            if (hireDate != null) {
                hireDateLocal = birthDate.toLocalDate();
            }

            Employee employee = new Employee();
            employee.setId(employeeId);
            employee.setDepartmentId(department_id);
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setBirthDate(birthDateLocal);
            employee.setHireDate(hireDateLocal);

            employees.add(employee);
        }

        return employees;
    }

    @Override
    public List<Employee> getEmployeesByProjectId(int projectId) {
        return new ArrayList<>();
    }

    @Override
    public void addEmployeeToProject(int projectId, int employeeId) {
    }

    @Override
    public void removeEmployeeFromProject(int projectId, int employeeId) {
         /* Unassign the employee from a project.
         * @param projectId the project to remove the employee from
         * @param employeeId the employee to remove */

        String sql = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?;";
        jdbcTemplate.update(sql, projectId, employeeId);

    }

    @Override
    public List<Employee> getEmployeesWithoutProjects() {
        return new ArrayList<>();
    }

}
