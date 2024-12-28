package itk.academy.orekhov.employee_department.employeeapp;

public class EmployeeProjection {

    private String fullName;
    private String position;
    private String departmentName;

    // Конструктор, который принимает три String
    public EmployeeProjection(String fullName, String position, String departmentName) {
        this.fullName = fullName;
        this.position = position;
        this.departmentName = departmentName;
    }

    // Getters и Setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
