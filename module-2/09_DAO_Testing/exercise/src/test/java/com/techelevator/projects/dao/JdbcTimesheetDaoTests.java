package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.verification.Times;

import java.time.LocalDate;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {  //if we write these correctly, we'll find the bugs in timesheetDao

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao sut;


    @Before
    public void setup() {
        sut = new JdbcTimesheetDao(dataSource);
    }

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {
        Timesheet timesheet = sut.getTimesheet(1);

        assertTimesheetsMatch(TIMESHEET_1, timesheet);
    }

    @Test
    public void getTimesheet_returns_null_when_id_not_found() {
        Timesheet timesheet = sut.getTimesheet(17);

        Assert.assertNull(timesheet);
    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        List<Timesheet> timesheets = sut.getTimesheetsByEmployeeId(1);
        Assert.assertEquals(2, timesheets.size()); //should return two timesheets for employee_id 1, fails here, not getting 2nd timesheet
        assertTimesheetsMatch(TIMESHEET_1, timesheets.get(0));
        assertTimesheetsMatch(TIMESHEET_2, timesheets.get(1));

        List<Timesheet> timesheets2nd = sut.getTimesheetsByEmployeeId(2);
        Assert.assertEquals(2, timesheets2nd.size()); //should return two timesheets for employee_id 2
        assertTimesheetsMatch(TIMESHEET_3, timesheets2nd.get(0));
        assertTimesheetsMatch(TIMESHEET_4, timesheets2nd.get(1));

    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> timesheets = sut.getTimesheetsByProjectId(1);  //these lists are returning 2 each, method may call by employee id?
        Assert.assertEquals(3, timesheets.size());
        assertTimesheetsMatch(TIMESHEET_1, timesheets.get(0));
        assertTimesheetsMatch(TIMESHEET_2, timesheets.get(1));
        assertTimesheetsMatch(TIMESHEET_3, timesheets.get(2));

        timesheets = sut.getTimesheetsByProjectId(2);
        Assert.assertEquals(1, timesheets.size());
        assertTimesheetsMatch(TIMESHEET_4, timesheets.get(0));


    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {
        Timesheet createdTimesheet = new Timesheet(5, 2, 2,
                LocalDate.parse("2021-05-01"), 26.0, true, "Timesheet 5");

        createdTimesheet = sut.createTimesheet(createdTimesheet);

        int newId = createdTimesheet.getTimesheetId();
        Assert.assertEquals(newId, 5);




    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        Timesheet createdTimesheet2 = new Timesheet(5, 2, 2,
                LocalDate.parse("2021-05-01"), 26.0, true, "Timesheet 5");

        createdTimesheet2 = sut.createTimesheet(createdTimesheet2);

        assertTimesheetsMatch(createdTimesheet2, sut.getTimesheet(createdTimesheet2.getTimesheetId()));

    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        //Arrange
        Timesheet timesheet1Updated = new Timesheet(1, 2, 2,
                LocalDate.parse("2022-02-01"), 2.5, false, "Timesheet 1 updated");

        //Act'
        sut.updateTimesheet(timesheet1Updated);

        //Assert
        Timesheet actualTimesheet = sut.getTimesheet(timesheet1Updated.getTimesheetId());
        assertTimesheetsMatch(timesheet1Updated, actualTimesheet);

    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {
        sut.deleteTimesheet(2);

        Timesheet getThisTimesheet = sut.getTimesheet(2);
        Assert.assertNull(getThisTimesheet);    }

    @Test
    public void getBillableHours_returns_correct_total() {
        //Arrange
        //use the timesheets given as static finals

        //Act
        double sumOfHoursProjectOneEmpOne = sut.getBillableHours(1,1);

        //Assert
        Assert.assertEquals(2.5, sumOfHoursProjectOneEmpOne, 0.001);

        //Arrange
        int employeeID = 2;
        int projectID = 2;

        //Act
        double actualhours= sut.getBillableHours(employeeID, projectID);

        //Assert
        Assert.assertEquals(0, actualhours, 0.01);

    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
