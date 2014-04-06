package tcw.serialzation.sbe;

import org.codehaus.jackson.map.ObjectMapper;
import tcw.domain.protobuf.EmployeeProto;
import tcw.domain.sbe.AddressSbe;
import tcw.domain.sbe.EmployeeSbe;
import tcw.domain.sbe.MessageHeader;
import tcw.domain.v1.EmployeeV1;
import uk.co.real_logic.sbe.codec.java.DirectBuffer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;


public class SbeSerializer {

    private static final EmployeeSbe EMPLOYEE_SBE = new EmployeeSbe();
    private static final MessageHeader MESSAGE_HEADER = new MessageHeader();

    private static byte[] NAME;
    private static byte[] DEPARTMENT;
    private static byte[] STREET;
    private static byte[] CITY;

    static {
        try {
            NAME = "John Doe".getBytes(EmployeeSbe.employeeNameCharacterEncoding());
            DEPARTMENT = "IT".getBytes(EmployeeSbe.departmentCharacterEncoding());
            STREET = "Harlem".getBytes(AddressSbe.streetCharacterEncoding());
            CITY = "New York".getBytes(AddressSbe.cityCharacterEncoding());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void serializeDeserialize() throws IOException {
        final ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4096);
        final DirectBuffer directBuffer = new DirectBuffer(byteBuffer);
        final short messageTemplateVersion = 0;
        int bufferOffset = 0;

        MESSAGE_HEADER.wrap(directBuffer, bufferOffset, messageTemplateVersion)
                .blockLength(EMPLOYEE_SBE.sbeBlockLength())
                .templateId(EMPLOYEE_SBE.sbeTemplateId())
                .schemaId(EMPLOYEE_SBE.sbeSchemaId())
                .version(EMPLOYEE_SBE.sbeSchemaVersion());

        bufferOffset += MESSAGE_HEADER.size();

        encode(EMPLOYEE_SBE, directBuffer, bufferOffset);


        bufferOffset = 0;
        MESSAGE_HEADER.wrap(directBuffer, bufferOffset, messageTemplateVersion);

        final int actingBlockLength = MESSAGE_HEADER.blockLength();
        final int schemaId = MESSAGE_HEADER.schemaId();
        final int actingVersion = MESSAGE_HEADER.version();

        bufferOffset += MESSAGE_HEADER.size();

        try {
            decode(EMPLOYEE_SBE, directBuffer, bufferOffset, actingBlockLength, schemaId, actingVersion);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static int encode(final EmployeeSbe employee, final DirectBuffer directBuffer, final int bufferOffset) {
        final int srcOffset = 0;

        employee.wrapForEncode(directBuffer, bufferOffset)
                .employeeId(12345)
                .putEmployeeName(NAME, srcOffset)
                .putDepartment(DEPARTMENT, srcOffset);

        employee.address().homeNo(555234124)
                .putStreet(STREET, srcOffset)
                .putCity(CITY, srcOffset);

        return employee.size();
    }


    public static void decode(final EmployeeSbe employee,
                              final DirectBuffer directBuffer,
                              final int bufferOffset,
                              final int actingBlockLength,
                              final int schemaId,
                              final int actingVersion) throws Exception {
        final byte[] buffer = new byte[128];
        final StringBuilder sb = new StringBuilder();
        employee.wrapForDecode(directBuffer, bufferOffset, actingBlockLength, actingVersion);

        sb.append("\nemployee.templateId=").append(employee.sbeTemplateId());
        sb.append("\nemployee.schemaId=").append(schemaId);
        sb.append("\nemployee.schemaVersion=").append(employee.sbeSchemaVersion());
        sb.append("\nemployee.employeeId=").append(employee.employeeId());
        sb.append("\nemployee.employeeName=").append(new String(buffer, 0, employee.getEmployeeName(buffer, 0), EmployeeSbe.employeeNameCharacterEncoding()));
        sb.append("\nemployee.department=").append(new String(buffer, 0, employee.getDepartment(buffer, 0), EmployeeSbe.departmentCharacterEncoding()));
        sb.append("\nemployee.address.homeNo=").append(employee.address().homeNo());
        sb.append("\nemployee.address.street=").append(new String(buffer, 0, employee.address().getStreet(buffer, 0), AddressSbe.streetCharacterEncoding()));
        sb.append("\nemployee.address.city=").append(new String(buffer, 0, employee.address().getCity(buffer, 0), AddressSbe.cityCharacterEncoding()));
        System.out.println(sb.toString());
    }
}
