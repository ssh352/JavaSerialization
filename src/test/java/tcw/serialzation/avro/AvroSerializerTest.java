package tcw.serialzation.avro;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import org.junit.Test;
import tcw.domain.avro.java.EmployeeAvroV1;
import tcw.domain.util.Populated;
import tcw.serialzation.HelperUtils;

import java.util.List;

public class AvroSerializerTest {

    @Test
    public void validation() throws Exception {
        AvroSerializer avroSerializer = new AvroSerializer();
        EmployeeAvroV1 employeeV1 = Populated.avroEmployee();
        byte[] serializedEmployee = avroSerializer.serialize(Lists.newArrayList(employeeV1));
        List<EmployeeAvroV1> employeeAvroV1s = avroSerializer.deserialize(serializedEmployee);
        System.out.println(employeeAvroV1s.get(0));
    }

    @Test
    public void serializationSize() throws Exception {
        AvroSerializer avroSerializer = new AvroSerializer();
        EmployeeAvroV1 employeeV1 = Populated.avroEmployee();
        byte[] serializedEmployee = avroSerializer.serialize(Lists.newArrayList(employeeV1));
        String hex = HelperUtils.prettyHex16(serializedEmployee);
        System.out.println("SIZE: " + serializedEmployee.length + " bytes");
        System.out.println(hex);
    }


    @Test
    public void benchmark() throws Exception {
        AvroSerializer avroSerializer = new AvroSerializer();
        EmployeeAvroV1 deserializedEmployeeV1 = null;
        List<EmployeeAvroV1> avorEmployees = Lists.newArrayList();
        for (int i = 0; i < 1000000; i++) {
            avorEmployees.add(Populated.avroEmployee());
        }
        Stopwatch stopwatch = Stopwatch.createStarted();
        byte[] serializedEmployee = avroSerializer.serialize(avorEmployees);
        List<EmployeeAvroV1> deserialized = avroSerializer.deserialize(serializedEmployee);
        stopwatch.stop();
        System.out.println(stopwatch.toString());
    }

}
