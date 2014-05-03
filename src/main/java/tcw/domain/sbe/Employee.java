/* Generated SBE (Simple Binary Encoding) message codec */
package tcw.domain.sbe;

import uk.co.real_logic.sbe.codec.java.*;

public class Employee
{
    public static final int BLOCK_LENGTH = 17;
    public static final int TEMPLATE_ID = 1;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 0;

    private final Employee parentMessage = this;
    private DirectBuffer buffer;
    private int offset;
    private int limit;
    private int actingBlockLength;
    private int actingVersion;

    public int sbeBlockLength()
    {
        return BLOCK_LENGTH;
    }

    public int sbeTemplateId()
    {
        return TEMPLATE_ID;
    }

    public int sbeSchemaId()
    {
        return SCHEMA_ID;
    }

    public int sbeSchemaVersion()
    {
        return SCHEMA_VERSION;
    }

    public String sbeSemanticType()
    {
        return "";
    }

    public int offset()
    {
        return offset;
    }

    public Employee wrapForEncode(final DirectBuffer buffer, final int offset)
    {
        this.buffer = buffer;
        this.offset = offset;
        this.actingBlockLength = BLOCK_LENGTH;
        this.actingVersion = SCHEMA_VERSION;
        limit(offset + actingBlockLength);

        return this;
    }

    public Employee wrapForDecode(final DirectBuffer buffer, final int offset, final int actingBlockLength, final int actingVersion)
    {
        this.buffer = buffer;
        this.offset = offset;
        this.actingBlockLength = actingBlockLength;
        this.actingVersion = actingVersion;
        limit(offset + actingBlockLength);

        return this;
    }

    public int size()
    {
        return limit - offset;
    }

    public int limit()
    {
        return limit;
    }

    public void limit(final int limit)
    {
        buffer.checkLimit(limit);
        this.limit = limit;
    }

    public static int employeeIdId()
    {
        return 1;
    }

    public static String employeeIdMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
    }

    public static long employeeIdNullValue()
    {
        return 0xffffffffffffffffL;
    }

    public static long employeeIdMinValue()
    {
        return 0x0L;
    }

    public static long employeeIdMaxValue()
    {
        return 0xfffffffffffffffeL;
    }

    public long employeeId()
    {
        return CodecUtil.uint64Get(buffer, offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
    }

    public Employee employeeId(final long value)
    {
        CodecUtil.uint64Put(buffer, offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public static int saleryId()
    {
        return 2;
    }

    public static String saleryMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
    }

    public static double saleryNullValue()
    {
        return Double.NaN;
    }

    public static double saleryMinValue()
    {
        return 4.9E-324d;
    }

    public static double saleryMaxValue()
    {
        return 1.7976931348623157E308d;
    }

    public double salery()
    {
        return CodecUtil.doubleGet(buffer, offset + 8, java.nio.ByteOrder.LITTLE_ENDIAN);
    }

    public Employee salery(final double value)
    {
        CodecUtil.doublePut(buffer, offset + 8, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public static int consultantId()
    {
        return 3;
    }

    public static String consultantMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
    }

    public BooleanType consultant()
    {
        return BooleanType.get(CodecUtil.uint8Get(buffer, offset + 16));
    }

    public Employee consultant(final BooleanType value)
    {
        CodecUtil.uint8Put(buffer, offset + 16, value.value());
        return this;
    }

    public static int employeeNameId()
    {
        return 4;
    }

    public static String employeeNameCharacterEncoding()
    {
        return "UTF-8";
    }

    public static String employeeNameMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "EmployeeName";
        }

        return "";
    }

    public static int employeeNameHeaderSize()
    {
        return 1;
    }

    public int getEmployeeName(final byte[] dst, final int dstOffset, final int length)
    {
        final int sizeOfLengthField = 1;
        final int limit = limit();
        buffer.checkLimit(limit + sizeOfLengthField);
        final int dataLength = CodecUtil.uint8Get(buffer, limit);
        final int bytesCopied = Math.min(length, dataLength);
        limit(limit + sizeOfLengthField + dataLength);
        CodecUtil.int8sGet(buffer, limit + sizeOfLengthField, dst, dstOffset, bytesCopied);

        return bytesCopied;
    }

    public int putEmployeeName(final byte[] src, final int srcOffset, final int length)
    {
        final int sizeOfLengthField = 1;
        final int limit = limit();
        limit(limit + sizeOfLengthField + length);
        CodecUtil.uint8Put(buffer, limit, (short)length);
        CodecUtil.int8sPut(buffer, limit + sizeOfLengthField, src, srcOffset, length);

        return length;
    }

    public static int departmentId()
    {
        return 5;
    }

    public static String departmentCharacterEncoding()
    {
        return "UTF-8";
    }

    public static String departmentMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
    }

    public static int departmentHeaderSize()
    {
        return 1;
    }

    public int getDepartment(final byte[] dst, final int dstOffset, final int length)
    {
        final int sizeOfLengthField = 1;
        final int limit = limit();
        buffer.checkLimit(limit + sizeOfLengthField);
        final int dataLength = CodecUtil.uint8Get(buffer, limit);
        final int bytesCopied = Math.min(length, dataLength);
        limit(limit + sizeOfLengthField + dataLength);
        CodecUtil.int8sGet(buffer, limit + sizeOfLengthField, dst, dstOffset, bytesCopied);

        return bytesCopied;
    }

    public int putDepartment(final byte[] src, final int srcOffset, final int length)
    {
        final int sizeOfLengthField = 1;
        final int limit = limit();
        limit(limit + sizeOfLengthField + length);
        CodecUtil.uint8Put(buffer, limit, (short)length);
        CodecUtil.int8sPut(buffer, limit + sizeOfLengthField, src, srcOffset, length);

        return length;
    }
}
