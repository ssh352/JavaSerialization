package tcw.serialzation.plain;


import com.google.common.base.Stopwatch;
import org.junit.Test;
import tcw.domain.Employee;

import tcw.serialzation.HelperUtils;
import tcw.serialzation.Populated;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import static tcw.serialzation.Populated.POPULATION_SIZE;

public class PlainSerializationTest {

    @Test
    public void validation() throws Exception {
        PlainSerialization plainSerialization = new PlainSerialization();
        Employee employee = Populated.employee();
        byte[] serializedEmployee = plainSerialization.serialize(employee);
        Employee deserializedEmployee = plainSerialization.deserialize(serializedEmployee);
        System.out.println(deserializedEmployee);
    }

    @Test
    public void serializationSize() throws Exception {
        PlainSerialization plainSerialization = new PlainSerialization();
        Employee employee = Populated.employee();
        byte[] serializedEmployee = plainSerialization.serialize(employee);
        String hex = HelperUtils.prettyHex16(serializedEmployee);
        System.out.println("SIZE: " + serializedEmployee.length + " bytes");
        System.out.println(hex);
        //60 bytes
    }

    @Test
    public void benchmark() throws Exception {
        List<Employee> employees = Populated.employees(POPULATION_SIZE);
        Stopwatch stopwatch = Stopwatch.createStarted();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bos);
        for (Employee employee : employees) {
            objectOutputStream.writeObject(employee);
        }

        objectOutputStream.close();
        byte[] bytes = bos.toByteArray();
        bos.close();

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(bis);
        Employee employeeDeserialized = new Employee();
        for (int i = 0; i < employees.size(); i++) {
            employeeDeserialized = (Employee) objectInputStream.readObject();
        }
        objectInputStream.close();
        bis.close();
       stopwatch.stop();
        System.out.println(stopwatch.toString());
        System.out.println(employeeDeserialized.toString());
    }
}
