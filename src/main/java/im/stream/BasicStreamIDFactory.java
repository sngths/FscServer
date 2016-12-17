package im.stream;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by tianxing on 16/12/15.
 */
public class BasicStreamIDFactory implements StreamIDFactory{




    /**
     * 生成ID的最大字符数
     */
    private static final int MAX_STRING_SIZE = 10;


    private Random random = new SecureRandom();


    @Override
    public StreamID createStreamID() {
        return new BasicStreamID(new BigInteger( MAX_STRING_SIZE * 5, random ).toString( 36 ));
    }


    public StreamID createStreamID(String id){
        return new BasicStreamID(id);
    }

    private class BasicStreamID implements StreamID{

        private final String id;

        public BasicStreamID(String id){
            this.id = id;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String toString() {
            return id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }
    }
}
