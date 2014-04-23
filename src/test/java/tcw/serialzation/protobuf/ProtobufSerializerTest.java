package tcw.serialzation.protobuf;


import com.google.common.base.Stopwatch;
import org.junit.Test;
import tcw.domain.protobuf.EmployeeProto;
import tcw.domain.util.Populated;
import tcw.domain.v1.EmployeeV1;
import tcw.serialzation.HelperUtils;
import tcw.serialzation.plain.PlainSerialization;

public class ProtobufSerializerTest {


    @Test
    public void validation() throws Exception {
        EmployeeProto.EmployeeProtobuf employeeProtobuf = Populated.protobufEmployee();
        byte[] bytes = employeeProtobuf.toByteArray();
        EmployeeProto.EmployeeProtobuf employeeProtobufObject = EmployeeProto.EmployeeProtobuf.newBuilder().mergeFrom(bytes).build();
        System.out.println(employeeProtobufObject);
    }

    @Test
    public void serializationSize() throws Exception {
        EmployeeProto.EmployeeProtobuf employeeProtobuf = Populated.protobufEmployee();
        byte[] serializedEmployee = employeeProtobuf.toByteArray();
        String hex = HelperUtils.prettyHex16(serializedEmployee);
        System.out.println("SIZE: " + serializedEmployee.length + " bytes");
        System.out.println(hex);
    }

    @Test
    public void benchmark() throws Exception {
        EmployeeProto.EmployeeProtobuf employeeProtobuf = Populated.protobufEmployee();
        EmployeeProto.EmployeeProtobuf employee = null;
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 1000000; i++) {
            byte[] serializedEmployee = employeeProtobuf.toByteArray();
            employee = EmployeeProto.EmployeeProtobuf.newBuilder().mergeFrom(serializedEmployee).build();
        }
        stopwatch.stop();
        System.out.println(stopwatch.toString());
    }


}
