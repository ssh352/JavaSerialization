package tcw.serialzation.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.UnsafeInput;
import com.esotericsoftware.kryo.io.UnsafeOutput;
import com.google.common.base.Stopwatch;
import org.junit.Test;
import tcw.domain.Employee;
import tcw.serialzation.HelperUtils;
import tcw.serialzation.Populator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static tcw.serialzation.Populator.POPULATION_SIZE;

public class KryoSerializerTest {

    @Test
    public void validation() throws Exception {
        KryoSerializer kryoSerializer = new KryoSerializer();
        Employee employee = Populator.employee();
        byte[] serializedEmployee = kryoSerializer.serialize(employee);
        Employee deserializedEmployee = kryoSerializer.deserialize(serializedEmployee,Employee.class);
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
        UnsafeOutput unsafeOutput = new UnsafeOutput(bos);
        for (Employee employee : employees) {
            kryo.writeObject(unsafeOutput, employee);
        }
        unsafeOutput.close();
        byte[] bytes = bos.toByteArray();

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        UnsafeInput unsafeInput = new UnsafeInput(bis);
        Employee employeeDeserialized = new Employee();
        for (int i = 0; i < employees.size(); i++) {
            employeeDeserialized = kryo.readObject(unsafeInput, Employee.class);
        }
        unsafeInput.close();
        stopwatch.stop();
        return stopwatch.elapsed(TimeUnit.NANOSECONDS);
    }

}
