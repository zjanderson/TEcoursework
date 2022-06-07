package com.techelevator;

import org.junit.Assert;
import org.junit.*;

public class DateFashionTest {

    @Test
    public void getTable_return_0_if_you_under_2_date_9() {
        //arrange
        DateFashion testDateFashion = new DateFashion();

        //act
        int getATable = testDateFashion.getATable(1, 9);


        //assert
        Assert.assertEquals(0, getATable);
    }

    @Test
    public void getTable_return_1_if_you_and_date_7() {
        //arrange
        DateFashion testDateFashion = new DateFashion();

        //act
        int getATable = testDateFashion.getATable(7, 7);


        //assert
        Assert.assertEquals(1, getATable);
    }

    @Test
    public void getTable_return_1_if_you_8_and_date_3() {
        //arrange
        DateFashion testDateFashion = new DateFashion();

        //act
        int getATable = testDateFashion.getATable(8, 3);


        //assert
        Assert.assertEquals(2, getATable);
    }
}
