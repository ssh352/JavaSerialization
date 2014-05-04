package tcw.serialzation.sbe;

import com.google.common.base.Stopwatch;
import org.junit.Ignore;
import org.junit.Test;
import tcw.serialzation.HelperUtils;
import tcw.serialzation.Populator;
import uk.co.real_logic.sbe.codec.java.DirectBuffer;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class SbeSerializerTest {


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
