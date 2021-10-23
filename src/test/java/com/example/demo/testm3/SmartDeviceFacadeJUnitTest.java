package com.example.demo.testm3;

import com.example.demo.domain.SmartDevice;
import com.example.demo.service.SmartDeviceFacade;

import org.junit.jupiter.api.Test;



public class SmartDeviceFacadeJUnitTest {
    SmartDeviceFacade smartDeviceFacade;
    SmartDevice smartDevice = new SmartDevice() {
        @Override
        public Long getId() {
            return super.getId();
        }
    };


    @Test
    void count() {

    }
    @Test
    void findOne() {

    }
    @Test
    void findAll() {

    }
}