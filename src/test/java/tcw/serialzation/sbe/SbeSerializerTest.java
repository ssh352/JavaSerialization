package tcw.serialzation.sbe;

import com.google.common.base.Stopwatch;
import org.junit.Ignore;
import org.junit.Test;
import tcw.serialzation.Populator;

import java.util.concurrent.TimeUnit;

public class SbeSerializerTest {

    @Test
    public void validation() throws Exception {
        SbeSerializer sbeSerializer = new SbeSerializer();
        sbeSerializer.serializeDeserialize();
    }


    public long benchmark() throws Exception {
        SbeSerializer sbeSerializer = new SbeSerializer();
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < Populator.POPULATION_SIZE; i++) {
            sbeSerializer.serializeDeserialize();
        }
        stopwatch.stop();
        return stopwatch.elapsed(TimeUnit.NANOSECONDS);
    }


}
