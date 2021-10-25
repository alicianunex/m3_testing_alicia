package com.example.demo.testm3;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.EmployeeRepositoryImpl;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class EmployeeServiceImplJUnitTest {
    EmployeeService employeeService;
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();


    @BeforeEach
    void setUp() {
        employeeService = new EmployeeServiceImpl(employeeRepository);
}
    @DisplayName("Count employees number")
    @Test
    void countEmployeesTest() {

        Integer num = employeeService.count();
        assertAll(
                () -> assertNotNull(num),
                () -> assertTrue(num > 0),
                () -> assertEquals(3, num)
        );
    }

    @Nested
    public class FindTests {

        @DisplayName("Find all tests")
        @Test
        void findAllTests() {

            List<Employee> found = employeeService.findAll();

            assertAll(
                    () -> assertNotNull(found),
                    () -> assertTrue(found.size() > 0)
            );
        }

        @Test
        void findOneReturnOne() {

            Employee found = employeeService.findOne(1L);
            assertAll(
                    () -> assertNotNull(found),
                    () -> assertTrue(found.getId() > 0),
                    () -> assertTrue(found.getAge() > 0
                            && found.getAge() < 200),
                    () -> assertEquals(1L, (long) found.getId()),
                    () -> assertFalse(found.getName().isEmpty())
            );
        }

        @Test
        void findOneReturnNull() {

            try {
                Employee found = employeeService.findOne(null);
                assertNull(found);
            } catch (IllegalArgumentException error) {
                error.printStackTrace();
                assertThrows(IllegalArgumentException.class, () -> employeeRepository.findOne(null));
            }
        }
    }

    @Nested
    public class SaveTests {


        @Test
        void saveNullObject() {

            Employee employee = new Employee();
            int temp = employeeService.count();
            employeeService.save(employee);
            assertTrue(temp < employeeService.count());

        }

        @Test
        void saveNullId() {
            assumeTrue(employeeService.count() == 3);

            Employee employee = employeeService.findOne(1L);
            employee.setId(null);
            Employee employee1 = employeeService.save(employee);
            assertEquals(4, employeeService.count());
            assertNotNull(employee1.getId());
        }


        @Test
        void updateTest() {
            assumeTrue(employeeService.count() == 3);

            employeeService.findOne(1L).setAge(50);
            Employee employee1 = employeeService.save(employeeService.findOne(1L));
            assertEquals(3, employeeService.count());

            assertNotNull(employee1.getAge());
            assertEquals(50, employeeService.findOne(1L).getAge());
        }

        @Test
        void negativeIDTest() {
            assumeTrue(employeeService.count() == 3);

            Employee employee = employeeService.findOne(1L);
            employee.setId(-10L);
            Employee employee1 = employeeService.save(employee);
            assertEquals(4, employeeService.count());

            assertNotNull(employeeService.findOne(-10L));
            assertNotNull(employee1.getId());
        }
    }


    @Nested
    public class DeleteTests {


        @Test
        void deleteNullTest() {
            boolean result = employeeService.delete(null);
            assertFalse(result);
        }

        @Test
        void deleteOKTest() {

            int temp = employeeService.count();
            boolean result = employeeService.delete(1L);
            assertTrue(result);
            assertEquals((temp - 1), employeeService.count());
        }

    }
}
