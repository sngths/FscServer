package im.stream;

import org.junit.Test;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by tianxing on 16/12/16.
 */
public class StreamIDTest {


    private static final int MAX_STRING_SIZE = 10;


    private Random random = new SecureRandom();


    @Test
    public void id(){
        for (int i = 0; i < 10; i++) {
            System.out.println(new BigInteger( MAX_STRING_SIZE * 5, random ).toString( 36 ));
        }
    }
}
