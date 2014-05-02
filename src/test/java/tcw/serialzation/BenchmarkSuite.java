package tcw.serialzation;


import org.junit.Test;
import tcw.serialzation.avro.AvroSerializerTest;
import tcw.serialzation.jackson.JacksonSerializerTest;
import tcw.serialzation.kryo.KryoSerializerTest;
import tcw.serialzation.manual.ExtrenalizableSerializationTest;
import tcw.serialzation.messagepack.MsgPackSerializationTest;
import tcw.serialzation.plain.PlainSerializationTest;
import tcw.serialzation.protobuf.ProtobufSerializerTest;

public class BenchmarkSuite {

    private final int TIMES = 10;
    
    @Test
    public void runAllBenchmarks() throws Exception {

        AvroSerializerTest avroSerializerTest = new AvroSerializerTest();
        JacksonSerializerTest jacksonSerializerTest = new JacksonSerializerTest();
        KryoSerializerTest kryoSerializerTest = new KryoSerializerTest();
        ExtrenalizableSerializationTest extrenalizableSerializationTest = new ExtrenalizableSerializationTest();
        MsgPackSerializationTest msgPackSerializationTest = new MsgPackSerializationTest();
        PlainSerializationTest plainSerializationTest = new PlainSerializationTest();
        ProtobufSerializerTest protobufSerializerTest = new ProtobufSerializerTest();

        kryoSerializerTest.benchmark();//POOR MANS WARMUP

        long kryoNanoSeconds = 0;
        for (int i = 0; i < TIMES; i++) {
            kryoNanoSeconds = kryoNanoSeconds + kryoSerializerTest.benchmark();
        }

        long protobufNanoSeconds = 0;
        for (int i = 0; i < TIMES; i++) {
            protobufNanoSeconds = protobufNanoSeconds + protobufSerializerTest.benchmark();
        }

        long protobufSimpleNanoSeconds = 0;
        for (int i = 0; i < TIMES; i++) {
            protobufSimpleNanoSeconds = protobufSimpleNanoSeconds + protobufSerializerTest.benchmarkSimple();
        }

        long avroNanoSeconds = 0;
        for (int i = 0; i < TIMES; i++) {
            avroNanoSeconds = avroNanoSeconds + avroSerializerTest.benchmark();
        }

        long jacksonNanoSeconds = 0;
        for (int i = 0; i < TIMES; i++) {
            jacksonNanoSeconds = jacksonNanoSeconds +jacksonSerializerTest.benchmark();
        }

        long extNanoSeconds = 0;
        for (int i = 0; i < TIMES; i++) {
            extNanoSeconds = extNanoSeconds + extrenalizableSerializationTest.benchmark();
        }

        long msgpackNanoSeconds = 0;
        for (int i = 0; i < TIMES; i++) {
            msgpackNanoSeconds = msgpackNanoSeconds +msgPackSerializationTest.benchmark();
        }

        long plainNanoSeconds = 0;
        for (int i = 0; i < TIMES; i++) {
            plainNanoSeconds = plainNanoSeconds + plainSerializationTest.benchmark();
        }

        System.out.println("------------- BENCHMARKS IN MICROSECONDS WITH SAMPLESET OF "+Populator.POPULATION_SIZE +" OBJECTS ------------------");
        System.out.println("kryo avrage after "+ TIMES +" runs: " + kryoNanoSeconds / TIMES/1000);
        System.out.println("protobuf avrage after "+ TIMES +" runs: " + protobufNanoSeconds / TIMES/1000);
        System.out.println("protobufSimple avrage after "+ TIMES +" runs: " + protobufSimpleNanoSeconds / TIMES/1000);
        System.out.println("avro avrage after "+ TIMES +" runs: " + avroNanoSeconds / TIMES/1000);
        System.out.println("jackson avrage after "+ TIMES +" runs: " + jacksonNanoSeconds / TIMES/1000);
        System.out.println("externalizable avrage after "+ TIMES +" runs: " + extNanoSeconds / TIMES/1000);
        System.out.println("msgpack avrage after "+ TIMES +" runs: " + msgpackNanoSeconds / TIMES/1000);
        System.out.println("serilaizable avrage after "+ TIMES +" runs: " + plainNanoSeconds / TIMES/1000);




       
    }
}
