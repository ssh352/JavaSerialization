package tcw.domain.messagepack;

import org.msgpack.packer.Packer;
import org.msgpack.template.Template;
import org.msgpack.template.Templates;
import org.msgpack.unpacker.Unpacker;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

public class Employee {

    private static final long serialVersionUID = 1L;

    private long employeeId;
    private double salery;
    private boolean consultant;
    private String employeeName;
    private List<String> departments;
    private final Template listStringTemp = Templates.tList(Templates.TString);

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

    //Har side-effekt
    public void serialize(Packer packer) throws IOException {
        packer.write(employeeId);
        packer.write(salery);
        packer.write(consultant);
        packer.write(employeeName);
        packer.write(departments);
    }

    public void deserialize(Unpacker unpacker) throws IOException {
        employeeId = unpacker.readLong();
        salery = unpacker.readDouble();
        consultant = unpacker.readBoolean();
        employeeName = unpacker.readString();
        departments = (List<String>) unpacker.read(listStringTemp);
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
