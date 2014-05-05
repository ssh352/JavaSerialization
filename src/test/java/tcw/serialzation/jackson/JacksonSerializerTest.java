package tcw.serialzation.jackson;


import com.google.common.base.Stopwatch;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import tcw.domain.Employee;
import tcw.serialzation.HelperUtils;
import tcw.serialzation.Populator;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static tcw.serialzation.Populator.POPULATION_SIZE;

public class JacksonSerializerTest {


    @Test
    public void validation() throws Exception {
        JacksonSerializer jacksonSerializer = new JacksonSerializer();
        Employee employee = Populator.employee();
        byte[] serializedEmployee = jacksonSerializer.serialize(employee);
        Employee deserializedEmployee = jacksonSerializer.deserialize(serializedEmployee);
        System.out.println(deserializedEmployee);
    }


    @Test
    public void serializationSize() throws Exception {
        JacksonSerializer jacksonSerializer = new JacksonSerializer();
        Employee employee = Populator.employee();
        byte[] serializedEmployee = jacksonSerializer.serialize(employee);
        String hex = HelperUtils.prettyHex16(serializedEmployee);
        System.out.println("SIZE: " + serializedEmployee.length + " bytes");
        System.out.println(hex);
    }


    public long benchmark() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<Employee> employees = Populator.employees(POPULATION_SIZE);
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (Employee employee : employees) {
            mapper.readValue(mapper.writeValueAsBytes(employee),Employee.class);
        }
        stopwatch.stop();
        return stopwatch.elapsed(TimeUnit.NANOSECONDS);
    }


}
