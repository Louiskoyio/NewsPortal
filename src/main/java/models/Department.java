package models;


//Departments name, description, number of employees in the department.

import java.util.Objects;

public class Department {
    private int department_id;
    private String department_name;
    private String description;

    public Department(String department_name, String description) {
        this.department_name = department_name;
        this.description = description;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return department_id == that.department_id &&
                Objects.equals(department_name, that.department_name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department_id, department_name, description);
    }
}
