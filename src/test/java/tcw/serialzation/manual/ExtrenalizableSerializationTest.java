package tcw.serialzation.manual;


import com.google.common.base.Stopwatch;
import org.junit.Test;
import tcw.domain.extern.v1.EmployeeExtV1;
import tcw.domain.util.Populated;

public class ExtrenalizableSerializationTest {

    @Test
    public void validation() throws Exception {
        ExtrenalizableSerialization extrenalizableSerialization = new ExtrenalizableSerialization();
        EmployeeExtV1 employeeExtV1 = Populated.extEmployee();
        byte[] serializedEmployee = extrenalizableSerialization.serialize(employeeExtV1);
        EmployeeExtV1 deserializedEmployeeV1 = extrenalizableSerialization.deserialize(serializedEmployee);
        System.out.println(deserializedEmployeeV1);
    }

    @Test
    public void benchmark() throws Exception {
        ExtrenalizableSerialization extrenalizableSerialization = new ExtrenalizableSerialization();
        EmployeeExtV1 employeeV1 = Populated.extEmployee();
        EmployeeExtV1 deserializedEmployeeV1 = null;
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 1000000; i++) {
            byte[] serializedEmployee = extrenalizableSerialization.serialize(employeeV1);
            deserializedEmployeeV1 = extrenalizableSerialization.deserialize(serializedEmployee);
        }
        stopwatch.stop();
        System.out.println(stopwatch.toString());
    }

}
