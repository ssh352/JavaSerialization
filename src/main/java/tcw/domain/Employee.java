package tcw.domain;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private long employeeId;
    private double salery;
    private boolean consultant;
    private String employeeName;
    private List<String> departments;


    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalery() {
        return salery;
    }

    public void setSalery(double salery) {
        this.salery = salery;
    }

    public boolean isConsultant() {
        return consultant;
    }

    public void setConsultant(boolean consultant) {
        this.consultant = consultant;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", salery=" + salery +
                ", consultant=" + consultant +
                ", employeeName='" + employeeName + '\'' +
                ", departments=" + departments +
                '}';
    }
}
