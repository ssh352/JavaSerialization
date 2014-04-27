package tcw.serialzation.jackson;


import com.google.common.base.Stopwatch;
import org.junit.Test;
import tcw.domain.Employee;
import tcw.domain.util.Populated;
import tcw.domain.v1.EmployeeV1;
import tcw.serialzation.HelperUtils;

public class JacksonSerializerTest {


    @Test
    public void validation() throws Exception {
        JacksonSerializer jacksonSerializer = new JacksonSerializer();
        Employee employee = Populated.employee();
        byte[] serializedEmployee = jacksonSerializer.serialize(employee);
        Employee deserializedEmployee = jacksonSerializer.deserialize(serializedEmployee);
        System.out.println(deserializedEmployee);
    }


    @Test
    public void serializationSize() throws Exception {
        JacksonSerializer jacksonSerializer = new JacksonSerializer();
        Employee employee = Populated.employee();
        byte[] serializedEmployee = jacksonSerializer.serialize(employee);
        String hex = HelperUtils.prettyHex16(serializedEmployee);
        System.out.println("SIZE: " + serializedEmployee.length + " bytes");
        System.out.println(hex);
    }


    @Test
    public void benchmark() throws Exception {
        JacksonSerializer jacksonSerializer = new JacksonSerializer();
        Employee employee = Populated.employee();
        Employee deserializedEmployeeV1 = null;
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 1000000; i++) {
            byte[] serializedEmployee = jacksonSerializer.serialize(employee);
            deserializedEmployeeV1 = jacksonSerializer.deserialize(serializedEmployee);
        }
        stopwatch.stop();
        System.out.println(stopwatch.toString());
    }


}
