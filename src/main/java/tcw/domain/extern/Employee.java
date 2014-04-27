package tcw.domain.extern;

import tcw.domain.extern.v1.AddressExtV1;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

public class Employee implements Externalizable {

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

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeLong(employeeId);
        out.writeDouble(salery);
        out.writeBoolean(consultant);
        out.writeObject(employeeName);
        out.writeObject(departments);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        employeeId = in.readLong();
        salery = in.readDouble();
        consultant = in.readBoolean();
        employeeName = (String) in.readObject();
        departments = (List<String>) in.readObject();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", salery=" + salery +
                ", consultant=" + consultant +
                ", employeeName='" + employeeName + '\'' +
                ", departments='" + departments + '\'' +
                '}';
    }
}
