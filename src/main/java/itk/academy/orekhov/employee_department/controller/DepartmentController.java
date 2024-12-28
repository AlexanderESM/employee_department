package itk.academy.orekhov.employee_department.controller;

import itk.academy.orekhov.employee_department.entity.Department;
import itk.academy.orekhov.employee_department.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
 * REST Controller for Department operations.
 */
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * Creates a new department.
     *
     * @param department the department to create
     * @return the created department
     */
    @PostMapping
    public ResponseEntity<Department> createDepartment(@Valid @RequestBody Department department) {
        Department savedDepartment = departmentService.saveDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    /**
     * Gets a list of all departments.
     *
     * @return list of all departments
     */
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    /**
     * Handles exceptions for invalid input or general errors.
     *
     * @param ex the exception
     * @return error message
     */
    @ExceptionHandler
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
