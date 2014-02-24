package tcw.serialzation.manual;

import tcw.domain.extern.v1.EmployeeExtV1;

import java.io.*;

public class ExtrenalizableSerialization {

    public byte[] serialize(EmployeeExtV1 employeeExtV1) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bos);
        employeeExtV1.writeExternal(objectOutputStream);
        objectOutputStream.close();
        byte[] bytes = bos.toByteArray();
        bos.close();
        return bytes;
    }

    public EmployeeExtV1 deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(bis);
        EmployeeExtV1 employeeExtV1 = new EmployeeExtV1();
        employeeExtV1.readExternal(objectInputStream);
        objectInputStream.close();
        bis.close();
        return employeeExtV1;
    }


}
