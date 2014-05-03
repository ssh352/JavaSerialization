package tcw.serialzation.plain.consepts;

import org.junit.Test;
import tcw.serialzation.plain.PlainSerialization;

import static org.junit.Assert.*;

public class UsingReadWriteObjectTest {

    @Test
    public void testGetName() throws Exception {
        PlainSerialization plainSerialization = new PlainSerialization();
        byte[] bytes = plainSerialization.serializeObject(new UsingReadWriteObject("Tom", "hello"));
        UsingReadWriteObject usingReadWriteObject = plainSerialization.deserializeToObject(bytes, UsingReadWriteObject.class);
        System.out.println(usingReadWriteObject.toString());
    }


}