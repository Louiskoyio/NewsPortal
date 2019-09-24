package models;


import java.util.Objects;

// position in the company, their roles, which department(s) they are associated with etc
public class User {
    private int employee_id;
    private String fname;
    private String lname;
    private String position;
    private String employee_role;
    private int department_id;

    public User(int employee_id, String fname, String lname, String position, String employee_role, int department_id) {
        this.employee_id = employee_id;
        this.fname = fname;
        this.lname = lname;
        this.position = position;
        this.employee_role = employee_role;
        this.department_id = department_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRole() {
        return employee_role;
    }

    public void setRole(String employee_role) {
        this.employee_role = employee_role;
    }

    public int getDepartment() {
        return department_id;
    }

    public void setDepartment(int department) {
        this.department_id = department_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return employee_id == user.employee_id &&
                Objects.equals(fname, user.fname) &&
                Objects.equals(lname, user.lname) &&
                Objects.equals(position, user.position) &&
                Objects.equals(employee_role, user.employee_role) &&
                Objects.equals(department_id, user.department_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_id, fname, lname, position, employee_role, department_id);
    }
}
