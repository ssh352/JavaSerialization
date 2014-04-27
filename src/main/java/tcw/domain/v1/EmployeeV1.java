package tcw.domain.v1;

import java.io.Serializable;

public class EmployeeV1 implements Serializable {

    private static final long serialVersionUID = 1L;


    private int employeeId;
    private String employeeName;
    private String department;
    private AddressV1 addressV1;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public AddressV1 getAddressV1() {
        return addressV1;
    }

    public void setAddressV1(AddressV1 addressV1) {
        this.addressV1 = addressV1;
    }

    @Override
    public String toString() {
        return "EmployeeExtV1{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", department='" + department + '\'' +
                ", addressV1=" + addressV1 +
                '}';
    }
}
