package tcw.serialzation.messagepack;

import org.msgpack.MessagePack;
import tcw.domain.v1.AddressV1;
import tcw.domain.v1.EmployeeV1;

import java.io.IOException;

public class MsgPackSerialization {

    private MessagePack msgpack;

    public MsgPackSerialization() {
        this.msgpack = new MessagePack();
        this.msgpack.register(AddressV1.class); //NB! Has to be in right order
        this.msgpack.register(EmployeeV1.class);
    }

    public byte[] serialize(EmployeeV1 employeeV1) throws IOException {
        return msgpack.write(employeeV1);
    }

    public EmployeeV1 deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        return msgpack.read(bytes, EmployeeV1.class);
    }

}
