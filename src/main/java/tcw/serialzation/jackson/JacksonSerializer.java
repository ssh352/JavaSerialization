package tcw.serialzation.jackson;

import org.codehaus.jackson.map.ObjectMapper;
import tcw.domain.Employee;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class JacksonSerializer {

    private ObjectMapper mapper = new ObjectMapper();

    public byte[] serialize(Employee employee) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        mapper.writeValue(bos, employee);
        bos.close();
        return bos.toByteArray();
    }

    public Employee deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Employee employee = mapper.readValue(bis, Employee.class);
        bis.close();
        return employee;
    }
}
