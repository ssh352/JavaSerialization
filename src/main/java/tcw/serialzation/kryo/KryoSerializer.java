package tcw.serialzation.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import tcw.domain.v1.EmployeeV1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class KryoSerializer {

    private Kryo kryo = new Kryo();

    public byte[] serialize(EmployeeV1 employeeV1) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Output output = new Output(bos);
        kryo.writeObject(output, employeeV1);
        output.close();
        byte[] bytes = bos.toByteArray();
        bos.close();
        return bytes;
    }

    public EmployeeV1 deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Input input = new Input(bis);
        EmployeeV1 employeeV1 = kryo.readObject(input, EmployeeV1.class);
        input.close();
        bis.close();
        return employeeV1;
    }
}
