package itk.academy.orekhov.employee_department.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testConstructorAndGetters() {
        // Arrange
        Department department = new Department("IT");
        String firstName = "John";
        String lastName = "Doe";
        String position = "Developer";
        double salary = 75000.00;

        // Act
        Employee employee = new Employee(firstName, lastName, position, salary, department);

        // Assert
        assertNull(employee.getId()); // ID should be null before persistence
        assertEquals(firstName, employee.getFirstName());
        assertEquals(lastName, employee.getLastName());
        assertEquals(position, employee.getPosition());
        assertEquals(salary, employee.getSalary());
        assertEquals(department, employee.getDepartment());
    }

    @Test
    void testSetters() {
        // Arrange
        Employee employee = new Employee();
        Department department = new Department("HR");
        Long id = 1L;
        String firstName = "Jane";
        String lastName = "Smith";
        String position = "Manager";
        double salary = 85000.00;

        // Act
        employee.setId(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setPosition(position);
        employee.setSalary(salary);
        employee.setDepartment(department);

        // Assert
        assertEquals(id, employee.getId());
        assertEquals(firstName, employee.getFirstName());
        assertEquals(lastName, employee.getLastName());
        assertEquals(position, employee.getPosition());
        assertEquals(salary, employee.getSalary());
        assertEquals(department, employee.getDepartment());
    }

    @Test
    void testEqualsAndHashCode() {
        // Arrange
        Department department = new Department("Finance");
        Employee employee1 = new Employee("Alice", "Brown", "Analyst", 65000.00, department);
        employee1.setId(1L);

        Employee employee2 = new Employee("Alice", "Brown", "Analyst", 65000.00, department);
        employee2.setId(1L);

        Employee employee3 = new Employee("Alice", "Brown", "Analyst", 65000.00, department);
        employee3.setId(2L);

        // Act & Assert
        assertEquals(employee1, employee2); // Same ID, should be equal
        assertNotEquals(employee1, employee3); // Different ID, should not be equal

        assertEquals(employee1.hashCode(), employee2.hashCode()); // Same ID, hashCodes should match
        assertNotEquals(employee1.hashCode(), employee3.hashCode()); // Different ID, hashCodes should not match
    }

    @Test
    void testDefaultConstructor() {
        // Act
        Employee employee = new Employee();

        // Assert
        assertNull(employee.getId());
        assertNull(employee.getFirstName());
        assertNull(employee.getLastName());
        assertNull(employee.getPosition());
        assertEquals(0.0, employee.getSalary());
        assertNull(employee.getDepartment());
    }
}
