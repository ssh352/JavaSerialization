package tcw.serialzation.protobuf;


import com.google.common.base.Stopwatch;
import org.junit.Test;
import tcw.domain.protobuf.EmployeeProto;
import tcw.serialzation.HelperUtils;
import tcw.serialzation.Populated;
import tcw.serialzation.plain.PlainSerialization;

import java.util.List;

import static tcw.serialzation.Populated.*;

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

    @Test
    public void benchmark() throws Exception {
        List<EmployeeProto.Employee> employees = protobufEmployees(POPULATION_SIZE);
        EmployeeProto.Employee employeeDeserilaized = null;
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (EmployeeProto.Employee employee : employees) {
            byte[] serializedEmployee = employee.toByteArray();
            employeeDeserilaized = EmployeeProto.Employee.newBuilder().mergeFrom(serializedEmployee).build();
        }
        stopwatch.stop();
        System.out.println(stopwatch.toString());
    }


}
