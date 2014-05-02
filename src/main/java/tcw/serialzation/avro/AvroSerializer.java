package tcw.serialzation.avro;

import com.google.common.collect.Lists;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.file.SeekableByteArrayInput;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import tcw.domain.avro.java.Employee;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AvroSerializer {

    DatumWriter<Employee> userDatumWriter = new SpecificDatumWriter<Employee>(Employee.class);
    DataFileWriter<Employee> dataFileWriter = new DataFileWriter<Employee>(userDatumWriter);
    DatumReader<Employee> userDatumReader = new SpecificDatumReader<Employee>(Employee.class);

    public byte[] serialize(List<Employee> employee) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        dataFileWriter.create(employee.get(0).getSchema(), bos);
        for (Employee Employee : employee) {
            dataFileWriter.append(Employee);
        }
        dataFileWriter.close();
        bos.close();
        return bos.toByteArray();
    }

    //only returns last employee
    public Employee deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        SeekableByteArrayInput sbai = new SeekableByteArrayInput(bytes);
        DataFileReader<Employee> dataFileReader = new DataFileReader<Employee>(sbai, userDatumReader);
        Employee employee = null;
        Employee deserialized = null;
        while (dataFileReader.hasNext()) {
            deserialized = dataFileReader.next(employee);
        }
        sbai.close();
        return deserialized;
    }
}
