package tcw.serialzation;


import com.google.common.collect.Maps;
import org.junit.Test;
import tcw.serialzation.avro.AvroSerializerTest;
import tcw.serialzation.jackson.JacksonSerializerTest;
import tcw.serialzation.kryo.KryoSerializerTest;
import tcw.serialzation.manual.ExtrenalizableSerializationTest;
import tcw.serialzation.messagepack.MsgPackSerializationTest;
import tcw.serialzation.plain.PlainSerializationTest;
import tcw.serialzation.protobuf.ProtobufSerializerTest;
import tcw.serialzation.sbe.SbeSerializer;
import tcw.serialzation.sbe.SbeSerializerTest;

import java.util.Arrays;

public class BenchmarkSuite {

    private final int TIMES = 5;
    
    @Test
    public void runAllBenchmarks() throws Exception {

        AvroSerializerTest avroSerializerTest = new AvroSerializerTest();
        JacksonSerializerTest jacksonSerializerTest = new JacksonSerializerTest();
        KryoSerializerTest kryoSerializerTest = new KryoSerializerTest();
        ExtrenalizableSerializationTest extrenalizableSerializationTest = new ExtrenalizableSerializationTest();
        MsgPackSerializationTest msgPackSerializationTest = new MsgPackSerializationTest();
        PlainSerializationTest plainSerializationTest = new PlainSerializationTest();
        ProtobufSerializerTest protobufSerializerTest = new ProtobufSerializerTest();
        SbeSerializerTest sbeSerializerTest = new SbeSerializerTest();

        kryoSerializerTest.benchmark();//POOR MANS WARMUP

        System.out.printf("BENCHMARKING STARTED WITH SAMPLE SET OF %s OBJECT, AVERAGE OF %s TIMES ...\n\n", Populator.POPULATION_SIZE, TIMES);

        long[] sbeNanoSeconds = new long[TIMES];
        for (int i = 0; i < TIMES; i++) {
            sbeNanoSeconds[i] = sbeSerializerTest.benchmark();
        }

        System.out.println("SBE DONE");

        long[] protobufNanoSeconds = new long[TIMES];
        for (int i = 0; i < TIMES; i++) {
            protobufNanoSeconds[i] =protobufSerializerTest.benchmark();
        }

        System.out.println("PROTOCOL BUFFERS DONE");

        long[] protobufSimpleNanoSeconds = new long[TIMES];
        for (int i = 0; i < TIMES; i++) {
            protobufSimpleNanoSeconds[i] = protobufSerializerTest.benchmarkSimple();
        }

        System.out.println("PROTOCOL BUFFERS DONE");

        long[] avroNanoSeconds = new long[TIMES];
        for (int i = 0; i < TIMES; i++) {
            avroNanoSeconds[i] = avroSerializerTest.benchmark();
        }

        System.out.println("AVRO DONE");

        long[] jacksonNanoSeconds = new long[TIMES];
        for (int i = 0; i < TIMES; i++) {
            jacksonNanoSeconds[i] = jacksonSerializerTest.benchmark();
        }

        System.out.println("JACKSON DONE");

        long[] plainNanoSeconds = new long[TIMES];
        for (int i = 0; i < TIMES; i++) {
            plainNanoSeconds[i] = plainSerializationTest.benchmark();
        }

        System.out.println("PLAIN DONE");

        long[] extNanoSeconds = new long[TIMES];
        for (int i = 0; i < TIMES; i++) {
            extNanoSeconds[i] = extrenalizableSerializationTest.benchmark();
        }

        System.out.println("EXT DONE");

        long[] msgpackNanoSeconds = new long[TIMES];
        for (int i = 0; i < TIMES; i++) {
            msgpackNanoSeconds[i] =msgPackSerializationTest.benchmark();
        }

        System.out.println("MSGPACK DONE");

        long[] kryoNanoSeconds = new long[TIMES];
        for (int i = 0; i < TIMES; i++) {
            kryoNanoSeconds[i] = kryoSerializerTest.benchmark();
        }


        System.out.println("------------- BENCHMARKS IN MICROSECONDS WITH SAMPLESET OF "+Populator.POPULATION_SIZE +" OBJECTS ------------------");
        System.out.println("kryo average after "+ TIMES +" runs: " + getMedian(kryoNanoSeconds) /1000);
        System.out.println("protobuf average after "+ TIMES +" runs: " + getMedian(protobufNanoSeconds) /1000);
        System.out.println("protobufSimple average after "+ TIMES +" runs: " + getMedian(protobufSimpleNanoSeconds) /1000);
        System.out.println("avro average after "+ TIMES +" runs: " + getMedian(avroNanoSeconds) /1000);
        System.out.println("jackson average after "+ TIMES +" runs: " + getMedian(jacksonNanoSeconds)/1000);
        System.out.println("externalizable average after "+ TIMES +" runs: " + getMedian(extNanoSeconds) /1000);
        System.out.println("msgpack average after "+ TIMES +" runs: " + getMedian(msgpackNanoSeconds) /1000);
        System.out.println("serilaizable average after "+ TIMES +" runs: " + getMedian(plainNanoSeconds)/1000);
        System.out.println("sbe average after "+ TIMES +" runs: " + getMedian(sbeNanoSeconds) /1000);

    }

    private long getMedian(long[] results){
        Arrays.sort(results);
        if (results.length % 2 == 0)
            return results[results.length/2] + results[results.length/2 - 1]/2;
        else
            return results[results.length/2];
    }

}
