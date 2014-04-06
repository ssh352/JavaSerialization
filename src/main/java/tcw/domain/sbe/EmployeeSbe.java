/* Generated SBE (Simple Binary Encoding) message codec */
package tcw.domain.sbe;

import uk.co.real_logic.sbe.codec.java.*;

public class EmployeeSbe
{
    public static final int BLOCK_LENGTH = 128;
    public static final int TEMPLATE_ID = 1;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 0;

    private final EmployeeSbe parentMessage = this;
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

    public EmployeeSbe wrapForEncode(final DirectBuffer buffer, final int offset)
    {
        this.buffer = buffer;
        this.offset = offset;
        this.actingBlockLength = BLOCK_LENGTH;
        this.actingVersion = SCHEMA_VERSION;
        limit(offset + actingBlockLength);

        return this;
    }

    public EmployeeSbe wrapForDecode(final DirectBuffer buffer, final int offset, final int actingBlockLength, final int actingVersion)
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
        return 4294967294L;
    }

    public static long employeeIdMinValue()
    {
        return 0L;
    }

    public static long employeeIdMaxValue()
    {
        return 4294967293L;
    }

    public long employeeId()
    {
        return CodecUtil.uint32Get(buffer, offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
    }

    public EmployeeSbe employeeId(final long value)
    {
        CodecUtil.uint32Put(buffer, offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public static int employeeNameId()
    {
        return 2;
    }

    public static String employeeNameMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
    }

    public static byte employeeNameNullValue()
    {
        return (byte)0;
    }

    public static byte employeeNameMinValue()
    {
        return (byte)32;
    }

    public static byte employeeNameMaxValue()
    {
        return (byte)126;
    }

    public static int employeeNameLength()
    {
        return 30;
    }

    public byte employeeName(final int index)
    {
        if (index < 0 || index >= 30)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        return CodecUtil.charGet(buffer, this.offset + 4 + (index * 1));
    }

    public void employeeName(final int index, final byte value)
    {
        if (index < 0 || index >= 30)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        CodecUtil.charPut(buffer, this.offset + 4 + (index * 1), value);
    }

    public static String employeeNameCharacterEncoding()
    {
        return "UTF-8";
    }

    public int getEmployeeName(final byte[] dst, final int dstOffset)
    {
        final int length = 30;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        CodecUtil.charsGet(buffer, this.offset + 4, dst, dstOffset, length);
        return length;
    }

    public EmployeeSbe putEmployeeName(final byte[] src, final int srcOffset)
    {
        final int length = 30;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 4, src, srcOffset, length);
        return this;
    }

    public static int departmentId()
    {
        return 3;
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

    public static byte departmentNullValue()
    {
        return (byte)0;
    }

    public static byte departmentMinValue()
    {
        return (byte)32;
    }

    public static byte departmentMaxValue()
    {
        return (byte)126;
    }

    public static int departmentLength()
    {
        return 30;
    }

    public byte department(final int index)
    {
        if (index < 0 || index >= 30)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        return CodecUtil.charGet(buffer, this.offset + 34 + (index * 1));
    }

    public void department(final int index, final byte value)
    {
        if (index < 0 || index >= 30)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        CodecUtil.charPut(buffer, this.offset + 34 + (index * 1), value);
    }

    public static String departmentCharacterEncoding()
    {
        return "UTF-8";
    }

    public int getDepartment(final byte[] dst, final int dstOffset)
    {
        final int length = 30;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        CodecUtil.charsGet(buffer, this.offset + 34, dst, dstOffset, length);
        return length;
    }

    public EmployeeSbe putDepartment(final byte[] src, final int srcOffset)
    {
        final int length = 30;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 34, src, srcOffset, length);
        return this;
    }

    public static int addressId()
    {
        return 4;
    }

    public static String addressMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "unix";
            case TIME_UNIT: return "nanosecond";
            case SEMANTIC_TYPE: return "";
        }

        return "";
    }

    private final AddressSbe address = new AddressSbe();

    public AddressSbe address()
    {
        address.wrap(buffer, offset + 64, actingVersion);
        return address;
    }
}
