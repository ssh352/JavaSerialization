package tcw.serialzation.manual;


import com.google.common.base.Stopwatch;
import org.junit.Test;
import tcw.domain.extern.Employee;
import tcw.domain.extern.v1.EmployeeExtV1;
import tcw.domain.util.Populated;
import tcw.serialzation.HelperUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExtrenalizableSerializationTest {

    @Test
    public void validation() throws Exception {
        ExtrenalizableSerialization extrenalizableSerialization = new ExtrenalizableSerialization();
        Employee employee = Populated.employeeExtern();
        byte[] serializedEmployee = extrenalizableSerialization.serialize(employee);
        Employee deserializedEmployeeV1 = extrenalizableSerialization.deserialize(serializedEmployee);
        System.out.println(deserializedEmployeeV1);
    }

    @Test
    public void serializationSize() throws Exception {
        ExtrenalizableSerialization extrenalizableSerialization = new ExtrenalizableSerialization();
        Employee employee = Populated.employeeExtern();
        byte[] serializedEmployee = extrenalizableSerialization.serialize(employee);
        String hex = HelperUtils.prettyHex16(serializedEmployee);
        System.out.println("SIZE: " + serializedEmployee.length + " bytes");
        System.out.println(hex);
    }

    @Test
    public void benchmark() throws Exception {
        Employee employee = Populated.employeeExtern();
        Stopwatch stopwatch = Stopwatch.createStarted();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bos);
        for (int i = 0; i < 1000000; i++) {
            employee.writeExternal(objectOutputStream);
        }
        objectOutputStream.close();
        byte[] bytes = bos.toByteArray();
        bos.close();
        System.out.println("SIZE:" + bytes.length);

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(bis);
        Employee employeeDeserialized = new Employee();
        for (int i = 0; i < 1000000; i++) {
            employeeDeserialized.readExternal(objectInputStream);
        }
        objectInputStream.close();
        bis.close();
        stopwatch.stop();
        System.out.println(stopwatch.toString());
        System.out.println(employeeDeserialized.toString());
    }

}
