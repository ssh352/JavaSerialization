package tcw.serialzation.avro;

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
import java.util.List;


public class AvroSerializer {

    DatumWriter<Employee> userDatumWriter = new SpecificDatumWriter<Employee>(Employee.class);
    DatumReader<Employee> userDatumReader = new SpecificDatumReader<Employee>(Employee.class);

    public byte[] serialize(List<Employee> employees) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (DataFileWriter<Employee> dataFileWriter = new DataFileWriter<Employee>(userDatumWriter)) {
            try (DataFileWriter<Employee> writer = dataFileWriter.create(employees.get(0).getSchema(), bos)) {
                for (Employee employee : employees) {
                    writer.append(employee);
                }
            }
        }
        return bos.toByteArray();
    }

    //only returns last employee
    public Employee deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        SeekableByteArrayInput sbai = new SeekableByteArrayInput(bytes);
        Employee deserialized = null;
        try (DataFileReader<Employee> dataFileReader = new DataFileReader<Employee>(sbai, userDatumReader)) {
            while (dataFileReader.hasNext()) {
                deserialized = dataFileReader.next();
            }
        }
        return deserialized;
    }
}
