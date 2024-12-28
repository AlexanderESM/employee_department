package itk.academy.orekhov.employee_department.repository;

import itk.academy.orekhov.employee_department.entity.Department;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for Department entity.
 */
public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
