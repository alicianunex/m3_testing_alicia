package com.example.demo.testm3;

import com.example.demo.domain.SmartPhone;
import com.example.demo.domain.SmartWatch;
import com.example.demo.service.SmartDeviceFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartDeviceFactoryJUTest {

    @Test
    void createByTypeOfPhoneTest() {

        SmartPhone smartPhone = (SmartPhone) SmartDeviceFactory.createByType("phone");
    }
    @Test
    void createByTypeOfWatchTest() {

        SmartWatch smartWatch = (SmartWatch) SmartDeviceFactory.createByType("watch");
    }

    @Test
    void createByTypeEmptyTest() {
        assertThrows(IllegalArgumentException.class, () ->SmartDeviceFactory.createByType(""));
    }
}
