package util;

/**
 * Created by tianxing on 16/11/16.
 *
 */
import java.io.IOException;
import java.nio.ByteBuffer;

//import com.eaio.uuid.UUIDGen;

public class UniqueID {

        // Get the MAC address (i.e., the "node" from a UUID1)
        private final long clockSeqAndNode = 00;// = UUIDGen.getClockSeqAndNode();
        private final byte[] node = new byte[]{
                (byte)((clockSeqAndNode >> 40) & 0xff),
                (byte)((clockSeqAndNode >> 32) & 0xff),
                (byte)((clockSeqAndNode >> 24) & 0xff),
                (byte)((clockSeqAndNode >> 16) & 0xff),
                (byte)((clockSeqAndNode >> 8) & 0xff),
                (byte)((clockSeqAndNode >> 0) & 0xff),
        };
        private final ThreadLocal<ByteBuffer> tlbb = new ThreadLocal<ByteBuffer>() {
            @Override
            public ByteBuffer initialValue() {
                return ByteBuffer.allocate(16);
            }
        };

        private volatile int seq;
        private volatile long lastTimestamp;
        private final Object lock = new Object();

        private final int maxShort = (int)0xffff;

        public byte[] getId() {
            if(seq == maxShort) {
                throw new RuntimeException("Too fast");
            }

            long time;
            synchronized(lock) {
                time = System.currentTimeMillis();
                if(time != lastTimestamp) {
                    lastTimestamp = time;
                    seq = 0;
                }
                seq++;
                ByteBuffer bb = tlbb.get();
                bb.rewind();
                bb.putLong(time);
                bb.put(node);
                bb.putShort((short)seq);
                return bb.array();
            }
        }

        public String getStringId() {
            byte[] ba = getId();
            ByteBuffer bb = ByteBuffer.wrap(ba);
            long ts = bb.getLong();
            int node_0 = bb.getInt();
            short node_1 = bb.getShort();
            short seq = bb.getShort();
            return String.format("%016d-%s%s-%04d", ts, Integer.toHexString(node_0), Integer.toHexString(node_1), seq);
        }

//        public static void main(String[] args) throws IOException {
//            UniqueID uid = new UniqueID();
//            int n = Integer.parseInt(args[0]);
//
//            for(int i=0; i<n; i++) {
//                System.out.write(uid.getId());
//                //System.out.println(uid.getStringId());
//            }
//        }
    }

