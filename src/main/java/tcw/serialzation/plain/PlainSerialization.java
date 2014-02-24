package tcw.serialzation.plain;


import tcw.domain.v1.EmployeeV1;

import java.io.*;

public class PlainSerialization {


    public byte[] serialize(EmployeeV1 employeeV1) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bos);
        objectOutputStream.writeObject(employeeV1);
        objectOutputStream.close();
        byte[] bytes = bos.toByteArray();
        bos.close();
        return bytes;
    }

    public EmployeeV1 deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(bis);
        Object o = objectInputStream.readObject();
        objectInputStream.close();
        bis.close();
        return (EmployeeV1) o;
    }


}
