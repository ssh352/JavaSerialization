package tcw.serialzation.avro;

import com.google.common.base.Stopwatch;
import org.junit.Test;
import tcw.domain.avro.java.EmployeeAvroV1;
import tcw.domain.util.Populated;

public class AvroSerializerTest {

    @Test
    public void validation() throws Exception {
        AvroSerializer avroSerializer = new AvroSerializer();
        EmployeeAvroV1 employeeV1 = Populated.avroEmployee();
        byte[] serializedEmployee = avroSerializer.serialize(employeeV1);
        EmployeeAvroV1 deserializedEmployeeV1 = avroSerializer.deserialize(serializedEmployee);
        System.out.println(deserializedEmployeeV1);
    }

    @Test
    public void benchmark() throws Exception {
        AvroSerializer avroSerializer = new AvroSerializer();
        EmployeeAvroV1 employeeV1 = Populated.avroEmployee();
        EmployeeAvroV1 deserializedEmployeeV1 = null;
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 1000000; i++) {
            byte[] serializedEmployee = avroSerializer.serialize(employeeV1);
            deserializedEmployeeV1 = avroSerializer.deserialize(serializedEmployee);
        }
        stopwatch.stop();
        System.out.println(stopwatch.toString());
    }

}
