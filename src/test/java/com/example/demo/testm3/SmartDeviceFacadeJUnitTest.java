package com.example.demo.testm3;

import com.example.demo.domain.SmartPhone;
import com.example.demo.service.SmartDeviceFacade;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SmartDeviceFacadeJUnitTest {


    @Test
    void createSmartPhoneTest() {

        SmartPhone smartPhone = (SmartPhone) SmartDeviceFacade.createSmartPhone();

        assertEquals("DDR4", smartPhone.getRam().getType());
        assertEquals(12.5, smartPhone.getCamera().getMegapixels());
        assertTrue(smartPhone.getWifi());
    }


}
