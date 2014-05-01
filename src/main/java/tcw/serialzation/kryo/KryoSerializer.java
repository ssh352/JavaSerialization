package tcw.serialzation.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import tcw.domain.Employee;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class KryoSerializer {

    private Kryo kryo = new Kryo();

    public byte[] serialize(Employee employee) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Output output = new Output(bos);
        kryo.writeObject(output, employee);
        output.close();
        byte[] bytes = bos.toByteArray();
        bos.close();
        return bytes;
    }

    public Employee deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Input input = new Input(bis);
        Employee employee = kryo.readObject(input, Employee.class);
        input.close();
        bis.close();
        return employee;
    }
}
