package tcw.serialzation.jackson;


import com.google.common.base.Stopwatch;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import tcw.domain.Employee;
import tcw.serialzation.HelperUtils;
import tcw.serialzation.Populated;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import static tcw.serialzation.Populated.POPULATION_SIZE;

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
        List<Employee> employees = Populated.employees(POPULATION_SIZE);
        Stopwatch stopwatch = Stopwatch.createStarted();
        Employee deserializedEmployee = null;
        for (Employee employee : employees) {
            byte[] serializedEmployee = jacksonSerializer.serialize(employee);
            deserializedEmployee = jacksonSerializer.deserialize(serializedEmployee);
        }
        stopwatch.stop();
        System.out.println(stopwatch.toString());
    }


}
