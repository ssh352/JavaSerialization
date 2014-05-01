package tcw.serialzation.manual;

import tcw.domain.extern.Employee;

import java.io.*;

public class ExtrenalizableSerialization {

    public byte[] serialize(Employee employee) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bos);
        employee.writeExternal(objectOutputStream);
        objectOutputStream.close();
        byte[] bytes = bos.toByteArray();
        bos.close();
        return bytes;
    }

    public Employee deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(bis);
        Employee employee = new Employee();
        employee.readExternal(objectInputStream);
        objectInputStream.close();
        bis.close();
        return employee;
    }


}
