package tcw.serialzation.jackson;

import org.codehaus.jackson.map.ObjectMapper;
import tcw.domain.v1.EmployeeV1;

import java.io.*;


public class JacksonSerializer {

    private ObjectMapper mapper = new ObjectMapper();

    public byte[] serialize(EmployeeV1 employeeV1) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        mapper.writeValue(bos, employeeV1);
        bos.close();
        return bos.toByteArray();
    }

    public EmployeeV1 deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        EmployeeV1 employeeV1 = mapper.readValue(bis, EmployeeV1.class);
        bis.close();
        return employeeV1;
    }
}
