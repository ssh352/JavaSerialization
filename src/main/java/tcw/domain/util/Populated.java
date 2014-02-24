package tcw.domain.util;


import tcw.domain.extern.v1.AddressExtV1;
import tcw.domain.extern.v1.EmployeeExtV1;
import tcw.domain.v1.AddressV1;
import tcw.domain.v1.EmployeeV1;

public class Populated {

    public static EmployeeV1 employee(){
        AddressV1 addressV1 = new AddressV1();
        addressV1.setCity("New York");
        addressV1.setHomeNo(555234124);
        addressV1.setStreet("Harlem");

        EmployeeV1 employeeExtV1 = new EmployeeV1();
        employeeExtV1.setEmployeeId(12345);
        employeeExtV1.setDepartment("IT");
        employeeExtV1.setEmployeeName("John Doe");
        employeeExtV1.setAddressV1(addressV1);
        return employeeExtV1;
    }

    public static EmployeeExtV1 extEmployee(){
        AddressExtV1 addressExtV1 = new AddressExtV1();
        addressExtV1.setCity("New York");
        addressExtV1.setHomeNo(555234124);
        addressExtV1.setStreet("Harlem");

        EmployeeExtV1 employeeExtV1 = new EmployeeExtV1();
        employeeExtV1.setEmployeeId(12345);
        employeeExtV1.setDepartment("IT");
        employeeExtV1.setEmployeeName("John Doe");
        employeeExtV1.setAddressExtV1(addressExtV1);
        return employeeExtV1;
    }
}
