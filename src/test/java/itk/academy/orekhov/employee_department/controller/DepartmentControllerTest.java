package itk.academy.orekhov.employee_department.controller;

import itk.academy.orekhov.employee_department.entity.Department;
import itk.academy.orekhov.employee_department.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DepartmentControllerTest {

    @InjectMocks
    private DepartmentController departmentController;

    @Mock
    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateDepartment() {
        Department department = new Department();
        department.setId(1L);
        department.setName("HR");

        when(departmentService.saveDepartment(department)).thenReturn(department);

        ResponseEntity<Department> response = departmentController.createDepartment(department);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals(department, response.getBody());
        verify(departmentService, times(1)).saveDepartment(department);
    }

    @Test
    void testGetAllDepartments() {
        Department dept1 = new Department();
        dept1.setId(1L);
        dept1.setName("HR");

        Department dept2 = new Department();
        dept2.setId(2L);
        dept2.setName("Finance");

        List<Department> departments = Arrays.asList(dept1, dept2);

        when(departmentService.getAllDepartments()).thenReturn(departments);

        ResponseEntity<List<Department>> response = departmentController.getAllDepartments();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(departments, response.getBody());
        verify(departmentService, times(1)).getAllDepartments();
    }

    @Test
    void testHandleException() {
        String errorMessage = "Invalid request";
        Exception exception = new Exception(errorMessage);

        ResponseEntity<String> response = departmentController.handleException(exception);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals(errorMessage, response.getBody());
    }
}
