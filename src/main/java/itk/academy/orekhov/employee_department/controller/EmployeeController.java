package itk.academy.orekhov.employee_department.controller;

import itk.academy.orekhov.employee_department.employeeapp.EmployeeProjection;
import itk.academy.orekhov.employee_department.entity.Employee;
import itk.academy.orekhov.employee_department.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
 * REST Controller for Employee operations.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Gets a list of all employee projections.
     *
     * @return list of employee projections
     */
    @GetMapping("/projections")
    public ResponseEntity<List<EmployeeProjection>> getAllEmployeeProjections() {
        List<EmployeeProjection> projections = employeeService.getAllEmployeeProjections();
        if (projections.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(projections, HttpStatus.OK);
    }

    /**
     * Creates a new employee.
     *
     * @param employee the employee to create
     * @return the created employee
     */
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        Employee savedEmployee = employeeService.createEmployee(employee); // Исправлено на createEmployee
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    /**
     * Gets a list of all employees.
     *
     * @return list of all employees
     */
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
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
