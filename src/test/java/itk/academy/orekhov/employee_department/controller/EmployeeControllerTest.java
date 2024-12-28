package itk.academy.orekhov.employee_department.controller;

import itk.academy.orekhov.employee_department.employeeapp.EmployeeProjection;
import itk.academy.orekhov.employee_department.entity.Employee;
import itk.academy.orekhov.employee_department.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployeeProjections() {
        EmployeeProjection projection1 = mock(EmployeeProjection.class);
        EmployeeProjection projection2 = mock(EmployeeProjection.class);

        List<EmployeeProjection> projections = Arrays.asList(projection1, projection2);
        when(employeeService.getAllEmployeeProjections()).thenReturn(projections);

        ResponseEntity<List<EmployeeProjection>> response = employeeController.getAllEmployeeProjections();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(projections, response.getBody());
        verify(employeeService, times(1)).getAllEmployeeProjections();
    }

    @Test
    void testGetAllEmployeeProjectionsNoContent() {
        when(employeeService.getAllEmployeeProjections()).thenReturn(Collections.emptyList());

        ResponseEntity<List<EmployeeProjection>> response = employeeController.getAllEmployeeProjections();

        assertEquals(204, response.getStatusCodeValue());
        verify(employeeService, times(1)).getAllEmployeeProjections();
    }

    @Test
    void testCreateEmployee() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setPosition("Developer");
        employee.setSalary(60000.0);

        when(employeeService.createEmployee(employee)).thenReturn(employee);

        ResponseEntity<Employee> response = employeeController.createEmployee(employee);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals(employee, response.getBody());
        verify(employeeService, times(1)).createEmployee(employee);
    }

    @Test
    void testGetAllEmployees() {
        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setFirstName("John");
        employee1.setLastName("Doe");

        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setFirstName("Jane");
        employee2.setLastName("Smith");

        List<Employee> employees = Arrays.asList(employee1, employee2);
        when(employeeService.getAllEmployees()).thenReturn(employees);

        ResponseEntity<List<Employee>> response = employeeController.getAllEmployees();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(employees, response.getBody());
        verify(employeeService, times(1)).getAllEmployees();
    }

    @Test
    void testGetAllEmployeesNoContent() {
        when(employeeService.getAllEmployees()).thenReturn(Collections.emptyList());

        ResponseEntity<List<Employee>> response = employeeController.getAllEmployees();

        assertEquals(204, response.getStatusCodeValue());
        verify(employeeService, times(1)).getAllEmployees();
    }

    @Test
    void testHandleException() {
        String errorMessage = "Invalid request";
        Exception exception = new Exception(errorMessage);

        ResponseEntity<String> response = employeeController.handleException(exception);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals(errorMessage, response.getBody());
    }
}
