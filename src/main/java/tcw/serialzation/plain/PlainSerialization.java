package tcw.serialzation.plain;


import tcw.domain.Employee;
import tcw.domain.v1.EmployeeV1;

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


}
