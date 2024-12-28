package itk.academy.orekhov.employee_department.service;

import itk.academy.orekhov.employee_department.entity.Department;
import itk.academy.orekhov.employee_department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Service class for Department operations.
 */
@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    /**
     * Creates a new department.
     *
     * @param department the department to create
     * @return the created department
     */
    public Department saveDepartment(Department department) {
        logger.info("Saving department: {}", department.getName());
        return departmentRepository.save(department);
    }

    /**
     * Gets all departments.
     *
     * @return list of all departments
     */
    public List<Department> getAllDepartments() {
        logger.info("Fetching all departments");
        return (List<Department>) departmentRepository.findAll();
    }
}
