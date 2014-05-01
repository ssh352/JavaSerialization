package tcw.serialzation.messagepack;

import org.msgpack.MessagePack;
import tcw.domain.messagepack.Employee;

import java.io.IOException;

public class MsgPackSerialization {

    private MessagePack msgpack;

    public MsgPackSerialization() {
        this.msgpack = new MessagePack();
    }

    public byte[] serialize(Employee employee) throws IOException {
        return msgpack.write(employee);
    }

    public Employee deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        return msgpack.read(bytes, Employee.class);
    }

}
