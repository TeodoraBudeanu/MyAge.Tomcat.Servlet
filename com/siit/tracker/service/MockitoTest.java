package com.siit.tracker.service;

import com.siit.tracker.dao.HistoryItemRepository;
import com.siit.tracker.dao.IHistoryItemRepo;
import com.siit.tracker.exception.ValidationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @InjectMocks
    private CaloriesTracker caloriesTracker = new CaloriesTracker();

    @Spy
    private IHistoryItemRepo repo = new HistoryItemRepository();

    @Test
    public void test() throws ValidationException {
        doThrow(new RuntimeException()).when(repo).addHistoryItem(any(HistoryItem.class));

        caloriesTracker.addCalories(3);

        assertEquals(3, caloriesTracker.getTotal());
        assertThat(caloriesTracker.getTotal(), is(3));

        verify(repo, times(1)).addHistoryItem(any(HistoryItem.class));

    }

}
