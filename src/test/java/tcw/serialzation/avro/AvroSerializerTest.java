package tcw.serialzation.avro;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import org.junit.Test;
import tcw.domain.avro.java.Employee;
import tcw.serialzation.HelperUtils;
import tcw.serialzation.Populator;

import java.util.concurrent.TimeUnit;

import static tcw.serialzation.Populator.POPULATION_SIZE;

public class AvroSerializerTest {

    @Test
    public void validation() throws Exception {
        AvroSerializer avroSerializer = new AvroSerializer();
        Employee employee = Populator.avroEmployee();
        byte[] serializedEmployee = avroSerializer.serialize(Lists.newArrayList(employee));
        Employee deserializedEmployee= avroSerializer.deserialize(serializedEmployee);
        System.out.println(deserializedEmployee);
    }

    @Test
    public void serializationSize() throws Exception {
        AvroSerializer avroSerializer = new AvroSerializer();
        Employee employee = Populator.avroEmployee();
        byte[] serializedEmployee = avroSerializer.serialize(Lists.newArrayList(employee));
        String hex = HelperUtils.prettyHex16(serializedEmployee);
        System.out.println("SIZE: " + serializedEmployee.length + " bytes");
        System.out.println(hex);
    }


    public long benchmark() throws Exception {
        AvroSerializer avroSerializer = new AvroSerializer();
        Stopwatch stopwatch = Stopwatch.createStarted();
        byte[] serializedEmployee = avroSerializer.serialize(Populator.avroEmployees(POPULATION_SIZE));
        avroSerializer.deserialize(serializedEmployee); // dont need return values
        stopwatch.stop();
        return stopwatch.elapsed(TimeUnit.NANOSECONDS);
    }

}
