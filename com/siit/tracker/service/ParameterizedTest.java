package com.siit.tracker.service;

import com.siit.tracker.exception.ValidationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTest {

    private static CaloriesTracker caloriesTracker = new CaloriesTracker();

    private int input;
    private int expected;

    @Parameterized.Parameters
    public static List<Object> data() {
        return Arrays.asList(new Object[][] {
                {5, 5},
                {5, 10},
                {3, 13}
        });
    }

    public ParameterizedTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void testAddCalories() throws ValidationException {
        caloriesTracker.addCalories(input);

        assertEquals(caloriesTracker.getTotal(), expected);
    }

}
