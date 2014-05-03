package tcw.serialzation.manual;


import com.google.common.base.Stopwatch;
import org.junit.Test;
import tcw.domain.extern.Employee;
import tcw.serialzation.HelperUtils;
import tcw.serialzation.Populator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static tcw.serialzation.Populator.POPULATION_SIZE;

public class ExtrenalizableSerializationTest {

    @Test
    public void validation() throws Exception {
        ExtrenalizableSerialization extrenalizableSerialization = new ExtrenalizableSerialization();
        Employee employee = Populator.employeeExtern();
        byte[] serializedEmployee = extrenalizableSerialization.serialize(employee);
        Employee deserializedEmployeeV1 = extrenalizableSerialization.deserialize(serializedEmployee);
        System.out.println(deserializedEmployeeV1);
    }

    @Test
    public void serializationSize() throws Exception {
        ExtrenalizableSerialization extrenalizableSerialization = new ExtrenalizableSerialization();
        Employee employee = Populator.employeeExtern();
        byte[] serializedEmployee = extrenalizableSerialization.serialize(employee);
        String hex = HelperUtils.prettyHex16(serializedEmployee);
        System.out.println("SIZE: " + serializedEmployee.length + " bytes");
        System.out.println(hex);
        //56 bytes
    }

    public long benchmark() throws Exception {
        List<Employee> employees = Populator.employeesExtern(POPULATION_SIZE);
        Stopwatch stopwatch = Stopwatch.createStarted();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bos);
        for (Employee employee : employees) {
            employee.writeExternal(objectOutputStream);
        }
        objectOutputStream.close();
        byte[] bytes = bos.toByteArray();
        bos.close();

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(bis);
        Employee employeeDeserialized = new Employee();
        for (int i = 0; i < employees.size(); i++) {
            employeeDeserialized.readExternal(objectInputStream);
        }
        objectInputStream.close();
        bis.close();
        stopwatch.stop();
        return stopwatch.elapsed(TimeUnit.NANOSECONDS);
    }

}
