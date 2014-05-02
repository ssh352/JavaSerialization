package tcw.serialzation.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.google.common.base.Stopwatch;
import org.junit.Test;
import tcw.domain.Employee;
import tcw.serialzation.HelperUtils;
import tcw.serialzation.Populator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static tcw.serialzation.Populator.POPULATION_SIZE;

public class KryoSerializerTest {

    @Test
    public void validation() throws Exception {
        KryoSerializer kryoSerializer = new KryoSerializer();
        Employee employee = Populator.employee();
        byte[] serializedEmployee = kryoSerializer.serialize(employee);
        Employee deserializedEmployee = kryoSerializer.deserialize(serializedEmployee);
        System.out.println(deserializedEmployee);
    }

    @Test
    public void serializationSize() throws Exception {
        KryoSerializer kryoSerializer = new KryoSerializer();
        Employee employee = Populator.employee();
        byte[] serializedEmployee = kryoSerializer.serialize(employee);
        String hex = HelperUtils.prettyHex16(serializedEmployee);
        System.out.println("SIZE: " + serializedEmployee.length + " bytes");
        System.out.println(hex);
        //59 bytes
    }

    public long benchmark() throws Exception {

        Kryo kryo = new Kryo();
        List<Employee> employees = Populator.employees(POPULATION_SIZE);
        Stopwatch stopwatch = Stopwatch.createStarted();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Output output = new Output(bos);
        for (Employee employee : employees) {
            kryo.writeObject(output, employee);
        }
        output.close();
        byte[] bytes = bos.toByteArray();
        bos.close();

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Input input = new Input(bis);
        Employee employeeDeserialized = new Employee();
        for (int i = 0; i < employees.size(); i++) {
            employeeDeserialized = kryo.readObject(input, Employee.class);
        }
        input.close();
        bis.close();
        stopwatch.stop();
        byte aByte = bytes[0];
        System.out.println("Kryo:" + stopwatch.toString());
        return stopwatch.elapsed(TimeUnit.NANOSECONDS);
    }

}
