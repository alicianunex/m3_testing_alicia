package com.example.demo.testm3;
import com.example.demo.domain.SmartWatch;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.CPU;
import com.example.demo.domain.pieces.RAM;
import com.example.demo.service.SmartWatchServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class SmartWatchServiceImplTest {
    @Test
    void saveNull() {
        new SmartWatchServiceImpl();

    }

    @Test
    void saveIdNullTest() {
        SmartWatchServiceImpl service = new SmartWatchServiceImpl();

        SmartWatch watch1 = new SmartWatch(null,
                "Apple Watch",
                new RAM(1L, "DDR4", 2),
                new Battery(1L, 4500.0),
                new CPU(1L, 4),
                false);

        assertEquals(3, service.count());
        SmartWatch result = service.save(watch1);
        assertEquals(4, service.count());

        assertNotNull(watch1);
        assertNotNull(result.getId());
        assertEquals(4, result.getId());
    }

    @Test
    @DisplayName("If 0 assign a new value")
    void saveIdZeroTest() {
        SmartWatchServiceImpl service = new SmartWatchServiceImpl();

        SmartWatch watch1 = new SmartWatch(0L, "Apple watch",
                new RAM(1L, "DDR4", 2),
                new Battery(1L, 4500.0),
                new CPU(1L, 4),
                false);

        assertEquals(3, service.count());
        SmartWatch result = service.save(watch1);
        assertEquals(4, service.count());

        assertNotNull(watch1);
        assertNotNull(result.getId());
        assertEquals(4, result.getId());
    }


    @Test
    void deleteNullTest() {
        SmartWatchServiceImpl service = new SmartWatchServiceImpl();
        boolean result = service.delete(null);
        assertFalse(result);
    }
    @Test
    void deleteNotContainsTest(){
        SmartWatchServiceImpl service = new SmartWatchServiceImpl();
        boolean result = service.delete(-1L);
        assertFalse(result);
    }
    @Test
    void deleteOKTest(){
        SmartWatchServiceImpl service = new SmartWatchServiceImpl();
        boolean result = service.delete(1L);
        assertTrue(result);
    }


    @Test
    void deleteAllTest(){
        SmartWatchServiceImpl service = new SmartWatchServiceImpl();
        assertTrue(service.count()>0);
        service.deleteAll();
        assertEquals(0,service.count());
    }
}

