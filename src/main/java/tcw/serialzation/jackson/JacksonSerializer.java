package tcw.serialzation.jackson;

import org.codehaus.jackson.map.ObjectMapper;
import tcw.domain.Employee;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class JacksonSerializer {

    private ObjectMapper mapper = new ObjectMapper();

    public byte[] serialize(Employee employee) throws IOException {
        return mapper.writeValueAsBytes(employee);
    }

    public Employee deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        return mapper.readValue(bytes, Employee.class);
    }
}
