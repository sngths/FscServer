package util;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tianxing on 16/10/27.
 *
 */
public class Server {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("E yyyy.MM.dd hh:mm:ss a zzz");

    /**
     * 取得当前服务器时间
     * */
    public static String getDate(){
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    /**
     * 取得服务器IP
     * */
    public static String getServerIP(){
        String ip = null;
        try {
            ip = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ip;
    }

    /**
     * 取得本机地址
     * */
    public static String getLoaclHost(){
        return "http://172.24.1.1:8080";
    }
}
