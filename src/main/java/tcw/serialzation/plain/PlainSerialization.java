package tcw.serialzation.plain;


import tcw.domain.Employee;

import java.io.*;

public class PlainSerialization {


    public byte[] serialize(Employee employee) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (ObjectOutputStream os = new ObjectOutputStream(bos)) {
            os.writeObject(employee);
        }
        return bos.toByteArray();
    }

    public Employee deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(bis)) {
            return (Employee) objectInputStream.readObject();
        }
    }

    public <T extends Serializable> byte[] serializeObject(T t) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (ObjectOutputStream os = new ObjectOutputStream(bos)) {
            os.writeObject(t);
        }
        return bos.toByteArray();
    }

    public <T extends Serializable> T deserializeToObject(byte[] bytes, Class<T> clazz) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(bis)) {
            return clazz.cast(objectInputStream.readObject());
        }
    }
}
