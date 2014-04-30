package tcw.serialzation.messagepack;


import org.junit.Test;
import org.msgpack.MessagePack;
import org.msgpack.packer.Packer;
import org.msgpack.unpacker.Unpacker;
import tcw.domain.messagepack.Employee;
import tcw.domain.util.Populated;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class MsgPackSerializationTest {

    @Test
    public void validation() throws Exception {
        MsgPackSerialization msgPackSerialization = new MsgPackSerialization();
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

//    @Test
//    public void serializationSize() throws Exception {
//        MsgPackSerialization msgPackSerialization = new MsgPackSerialization();
//        Employee employee = Populated.employeeMessagepack();
//        byte[] serializedEmployee = msgPackSerialization.serialize(employee);
//        String hex = HelperUtils.prettyHex16(serializedEmployee);
//        System.out.println("SIZE: " + serializedEmployee.length + " bytes");
//        System.out.println(hex);
//    }
//
//
//    @Test
//    public void benchmark() throws Exception {
//        MsgPackSerialization msgPackSerialization = new MsgPackSerialization();
//        Employee employeeV1 = Populated.employee();
//        Employee deserializedEmployeeV1 = null;
//        Stopwatch stopwatch = Stopwatch.createStarted();
//        for (int i = 0; i < 1000000; i++) {
//            byte[] serializedEmployee = msgPackSerialization.serialize(employeeV1);
//            deserializedEmployeeV1 = msgPackSerialization.deserialize(serializedEmployee);
//        }
//        stopwatch.stop();
//        System.out.println(stopwatch.toString());
//    }


}
