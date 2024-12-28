package itk.academy.orekhov.employee_department.service;

import itk.academy.orekhov.employee_department.entity.Department;
import itk.academy.orekhov.employee_department.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DepartmentServiceTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentService departmentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);  // Инициализация моков
    }

    @Test
    public void testSaveDepartment() {
        // Создание объекта department
        Department department = new Department();
        department.setName("Human Resources");

        // Мокируем поведение репозитория
        when(departmentRepository.save(department)).thenReturn(department);

        // Вызов метода сервиса
        Department savedDepartment = departmentService.saveDepartment(department);

        // Проверки
        assertNotNull(savedDepartment);
        assertEquals("Human Resources", savedDepartment.getName());

        // Проверка взаимодействия с репозиторием
        verify(departmentRepository, times(1)).save(department);
    }

    @Test
    public void testGetAllDepartments() {
        // Создание списка департаментов
        Department department1 = new Department();
        department1.setName("IT");

        Department department2 = new Department();
        department2.setName("HR");

        List<Department> departments = Arrays.asList(department1, department2);

        // Мокируем поведение репозитория
        when(departmentRepository.findAll()).thenReturn(departments);

        // Вызов метода сервиса
        List<Department> foundDepartments = departmentService.getAllDepartments();

        // Проверки
        assertNotNull(foundDepartments);
        assertEquals(2, foundDepartments.size());
        assertEquals("IT", foundDepartments.get(0).getName());
        assertEquals("HR", foundDepartments.get(1).getName());

        // Проверка взаимодействия с репозиторием
        verify(departmentRepository, times(1)).findAll();
    }
}
