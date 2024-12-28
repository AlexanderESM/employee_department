package itk.academy.orekhov.employee_department.service;

import itk.academy.orekhov.employee_department.employeeapp.EmployeeProjection;
import itk.academy.orekhov.employee_department.entity.Employee;
import itk.academy.orekhov.employee_department.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Service class for Employee operations.
 */
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeProjection> getAllEmployeeProjections() {
        logger.info("Fetching all employee projections");
        return employeeRepository.findAllEmployeeProjections();
    }

    public Employee createEmployee(Employee employee) {
        logger.info("Creating employee: {} {}", employee.getFirstName(), employee.getLastName());
        return employeeRepository.save(employee);
    }

    /**
     * Method to get all employees.
     *
     * @return list of all employees
     */
    public List<Employee> getAllEmployees() {
        logger.info("Fetching all employees");
        return (List<Employee>) employeeRepository.findAll();
    }
}
