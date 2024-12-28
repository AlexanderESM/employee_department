package itk.academy.orekhov.employee_department.service;

import itk.academy.orekhov.employee_department.employeeapp.EmployeeProjection;
import itk.academy.orekhov.employee_department.entity.Employee;
import itk.academy.orekhov.employee_department.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);  // Инициализация моков
    }

    @Test
    public void testCreateEmployee() {
        // Создание объекта Employee
        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");

        // Мокируем поведение репозитория
        when(employeeRepository.save(employee)).thenReturn(employee);

        // Вызов метода сервиса
        Employee createdEmployee = employeeService.createEmployee(employee);

        // Проверки
        assertNotNull(createdEmployee);
        assertEquals("John", createdEmployee.getFirstName());
        assertEquals("Doe", createdEmployee.getLastName());

        // Проверка взаимодействия с репозиторием
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    public void testGetAllEmployees() {
        // Создание списка сотрудников
        Employee employee1 = new Employee();
        employee1.setFirstName("Alice");
        employee1.setLastName("Smith");

        Employee employee2 = new Employee();
        employee2.setFirstName("Bob");
        employee2.setLastName("Johnson");

        List<Employee> employees = Arrays.asList(employee1, employee2);

        // Мокируем поведение репозитория
        when(employeeRepository.findAll()).thenReturn(employees);

        // Вызов метода сервиса
        List<Employee> foundEmployees = employeeService.getAllEmployees();

        // Проверки
        assertNotNull(foundEmployees);
        assertEquals(2, foundEmployees.size());
        assertEquals("Alice", foundEmployees.get(0).getFirstName());
        assertEquals("Bob", foundEmployees.get(1).getFirstName());

        // Проверка взаимодействия с репозиторием
        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    public void testGetAllEmployeeProjections() {
        // Создание EmployeeProjection
        EmployeeProjection employeeProjection1 = mock(EmployeeProjection.class);
        EmployeeProjection employeeProjection2 = mock(EmployeeProjection.class);

        List<EmployeeProjection> projections = Arrays.asList(employeeProjection1, employeeProjection2);

        // Мокируем поведение репозитория
        when(employeeRepository.findAllEmployeeProjections()).thenReturn(projections);

        // Вызов метода сервиса
        List<EmployeeProjection> foundProjections = employeeService.getAllEmployeeProjections();

        // Проверки
        assertNotNull(foundProjections);
        assertEquals(2, foundProjections.size());

        // Проверка взаимодействия с репозиторием
        verify(employeeRepository, times(1)).findAllEmployeeProjections();
    }
}
