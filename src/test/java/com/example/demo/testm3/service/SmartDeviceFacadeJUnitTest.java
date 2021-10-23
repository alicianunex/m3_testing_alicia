package com.example.demo.testm3.service;

import com.example.demo.domain.SmartDevice;
import com.example.demo.service.SmartDeviceFacade;
import com.example.demo.service.SmartPhoneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


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