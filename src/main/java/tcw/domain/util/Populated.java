package tcw.domain.util;


import com.google.common.collect.Lists;
import tcw.domain.Employee;
import tcw.domain.avro.java.AddressAvroV1;
import tcw.domain.avro.java.EmployeeAvroV1;
import tcw.domain.extern.v1.AddressExtV1;
import tcw.domain.extern.v1.EmployeeExtV1;
import tcw.domain.protobuf.EmployeeProto;
import tcw.domain.sbe.AddressSbe;
import tcw.domain.sbe.EmployeeSbe;
import tcw.domain.v1.AddressV1;
import tcw.domain.v1.EmployeeV1;

import java.io.UnsupportedEncodingException;

public class Populated {

    public static Employee employee(){
        Employee employee = new Employee();
        employee.setEmployeeId(1234567891011L);
        employee.setSalery(123456.12);
        employee.setEmployeeName("John Doe");
        employee.setDepartments(Lists.newArrayList("IT","RD","TECH"));
        return employee;
    }

    public static tcw.domain.extern.Employee employeeExtern(){
        tcw.domain.extern.Employee employee = new tcw.domain.extern.Employee();
        employee.setEmployeeId(1234567891011L);
        employee.setSalery(123456.12);
        employee.setEmployeeName("John Doe");
        employee.setDepartments(Lists.newArrayList("IT", "RD", "TECH"));
        return employee;
    }

    public static tcw.domain.messagepack.Employee employeeMessagepack(){
        tcw.domain.messagepack.Employee employee = new tcw.domain.messagepack.Employee();
        employee.setEmployeeId(1234567891011L);
        employee.setSalery(123456.12);
        employee.setEmployeeName("John Doe");
        employee.setDepartments(Lists.newArrayList("IT","RD","TECH"));
        return employee;
    }


    public static EmployeeAvroV1 avroEmployee(){
        AddressAvroV1 addressExtV1 = new AddressAvroV1();
        addressExtV1.setCity("New York");
        addressExtV1.setHomeNo(555234124);
        addressExtV1.setStreet("Harlem");

        EmployeeAvroV1 employeeExtV1 = new EmployeeAvroV1();
        employeeExtV1.setEmployeeId(12345);
        employeeExtV1.setDepartment("IT");
        employeeExtV1.setEmployeeName("John Doe");
        employeeExtV1.setAddressV1(addressExtV1);
        return employeeExtV1;
    }

    public static EmployeeProto.EmployeeProtobuf protobufEmployee(){
        return EmployeeProto.EmployeeProtobuf.newBuilder()
                .setEmployeeId(12345)
                .setDepartment("IT")
                .setEmployeeName("John Doe")
                .addAddress(EmployeeProto.EmployeeProtobuf.Address.newBuilder()
                        .setHomeNo(555234124)
                        .setCity("New York")
                        .setStreet("Harlem").build()).build();
    }
}
