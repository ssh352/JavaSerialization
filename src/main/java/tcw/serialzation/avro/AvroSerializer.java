package tcw.serialzation.avro;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.file.SeekableByteArrayInput;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.codehaus.jackson.map.ObjectMapper;
import tcw.domain.avro.java.AddressAvroV1;
import tcw.domain.avro.java.EmployeeAvroV1;
import tcw.domain.v1.EmployeeV1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class AvroSerializer {

    DatumWriter<EmployeeAvroV1> userDatumWriter = new SpecificDatumWriter<EmployeeAvroV1>(EmployeeAvroV1.class);
    DataFileWriter<EmployeeAvroV1> dataFileWriter = new DataFileWriter<EmployeeAvroV1>(userDatumWriter);
    DatumReader<EmployeeAvroV1> userDatumReader = new SpecificDatumReader<EmployeeAvroV1>(EmployeeAvroV1.class);

    public byte[] serialize(EmployeeAvroV1 employeeV1) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        dataFileWriter.create(employeeV1.getSchema(), bos);
        dataFileWriter.append(employeeV1);
        dataFileWriter.close();
        return bos.toByteArray();
    }

    public EmployeeAvroV1 deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        SeekableByteArrayInput sbai = new SeekableByteArrayInput(bytes);
        DataFileReader<EmployeeAvroV1> dataFileReader = new DataFileReader<EmployeeAvroV1>(sbai, userDatumReader);
        sbai.close();
        return dataFileReader.next();
    }
}
