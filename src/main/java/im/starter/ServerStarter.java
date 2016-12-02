package im.starter;

import im.Server;

import java.io.File;
import java.net.MalformedURLException;

/**
 * Created by tianxing on 16/12/1.
 *
 */
public class ServerStarter {


//    public static void main(String[] args) {
//        new ServerStarter().start();
//    }




    /**
     * 判断路径 添加路径到类加载器  加载Server 实例化启动
     * */
    private void start(){


        try {





            ClassLoader loader = new ServerClassLoader(findParentClassLoader(), new File("../libs"));
            Thread.currentThread().setContextClassLoader(loader);
            Class server = loader.loadClass("im.server.ImServer");
            server.newInstance();

        } catch (MalformedURLException | InstantiationException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    /**
     * 找出最佳的类加载器
     * */
    private ClassLoader findParentClassLoader() {
        ClassLoader parent = Thread.currentThread().getContextClassLoader();
        if (parent == null) {
            parent = this.getClass().getClassLoader();
            if (parent == null) {
                parent = ClassLoader.getSystemClassLoader();
            }
        }
        return parent;
    }
}
