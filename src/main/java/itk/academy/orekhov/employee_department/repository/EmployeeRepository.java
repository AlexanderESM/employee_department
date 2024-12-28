package itk.academy.orekhov.employee_department.repository;

import itk.academy.orekhov.employee_department.employeeapp.EmployeeProjection;
import itk.academy.orekhov.employee_department.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT new itk.academy.orekhov.employee_department.employeeapp.EmployeeProjection(" +
            "e.firstName || ' ' || e.lastName, e.position, d.name) " +
            "FROM Employee e JOIN e.department d")
    List<EmployeeProjection> findAllEmployeeProjections();
}
