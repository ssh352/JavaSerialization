package tcw.serialzation.plain;


import tcw.domain.Employee;

import java.io.*;

public class PlainSerialization {


    public byte[] serialize(Employee employee) throws IOException {
        try ( ByteArrayOutputStream bos = new ByteArrayOutputStream()){
            try (ObjectOutputStream os = new ObjectOutputStream(bos)){
                os.writeObject(employee);
            }
            return bos.toByteArray();
        }
    }

    public Employee deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        try ( ByteArrayInputStream bis = new ByteArrayInputStream(bytes)){
            try (ObjectInputStream objectInputStream = new ObjectInputStream(bis)){
                return (Employee)objectInputStream.readObject();
            }
        }
    }

    public <T extends Serializable> byte[] serializeObject(T t) throws IOException {
        try ( ByteArrayOutputStream bos = new ByteArrayOutputStream()){
            try (ObjectOutputStream os = new ObjectOutputStream(bos)){
                os.writeObject(t);
            }
            return bos.toByteArray();
        }
    }

    public <T> T deserializeToObject(byte[] bytes,Class<T> clazz) throws IOException, ClassNotFoundException {
        try ( ByteArrayInputStream bis = new ByteArrayInputStream(bytes)){
            try (ObjectInputStream objectInputStream = new ObjectInputStream(bis)){
                return clazz.cast(objectInputStream.readObject());
            }
        }
    }
}
