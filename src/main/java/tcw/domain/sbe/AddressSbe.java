/* Generated SBE (Simple Binary Encoding) message codec */
package tcw.domain.sbe;

import uk.co.real_logic.sbe.codec.java.*;

public class AddressSbe
{
    private DirectBuffer buffer;
    private int offset;
    private int actingVersion;

    public AddressSbe wrap(final DirectBuffer buffer, final int offset, final int actingVersion)
    {
        this.buffer = buffer;
        this.offset = offset;
        this.actingVersion = actingVersion;
        return this;
    }

    public int size()
    {
        return 64;
    }

    public static long homeNoNullValue()
    {
        return 4294967294L;
    }

    public static long homeNoMinValue()
    {
        return 0L;
    }

    public static long homeNoMaxValue()
    {
        return 4294967293L;
    }

    public long homeNo()
    {
        return CodecUtil.uint32Get(buffer, offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
    }

    public AddressSbe homeNo(final long value)
    {
        CodecUtil.uint32Put(buffer, offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public static byte streetNullValue()
    {
        return (byte)0;
    }

    public static byte streetMinValue()
    {
        return (byte)32;
    }

    public static byte streetMaxValue()
    {
        return (byte)126;
    }

    public static int streetLength()
    {
        return 30;
    }

    public byte street(final int index)
    {
        if (index < 0 || index >= 30)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        return CodecUtil.charGet(buffer, this.offset + 4 + (index * 1));
    }

    public void street(final int index, final byte value)
    {
        if (index < 0 || index >= 30)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        CodecUtil.charPut(buffer, this.offset + 4 + (index * 1), value);
    }

    public static String streetCharacterEncoding()
    {
        return "UTF-8";
    }

    public int getStreet(final byte[] dst, final int dstOffset)
    {
        final int length = 30;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        CodecUtil.charsGet(buffer, this.offset + 4, dst, dstOffset, length);
        return length;
    }

    public AddressSbe putStreet(final byte[] src, final int srcOffset)
    {
        final int length = 30;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 4, src, srcOffset, length);
        return this;
    }

    public static byte cityNullValue()
    {
        return (byte)0;
    }

    public static byte cityMinValue()
    {
        return (byte)32;
    }

    public static byte cityMaxValue()
    {
        return (byte)126;
    }

    public static int cityLength()
    {
        return 30;
    }

    public byte city(final int index)
    {
        if (index < 0 || index >= 30)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        return CodecUtil.charGet(buffer, this.offset + 34 + (index * 1));
    }

    public void city(final int index, final byte value)
    {
        if (index < 0 || index >= 30)
        {
            throw new IndexOutOfBoundsException("index out of range: index=" + index);
        }

        CodecUtil.charPut(buffer, this.offset + 34 + (index * 1), value);
    }

    public static String cityCharacterEncoding()
    {
        return "UTF-8";
    }

    public int getCity(final byte[] dst, final int dstOffset)
    {
        final int length = 30;
        if (dstOffset < 0 || dstOffset > (dst.length - length))
        {
            throw new IndexOutOfBoundsException("dstOffset out of range for copy: offset=" + dstOffset);
        }

        CodecUtil.charsGet(buffer, this.offset + 34, dst, dstOffset, length);
        return length;
    }

    public AddressSbe putCity(final byte[] src, final int srcOffset)
    {
        final int length = 30;
        if (srcOffset < 0 || srcOffset > (src.length - length))
        {
            throw new IndexOutOfBoundsException("srcOffset out of range for copy: offset=" + srcOffset);
        }

        CodecUtil.charsPut(buffer, this.offset + 34, src, srcOffset, length);
        return this;
    }
}
