package itk.academy.orekhov.employee_department.employeeapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeProjectionTest {

    @Test
    void testConstructorAndGetters() {
        // Arrange
        String fullName = "John Doe";
        String position = "Developer";
        String departmentName = "IT";

        // Act
        EmployeeProjection projection = new EmployeeProjection(fullName, position, departmentName);

        // Assert
        assertEquals(fullName, projection.getFullName());
        assertEquals(position, projection.getPosition());
        assertEquals(departmentName, projection.getDepartmentName());
    }

    @Test
    void testSetters() {
        // Arrange
        EmployeeProjection projection = new EmployeeProjection("", "", "");

        String fullName = "Jane Smith";
        String position = "Manager";
        String departmentName = "HR";

        // Act
        projection.setFullName(fullName);
        projection.setPosition(position);
        projection.setDepartmentName(departmentName);

        // Assert
        assertEquals(fullName, projection.getFullName());
        assertEquals(position, projection.getPosition());
        assertEquals(departmentName, projection.getDepartmentName());
    }

    @Test
    void testDefaultValues() {
        // Act
        EmployeeProjection projection = new EmployeeProjection(null, null, null);

        // Assert
        assertNull(projection.getFullName());
        assertNull(projection.getPosition());
        assertNull(projection.getDepartmentName());
    }
}
