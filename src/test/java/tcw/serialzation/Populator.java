package tcw.serialzation;


import com.google.common.collect.Lists;
import tcw.domain.Employee;
import tcw.domain.protobuf.EmployeeProto;
import tcw.domain.protobuf.EmployeeProtoSimple;

import java.util.ArrayList;
import java.util.List;

public class Populator {

    public static final int POPULATION_SIZE = 1000000;

    public static Employee employee() {
        Employee employee = new Employee();
        employee.setEmployeeId(1234567891011L);
        employee.setSalery(123456.12);
        employee.setConsultant(true);
        employee.setEmployeeName("John Doe");
        employee.setDepartments(Lists.newArrayList("IT", "RD", "TECH"));
        return employee;
    }

    public static List<Employee> employees(int amount) {
        List<Employee> employees = new ArrayList<Employee>(POPULATION_SIZE); //To reduce GC
        for (int i = 0; i < amount; i++) {
            Employee employee = new Employee();
            employee.setEmployeeId(1234567891011L + i);
            employee.setSalery(123456.12);
            employee.setConsultant(true);
            employee.setEmployeeName("John Doe");
            employee.setDepartments(Lists.newArrayList("IT", "RD", "TECH"));
            employees.add(employee);
        }
        return employees;
    }

    public static tcw.domain.extern.Employee employeeExtern() {
        tcw.domain.extern.Employee employee = new tcw.domain.extern.Employee();
        employee.setEmployeeId(1234567891011L);
        employee.setSalery(123456.12);
        employee.setConsultant(true);
        employee.setEmployeeName("John Doe");
        employee.setDepartments(Lists.newArrayList("IT", "RD", "TECH"));
        return employee;
    }

    public static List<tcw.domain.extern.Employee> employeesExtern(int amount) {
        List<tcw.domain.extern.Employee> employees = new ArrayList<tcw.domain.extern.Employee>(POPULATION_SIZE);//To reduce GC
        for (int i = 0; i < amount; i++) {
            tcw.domain.extern.Employee employee = new tcw.domain.extern.Employee();
            employee.setEmployeeId(1234567891011L + i);
            employee.setSalery(123456.12);
            employee.setConsultant(true);
            employee.setEmployeeName("John Doe");
            employee.setDepartments(Lists.newArrayList("IT", "RD", "TECH"));
            employees.add(employee);
        }
        return employees;
    }

    public static tcw.domain.messagepack.Employee employeeMessagepack() {
        tcw.domain.messagepack.Employee employee = new tcw.domain.messagepack.Employee();
        employee.setEmployeeId(1234567891011L);
        employee.setSalery(123456.12);
        employee.setConsultant(true);
        employee.setEmployeeName("John Doe");
        employee.setDepartments(Lists.newArrayList("IT", "RD", "TECH"));
        return employee;
    }

    public static List<tcw.domain.messagepack.Employee> employeesMessagepack(int amount) {
        List<tcw.domain.messagepack.Employee> employees =new ArrayList<tcw.domain.messagepack.Employee>(POPULATION_SIZE);//To reduce GC
        for (int i = 0; i < amount; i++) {
            tcw.domain.messagepack.Employee employee = new tcw.domain.messagepack.Employee();
            employee.setEmployeeId(1234567891011L);
            employee.setSalery(123456.12);
            employee.setConsultant(true);
            employee.setEmployeeName("John Doe");
            employee.setDepartments(Lists.newArrayList("IT", "RD", "TECH"));
            employees.add(employee);
        }
        return employees;
    }


    public static tcw.domain.avro.java.Employee avroEmployee() {
        tcw.domain.avro.java.Employee employee = new tcw.domain.avro.java.Employee();
        employee.setEmployeeId(1234567891011L);
        employee.setSalery(123456.12);
        employee.setConsultant(true);
        employee.setEmployeeName("John Doe");
        employee.setDepartments(Lists.<CharSequence>newArrayList("IT", "RD", "TECH"));
        return employee;
    }

    public static List<tcw.domain.avro.java.Employee> avroEmployees(int amount) {
        List<tcw.domain.avro.java.Employee> employees = new ArrayList<tcw.domain.avro.java.Employee>(POPULATION_SIZE);//To reduce GC
        for (int i = 0; i < amount; i++) {
            tcw.domain.avro.java.Employee employee = new tcw.domain.avro.java.Employee();
            employee.setEmployeeId(1234567891011L);
            employee.setSalery(123456.12);
            employee.setConsultant(true);
            employee.setEmployeeName("John Doe");
            employee.setDepartments(Lists.<CharSequence>newArrayList("IT", "RD", "TECH"));
            employees.add(employee);
        }
        return employees;
    }

    public static EmployeeProto.Employee protobufEmployee() {
        return EmployeeProto.Employee.newBuilder()
                .setEmployeeId(1234567891011L)
                .setSalery(123456.12)
                .setConsultant(true)
                .setEmployeeName("John Doe")
                .addAllDepartments(Lists.newArrayList("IT", "RD", "TECH")).build();
    }

    public static List<EmployeeProto.Employee> protobufEmployees(int amount) {
        List<EmployeeProto.Employee> employees = new ArrayList<EmployeeProto.Employee>(POPULATION_SIZE);//To reduce GC
        for (int i = 0; i < amount; i++) {
            employees.add(EmployeeProto.Employee.newBuilder()
                    .setEmployeeId(1234567891011L)
                    .setSalery(123456.12)
                    .setConsultant(true)
                    .setEmployeeName("John Doe")
                    .addAllDepartments(Lists.newArrayList("IT", "RD", "TECH")).build());
        }
        return employees;
    }

    public static List<EmployeeProtoSimple.EmployeeSimple> protobufSimpleEmployees(int amount) {
        List<EmployeeProtoSimple.EmployeeSimple> employees = new ArrayList<EmployeeProtoSimple.EmployeeSimple>(POPULATION_SIZE);//To reduce GC
        for (int i = 0; i < amount; i++) {
            employees.add(EmployeeProtoSimple.EmployeeSimple.newBuilder()
                    .setEmployeeId(1234567891011L)
                    .setSalery(123456.12)
                    .setConsultant(true)
                    .setEmployeeName("John Doe")
                    .setDepartmentA("IT")
                    .setDepartmentB("RD")
                    .setDepartmentC("TECH").build());
        }
        return employees;
    }
}