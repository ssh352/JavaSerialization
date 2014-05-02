package tcw.serialzation.protobuf;


import com.google.common.base.Stopwatch;
import org.junit.Test;
import tcw.domain.protobuf.EmployeeProto;
import tcw.domain.protobuf.EmployeeProtoSimple;
import tcw.serialzation.HelperUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static tcw.serialzation.Populator.*;

public class ProtobufSerializerTest {

    @Test
    public void validation() throws Exception {
        EmployeeProto.Employee employeeProtobuf = protobufEmployee();
        byte[] bytes = employeeProtobuf.toByteArray();
        EmployeeProto.Employee employeeProtobufObject = EmployeeProto.Employee.newBuilder().mergeFrom(bytes).build();
        System.out.println(employeeProtobufObject);
    }

    @Test
    public void serializationSize() throws Exception {
        EmployeeProto.Employee employee = protobufEmployee();
        byte[] serializedEmployee = employee.toByteArray();
        String hex = HelperUtils.prettyHex16(serializedEmployee);
        System.out.println("SIZE: " + serializedEmployee.length + " bytes");
        System.out.println(hex);
        //42 bytes
    }

    public long benchmark() throws Exception {
        List<EmployeeProto.Employee> employees = protobufEmployees(POPULATION_SIZE);
        EmployeeProto.Employee employeeDeserilaized = null;
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (EmployeeProto.Employee employee : employees) {
            byte[] serializedEmployee = employee.toByteArray();
            employeeDeserilaized = EmployeeProto.Employee.newBuilder().mergeFrom(serializedEmployee).build();
        }
        stopwatch.stop();
        System.out.println("Protocol buffers:" + stopwatch.toString());
        return stopwatch.elapsed(TimeUnit.NANOSECONDS);
    }


    public long benchmarkSimple() throws Exception {
        List<EmployeeProtoSimple.EmployeeSimple> simpleEmployees = protobufSimpleEmployees(POPULATION_SIZE);
        EmployeeProtoSimple.EmployeeSimple employeeDeserilaized = null;
        Stopwatch stopwatch = Stopwatch.createStarted();
        byte[] serializedEmployee = null;
        for (EmployeeProtoSimple.EmployeeSimple employee : simpleEmployees) {
            serializedEmployee = employee.toByteArray();
            employeeDeserilaized = EmployeeProtoSimple.EmployeeSimple.newBuilder().mergeFrom(serializedEmployee).build();
        }
        stopwatch.stop();
        byte b = serializedEmployee[0];
        System.out.println("Protocol buffers simple:" + stopwatch.toString());
        return stopwatch.elapsed(TimeUnit.NANOSECONDS);
    }

}
