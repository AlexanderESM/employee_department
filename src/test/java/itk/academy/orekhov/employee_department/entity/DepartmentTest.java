package itk.academy.orekhov.employee_department.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @Test
    void testConstructorAndGetters() {
        // Arrange
        String name = "HR";

        // Act
        Department department = new Department(name);

        // Assert
        assertNull(department.getId()); // ID should be null before persistence
        assertEquals(name, department.getName());
    }

    @Test
    void testSetters() {
        // Arrange
        Department department = new Department();
        Long id = 1L;
        String name = "IT";

        // Act
        department.setId(id);
        department.setName(name);

        // Assert
        assertEquals(id, department.getId());
        assertEquals(name, department.getName());
    }

    @Test
    void testEqualsAndHashCode() {
        // Arrange
        Department department1 = new Department("Finance");
        department1.setId(1L);

        Department department2 = new Department("Finance");
        department2.setId(1L);

        Department department3 = new Department("Finance");
        department3.setId(2L);

        // Act & Assert
        assertEquals(department1, department2); // Same ID, should be equal
        assertNotEquals(department1, department3); // Different ID, should not be equal

        assertEquals(department1.hashCode(), department2.hashCode()); // Same ID, hashCodes should match
        assertNotEquals(department1.hashCode(), department3.hashCode()); // Different ID, hashCodes should not match
    }

    @Test
    void testDefaultConstructor() {
        // Act
        Department department = new Department();

        // Assert
        assertNull(department.getId());
        assertNull(department.getName());
    }
}
