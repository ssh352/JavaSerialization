package tcw.serialzation.messagepack;


import com.google.common.base.Stopwatch;
import org.junit.Test;
import org.msgpack.MessagePack;
import org.msgpack.packer.Packer;
import org.msgpack.unpacker.Unpacker;
import tcw.domain.messagepack.Employee;
import tcw.serialzation.HelperUtils;
import tcw.serialzation.Populated;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import static tcw.serialzation.Populated.POPULATION_SIZE;

public class MsgPackSerializationTest {

    @Test
    public void validation() throws Exception {
        Employee employee = Populated.employeeMessagepack();
        MessagePack messagePack = new MessagePack();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Packer packer = messagePack.createPacker(bos);
        employee.serialize(packer);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bos.toByteArray());
        Unpacker unpacker = messagePack.createUnpacker(inputStream);
        Employee deserializedEmployee = new Employee();
        deserializedEmployee.deserialize(unpacker);
        System.out.println(deserializedEmployee);
    }

    @Test
    public void serializationSize() throws Exception {
        Employee employee = Populated.employeeMessagepack();
        MessagePack messagePack = new MessagePack();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Packer packer = messagePack.createPacker(bos);
        employee.serialize(packer);
        byte[] bytes = bos.toByteArray();
        String hex = HelperUtils.prettyHex16(bytes);
        System.out.println("SIZE: " + bytes.length + " bytes");
        System.out.println(hex);
        //40 bytes
    }

    @Test
    public void benchmark() throws Exception {
        List<Employee> employees = Populated.employeesMessagepack(POPULATION_SIZE);
        MessagePack messagePack = new MessagePack();
        Stopwatch stopwatch = Stopwatch.createStarted();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Packer packer = messagePack.createPacker(bos);
        for (Employee employee : employees) {
            employee.serialize(packer);
        }
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bos.toByteArray());
        Unpacker unpacker = messagePack.createUnpacker(inputStream);
        Employee deserializedEmployee = new Employee();
        for (int i = 0; i < employees.size(); i++) {
            deserializedEmployee.deserialize(unpacker);
        }
        stopwatch.stop();
        System.out.println(stopwatch.toString());
        System.out.println(deserializedEmployee);
    }


}
