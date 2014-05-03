package tcw.serialzation.plain.consepts;

import org.junit.Test;
import tcw.serialzation.plain.PlainSerialization;
import tcw.serialzation.plain.consepts.inheritance.ObjectA;

public class InheritanceTest {

    @Test
    public void testSerialization() throws Exception {
        ObjectA objectA = new ObjectA("C", "B", "Common", "A");

        PlainSerialization plainSerialization = new PlainSerialization();
        byte[] bytes = plainSerialization.serializeObject(objectA);
        ObjectA objectA1 = plainSerialization.deserializeToObject(bytes, ObjectA.class);
        System.out.println(objectA1.toString());

    }
}
