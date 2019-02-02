package com.siit.tracker.service;

import com.siit.tracker.dao.HistoryItemRepository;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class HistoryItemRepositoryTest {

    private HistoryItemRepository repository;

    @Before
    public void setup() {
        repository = new HistoryItemRepository();

    }

    @Test
    public void testAddWhenEmpty() {
        HistoryItem item = new HistoryItem(1, 4, 4, "add");
        repository.addHistoryItem(item);

        assertEquals(repository.getCount(), 1);
    }

    @Test
    public void removeExistingItemById() throws InterruptedException {
        int id = 3;
        HistoryItem item = new HistoryItem(3, 4, 4, "add");
        repository.addHistoryItem(item);
        repository.removeItemById(3);

        assertEquals(repository.getCount(), 0);
    }

    @Test
    public void removeExistingItem() {
        HistoryItem item = new HistoryItem(3, 3, 0, "remove");

        repository.addHistoryItem(item);
        repository.removeItem(item);

        assertEquals(repository.getCount(), 0);
    }


    @Test
    public void updateHistoryItem() {
        int id = 3;
        HistoryItem item = new HistoryItem(id, 3, 0, "remove");
        repository.addHistoryItem(item);

        HistoryItem retrievedItem = repository.getById(id);
        assertEquals(retrievedItem.getAmount(), 3);

        item.setAmount(5);
        repository.update(item);
        retrievedItem = repository.getById(id);
        assertEquals(retrievedItem.getAmount(), 5);
    }
}
