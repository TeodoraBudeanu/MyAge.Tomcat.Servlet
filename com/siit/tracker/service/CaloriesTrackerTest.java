package com.siit.tracker.service;


import com.siit.tracker.exception.ValidationException;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class CaloriesTrackerTest {

    private CaloriesTracker caloriesTracker;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("before class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after class");
    }

    @Before
    public void setup() {
        System.out.println("in setup");
        HistoryItemRepositoryMock historyItemRepositoryMock = new HistoryItemRepositoryMock();
        caloriesTracker = new CaloriesTracker(historyItemRepositoryMock);
    }

    @After
    public void after() {
        System.out.println("after");
    }

    @Test
    public void testWhenInitializedThenEmpty() {
        assertEquals(0, caloriesTracker.getTotal());
    }

    @Test
    public void testWhenAddThenTotalIncreases() throws ValidationException {
        caloriesTracker.addCalories(3);
        assertEquals(3, caloriesTracker.getTotal());
    }

    @Test(expected = ValidationException.class)
    public void testWhenAddNegativeNumberThenValidationExeption() throws ValidationException {
        caloriesTracker.addCalories(-1);
        fail("should have thrown validation exception");
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testWhenAddNegativeNumberThenValidationExeptionWithSpecificMessage() throws ValidationException {
        thrown.expect(ValidationException.class);
        thrown.expectMessage("something went wrong");
        caloriesTracker.addCalories(-1);
    }



}
