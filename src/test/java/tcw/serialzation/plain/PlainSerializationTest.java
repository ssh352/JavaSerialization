package tcw.serialzation.plain;


import com.google.common.base.Stopwatch;
import org.junit.Test;
import tcw.domain.util.Populated;
import tcw.domain.v1.EmployeeV1;
import tcw.serialzation.HelperUtils;
import tcw.serialzation.messagepack.MsgPackSerialization;

public class PlainSerializationTest {

    @Test
    public void validation() throws Exception {
        PlainSerialization plainSerialization = new PlainSerialization();
        EmployeeV1 employeeV1 = Populated.employee();
        byte[] serializedEmployee = plainSerialization.serialize(employeeV1);
        EmployeeV1 deserializedEmployeeV1 = plainSerialization.deserialize(serializedEmployee);
        System.out.println(deserializedEmployeeV1);
    }

    @Test
    public void serializationSize() throws Exception {
        PlainSerialization plainSerialization = new PlainSerialization();
        EmployeeV1 employeeV1 = Populated.employee();
        byte[] serializedEmployee = plainSerialization.serialize(employeeV1);
        String hex = HelperUtils.prettyHex16(serializedEmployee);
        System.out.println("SIZE: " + serializedEmployee.length + " bytes");
        System.out.println(hex);
    }

    @Test
    public void benchmark() throws Exception {
        PlainSerialization plainSerialization = new PlainSerialization();
        EmployeeV1 employeeV1 = Populated.employee();
        EmployeeV1 deserializedEmployeeV1 = null;
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 1000000; i++) {
            byte[] serializedEmployee = plainSerialization.serialize(employeeV1);
            deserializedEmployeeV1 = plainSerialization.deserialize(serializedEmployee);
        }
       stopwatch.stop();
        System.out.println(stopwatch.toString());
    }
}
