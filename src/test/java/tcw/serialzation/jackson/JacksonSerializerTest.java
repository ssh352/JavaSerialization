package tcw.serialzation.jackson;


import com.google.common.base.Stopwatch;
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
        JacksonSerializer jacksonSerializer = new JacksonSerializer();
        List<Employee> employees = Populator.employees(POPULATION_SIZE);
        Stopwatch stopwatch = Stopwatch.createStarted();
        Employee deserializedEmployee = null;
        byte[] serializedEmployee = null;
        for (Employee employee : employees) {
            serializedEmployee = jacksonSerializer.serialize(employee);
            deserializedEmployee = jacksonSerializer.deserialize(serializedEmployee);
        }
        stopwatch.stop();
        byte b = serializedEmployee[0];
        System.out.println("Jackson:" + stopwatch.toString());
        return stopwatch.elapsed(TimeUnit.NANOSECONDS);
    }


}
