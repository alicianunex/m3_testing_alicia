package com.example.demo.testm3;

import com.example.demo.domain.SmartPhone;
import com.example.demo.service.SmartPhoneServiceImpl;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

//tests restantes de esta clase
public class SmartPhoneServiceTest {
    @Test
    void findAll() {
        SmartPhoneServiceImpl service = new SmartPhoneServiceImpl();
        List<SmartPhone> smartphones = service.findAll();

        assertNotNull(smartphones);
        assertEquals(3, smartphones.size());
    }

    @Test
    void findOne() {
        SmartPhoneServiceImpl service = new SmartPhoneServiceImpl();

        SmartPhone smartPhone1 = service.findOne(1L);

        assertNotNull(smartPhone1);
        assertEquals(1L, smartPhone1.getId());
        assertNotNull(smartPhone1.getName());
    }

    @Test
    void findByWifi() {
        SmartPhoneServiceImpl service = new SmartPhoneServiceImpl();

        List<SmartPhone> found = service.findByWifi(true);
        assertNotNull(service.findByWifi(true));
        assertFalse(service.findByWifi(true).isEmpty());

    }

    @Test
    void save() {
        SmartPhoneServiceImpl service = new SmartPhoneServiceImpl();

        assertThrows(
                IllegalArgumentException.class,
                () -> service.save(null)
        );
    }

    @DisplayName("Delete Tests")
    @Nested
    public class delete {
        @Test
        void deleteNull() {
            SmartPhoneServiceImpl service = new SmartPhoneServiceImpl();
            boolean result = service.delete(null);
            assertFalse(result);
        }

        @Test
        void deleteAll() {
            SmartPhoneServiceImpl service = new SmartPhoneServiceImpl();
            assertTrue(service.count() > 0);
            service.deleteAll();
            assertEquals(0, service.count());
        }

    @Test
    void deleteNotContainsTest(){
        SmartPhoneServiceImpl service = new SmartPhoneServiceImpl();
        boolean result = service.delete(0L);
        assertFalse(result);
    }
    @Test
    void deleteOkTest(){
        SmartPhoneServiceImpl service = new SmartPhoneServiceImpl();
        boolean result = service.delete(1L);
        assertTrue(result);
    }
}
}