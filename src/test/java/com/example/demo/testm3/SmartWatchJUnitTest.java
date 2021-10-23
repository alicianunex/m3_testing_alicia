package com.example.demo.testm3;

import com.example.demo.domain.SmartDevice;
import com.example.demo.domain.SmartWatch;
import com.example.demo.domain.pieces.*;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static org.hamcrest.CoreMatchers.instanceOf;
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
                false,
                new HealthMonitor(1L, 12D, 5));
        smartWatchProper =  new SmartWatch(4L,
                "Samsung Galaxy SmartWatch",
                new RAM(1L, "DDR4", 8),
                new Battery(1L, 4500.0),
                new CPU(1L, 4),
                false, new HealthMonitor(1L, 12D, 5));
    }
    @Nested
    public class contructorTest {

        @Test
        void fullConstructorTest() {

            MatcherAssert.assertThat(smartWatch, instanceOf(SmartDevice.class));
            MatcherAssert.assertThat(smartWatchProper, instanceOf(SmartWatch.class));

            assertEquals(8,smartWatch.getRam().getGigabytes()) ;
            assertEquals("DDR4",smartWatch.getRam().getType()) ;
            assertEquals(12D,smartWatchProper.getMonitor().getBloodPressure()) ;

        }
        @Nested
        public class get_set_toStringTest {

            @Test
            void getMonitorTest() {
                assertEquals(5,smartWatchProper.getMonitor().getSleepQuality());
            }

            @Test
            void setCameraTest() {
                HealthMonitor temp = new HealthMonitor(4L, 50D, 100);
                smartWatchProper.setMonitor(temp);
                assertEquals(100,smartWatchProper.getMonitor().getSleepQuality());
            }


        }

    }
}