package tcw.serialzation.protobuf;


import com.google.common.base.Stopwatch;
import org.junit.Test;
import tcw.domain.protobuf.EmployeeProto;
import tcw.domain.util.Populated;

public class ProtobufSerializerTest {


    @Test
    public void validation() throws Exception {
        EmployeeProto.EmployeeProtobuf employeeProtobuf = Populated.protobufEmployee();
        byte[] bytes = employeeProtobuf.toByteArray();
        EmployeeProto.EmployeeProtobuf employeeProtobufObject = EmployeeProto.EmployeeProtobuf.newBuilder().mergeFrom(bytes).build();
        System.out.println(employeeProtobufObject);
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
