package com.example.demo.testm3;

import com.example.demo.domain.SmartDevice;
import com.example.demo.domain.SmartWatch;
import com.example.demo.domain.pieces.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartWatchJUnitTest {
    SmartDevice smartWatch;
    SmartWatch smartWatchProper;
    @BeforeEach
    void setup() {
        smartWatch = new SmartWatch(4L,
                "Samsung Galaxy Smartwatch",
                new RAM(1L, "DDR4", 8),
                new Battery(1L, 4500.0),
                new CPU(1L, 4),
                false
        );
        smartWatchProper =  new SmartWatch(4L,
                "Samsung Galaxy SmartWatch",
                new RAM(1L, "DDR4", 8),
                new Battery(1L, 4500.0),
                new CPU(1L, 4),
                false);
    }


    @Test
    void setCameraTest() {
        HealthMonitor temp = new HealthMonitor(4L, 50D, 100);
        smartWatchProper.setMonitor(temp);
        assertEquals(100,smartWatchProper.getMonitor().getSleepQuality());
    }


}


