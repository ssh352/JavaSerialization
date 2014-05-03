package tcw.serialzation.plain;


import tcw.domain.Employee;

import java.io.*;

public class PlainSerialization {


    public byte[] serialize(Employee employee) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bos);
        objectOutputStream.writeObject(employee);
        objectOutputStream.close();
        byte[] bytes = bos.toByteArray();
        bos.close();
        return bytes;
    }

    public Employee deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(bis);
        Object o = objectInputStream.readObject();
        objectInputStream.close();
        bis.close();
        return (Employee) o;
    }

    public <T extends Serializable> byte[] serializeObject(T t) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bos);
        objectOutputStream.writeObject(t);
        objectOutputStream.close();
        byte[] bytes = bos.toByteArray();
        bos.close();
        return bytes;
    }

    public <T> T deserializeToObject(byte[] bytes,Class<T> clazz) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(bis);
        Object o = objectInputStream.readObject();
        objectInputStream.close();
        bis.close();
        return clazz.cast(o);
    }

}
