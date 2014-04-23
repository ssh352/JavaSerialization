package tcw.serialzation.kryo;

import com.google.common.base.Stopwatch;
import org.junit.Test;
import tcw.domain.util.Populated;
import tcw.domain.v1.EmployeeV1;
import tcw.serialzation.HelperUtils;

public class KryoSerializerTest {

    @Test
    public void validation() throws Exception {
        KryoSerializer kryoSerializer = new KryoSerializer();
        EmployeeV1 employeeV1 = Populated.employee();
        byte[] serializedEmployee = kryoSerializer.serialize(employeeV1);
        EmployeeV1 deserializedEmployeeV1 = kryoSerializer.deserialize(serializedEmployee);
        System.out.println(deserializedEmployeeV1);
    }

    @Test
    public void serializationSize() throws Exception {
        KryoSerializer kryoSerializer = new KryoSerializer();
        EmployeeV1 employeeV1 = Populated.employee();
        byte[] serializedEmployee = kryoSerializer.serialize(employeeV1);
        String hex = HelperUtils.prettyHex16(serializedEmployee);
        System.out.println("SIZE: " + serializedEmployee.length + " bytes");
        System.out.println(hex);
    }

    @Test
    public void benchmark() throws Exception {
        KryoSerializer kryoSerializer = new KryoSerializer();
        EmployeeV1 employeeV1 = Populated.employee();
        EmployeeV1 deserializedEmployeeV1 = null;
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 1000000; i++) {
            byte[] serializedEmployee = kryoSerializer.serialize(employeeV1);
            deserializedEmployeeV1 = kryoSerializer.deserialize(serializedEmployee);
        }
        stopwatch.stop();
        System.out.println(stopwatch.toString());
    }

}
