package com.mediquity.employee;

import com.mediquity.employee.bean.Employee;
import com.mediquity.employee.exception.ResourceNotFoundException;
import com.mediquity.employee.repository.EmployeeRepo;
import com.mediquity.employee.service.EmployeeServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepo employeeRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployee() {
        List<Employee> employees = Arrays.asList(
            new Employee(0, "Alice", "alice@gmail.com", "0000012345"),
            new Employee(1, "Bob", "alice@gmail.com", "1234512345")
        );

        when(employeeRepo.findAll()).thenReturn(employees);

        List<Employee> result = employeeService.getAllEmployee();
        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).getName());
    }

    @Test
    void testGetEmpById_ValidId() {
        Employee emp = new Employee(0, "Alice", "alice@gmail.com", "0000012345");
        when(employeeRepo.findById(1)).thenReturn(Optional.of(emp));

        Employee result = employeeService.getEmpById(1);
        assertNotNull(result);
        assertEquals("John", result.getName());
    }

    @Test
    void testGetEmpById_InvalidId_ThrowsException() {
        when(employeeRepo.findById(100)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> employeeService.getEmpById(100));
    }

    @Test
    void testSaveEmp() {
        Employee emp = new Employee(0, "Alice", "alice@gmail.com", "0000012345");
        when(employeeRepo.saveAndFlush(emp)).thenReturn(emp);

        Employee result = employeeService.saveEmp(emp);
        assertEquals("Sara", result.getName());
        verify(employeeRepo, times(1)).saveAndFlush(emp);
    }

    @Test
    void testDeleteEmp_ValidId() {
        int id = 5;
        String result = employeeService.deleteEmp(id);

        verify(employeeRepo, times(1)).deleteById(id);
        assertEquals("deleted_successfully", result);
    }

    @Test
    void testDeleteEmp_ZeroId() {
        String result = employeeService.deleteEmp(0);
        assertEquals("ID/email is 0 we can't delete it", result);
        verify(employeeRepo, times(0)).deleteById(anyInt());
    }
}
