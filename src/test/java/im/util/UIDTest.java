package im.util;

import org.junit.Test;

/**
 * Created by tianxing on 16/12/7.
 *
 */
public class UIDTest {

    @Test
    public void test(){
        UID  uid = new UID("u@d/r");
        System.out.println(uid.getUsername());
        System.out.println(uid.getDomain());
        System.out.println(uid.getResource());
    }

}
