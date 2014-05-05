package tcw.serialzation.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import tcw.domain.Employee;

import java.io.*;

public class KryoSerializer {

    private final Kryo kryo = new Kryo();

    public <T> byte[] serialize(T t) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (Output output = new Output(bos)){
            kryo.writeObject(output, t);
        }
        return bos.toByteArray();
    }

    public <T> T deserialize(byte[] bytes,final Class<T> clazz) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        try (Input input = new Input(bis)){
            return kryo.readObject(input,clazz);
        }
    }
}
