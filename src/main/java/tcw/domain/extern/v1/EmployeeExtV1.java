package tcw.domain.extern.v1;

import java.io.*;

public class EmployeeExtV1 implements Externalizable {

    private static final long serialVersionUID = 1L;

    private int employeeId;
    private String employeeName;
    private String department;
    private AddressExtV1 addressExtV1;

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

    public AddressExtV1 getAddressExtV1() {
        return addressExtV1;
    }

    public void setAddressExtV1(AddressExtV1 addressExtV1) {
        this.addressExtV1 = addressExtV1;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(employeeId);
        out.writeObject(employeeName);
        out.writeObject(department);
        out.writeObject(addressExtV1);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        employeeId = in.readInt();
        employeeName = (String) in.readObject();
        department = (String) in.readObject();
        addressExtV1 = (AddressExtV1) in.readObject();
    }

    @Override
    public String toString() {
        return "EmployeeExtV1{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", department='" + department + '\'' +
                ", addressExtV1=" + addressExtV1 +
                '}';
    }
}
