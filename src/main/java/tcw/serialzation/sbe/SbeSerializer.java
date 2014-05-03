package tcw.serialzation.sbe;


import tcw.domain.sbe.BooleanType;
import tcw.domain.sbe.Employee;
import tcw.domain.sbe.MessageHeader;
import uk.co.real_logic.sbe.codec.java.DirectBuffer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class SbeSerializer {

    private static final Employee EMPLOYEE_SBE = new Employee();
    private static final MessageHeader MESSAGE_HEADER = new MessageHeader();
    private static byte[] NAME;
    private static byte[] DEPARTMENT;
    final ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4096);
    final DirectBuffer directBuffer = new DirectBuffer(byteBuffer);

    static {
        try {
            NAME = "John Doe".getBytes(Employee.employeeNameCharacterEncoding());
            DEPARTMENT = "IT".getBytes(Employee.departmentCharacterEncoding());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void serializeDeserialize() throws IOException {

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

    public static int encode(final Employee employee, final DirectBuffer directBuffer, final int bufferOffset) {
        final int srcOffset = 0;
        employee.wrapForEncode(directBuffer, bufferOffset)
                .employeeId(12345)
                .salery(123456.12)
                .consultant(BooleanType.TRUE)
                .putEmployeeName(NAME, srcOffset, NAME.length);
        employee.putDepartment(DEPARTMENT, srcOffset, DEPARTMENT.length);
        return employee.size();
    }


    public static void decode(final Employee employee,
                              final DirectBuffer directBuffer,
                              final int bufferOffset,
                              final int actingBlockLength,
                              final int schemaId,
                              final int actingVersion) throws Exception {
        final byte[] buffer = new byte[128];
        final StringBuilder sb = new StringBuilder();
        employee.wrapForDecode(directBuffer, bufferOffset, actingBlockLength, actingVersion);

//        sb.append("\nemployee.templateId=").append(employee.sbeTemplateId());
//        sb.append("\nemployee.schemaId=").append(schemaId);
//        sb.append("\nemployee.schemaVersion=").append(employee.sbeSchemaVersion());
//        sb.append("\nemployee.employeeId=").append(employee.employeeId());
//        sb.append("\nemployee.salery=").append(employee.salery());
//        sb.append("\nemployee.consultant=").append(employee.consultant());
//        sb.append("\nemployee.employeeName=").append(new String(buffer, 0, employee.getEmployeeName(buffer, 0, buffer.length), Employee.employeeNameCharacterEncoding()));
//        sb.append("\nemployee.department=").append(new String(buffer, 0, employee.getDepartment(buffer, 0, buffer.length), Employee.departmentCharacterEncoding()));
//        System.out.println(sb.toString());
    }
}
