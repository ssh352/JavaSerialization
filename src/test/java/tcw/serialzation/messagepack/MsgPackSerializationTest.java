package tcw.serialzation.messagepack;


import com.google.common.base.Stopwatch;
import org.junit.Test;
import tcw.domain.util.Populated;
import tcw.domain.v1.EmployeeV1;

public class MsgPackSerializationTest {

    @Test
    public void validation() throws Exception {
        MsgPackSerialization msgPackSerialization = new MsgPackSerialization();
        EmployeeV1 employeeV1 = Populated.employee();
        byte[] serializedEmployee = msgPackSerialization.serialize(employeeV1);
        EmployeeV1 deserializedEmployeeV1 = msgPackSerialization.deserialize(serializedEmployee);
        System.out.println(deserializedEmployeeV1);
    }

    @Test
    public void benchmark() throws Exception {
        MsgPackSerialization msgPackSerialization = new MsgPackSerialization();
        EmployeeV1 employeeV1 = Populated.employee();
        EmployeeV1 deserializedEmployeeV1 = null;
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 1000000; i++) {
            byte[] serializedEmployee = msgPackSerialization.serialize(employeeV1);
            deserializedEmployeeV1 = msgPackSerialization.deserialize(serializedEmployee);
        }
        stopwatch.stop();
        System.out.println(stopwatch.toString());
    }


}
