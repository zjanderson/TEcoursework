package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    private JdbcParkDao sut;

    @Before
    public void setup() {
        sut = new JdbcParkDao(dataSource);
    }

    @Test
    public void getPark_returns_correct_park_for_id() {
       //Arrange
        int parkId = 2;

        //Act
        Park actualPark = sut.getPark(parkId);

        //Assert
        assertParksMatch(PARK_2, actualPark);

    }

    @Test
    public void getPark_returns_null_when_id_not_found() {
        Assert.fail();
    }

    @Test
    public void getParksByState_returns_all_parks_for_state() {
      //Arrange
        String stateAbbreviation = "AA";

        //Act
        List<Park> parks =  sut.getParksByState(stateAbbreviation);

        //Assert
        Assert.assertNotNull(parks);
        Assert.assertEquals(2, parks.size()); //expect size of two because our test_data shows two in state AA
        assertParksMatch(PARK_1, parks.get(0));
        assertParksMatch(PARK_3, parks.get(1));
    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {
        //Arrange
        String stateAbbreviation = "XX";

        //Act
        List<Park> parks =  sut.getParksByState(stateAbbreviation);

        //Assert
        Assert.assertNotNull(parks);
        Assert.assertEquals(0, parks.size()); //expect size of zero because our test_data shows state XX doesn't exist
    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values() {
        //Arrange
        Park newPark = new Park(-1, "DisneyWorld", LocalDate.of(1950, 2, 20), 1.5, false);

        //Act - this will be an entire Park object
        Park actualPark = sut.createPark(newPark);

        //Assert
        newPark.setParkId(actualPark.getParkId()); //since the parkId is generated in the createPark method, gotta reset this to assert equality
        assertParksMatch(newPark, actualPark);
    }

    @Test
    public void created_park_has_expected_values_when_retrieved() {
        //Arrange
        Park newPark = new Park(-1, "DisneyWorld", LocalDate.of(1950, 2, 20), 1.5, false);

        //Act - this will be an entire Park object
        Park actualPark = sut.createPark(newPark);
        int insertedParkId = actualPark.getParkId();
        Park retrievePark = sut.getPark(insertedParkId);

        //Assert
        newPark.setParkId(actualPark.getParkId()); //since the parkId is generated in the createPark method, gotta reset this to assert equality
        assertParksMatch(newPark, retrievePark);
    }

    @Test
    public void updated_park_has_expected_values_when_retrieved() {
        //Arrange - make a change to every field but the parkId
        Park park1Updated = new Park(1, "Park 1 Updated", LocalDate.parse("1801-01-02"), 1000, false);

        //Act
        sut.updatePark(park1Updated); //this updates park_1

        //Assert
        Park actualUpdatedPark = sut.getPark(1); //this retrieves the updated park, getPark has to work for this to run, we tested it previously
        assertParksMatch(park1Updated, actualUpdatedPark); //checks that the park we tried to insert matches what the result of our update became

    }

    @Test
    public void deleted_park_cant_be_retrieved() {
        //Arrange
        int parkIdToDelete = 1;

        //Act
        sut.deletePark(parkIdToDelete);

        //Assert
        Park actualPark = sut.getPark(parkIdToDelete); //since deletePark is a void, it doesn't return, so we have to go get it'
        Assert.assertNull(actualPark);
    }

    @Test
    public void park_added_to_state_is_in_list_of_parks_by_state() {
        //Arrange
        int parkId = 1;
        String stateAbbreviation = "BB";

        //Act
        sut.addParkToState(parkId, stateAbbreviation); //void method, will need to call it to make sure it worked in Assert
        //Assert
        List<Park> parksInBB = sut.getParksByState(stateAbbreviation);
        Assert.assertNotNull(parksInBB);
        Assert.assertEquals(2, parksInBB.size());
        assertParksMatch(PARK_1, parksInBB.get(0));
        assertParksMatch(PARK_2, parksInBB.get(1));


    }

    @Test
    public void park_removed_from_state_is_not_in_list_of_parks_by_state() {
        Assert.fail();
    }

    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

}
