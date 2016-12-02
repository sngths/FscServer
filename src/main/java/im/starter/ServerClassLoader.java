package im.starter;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by tianxing on 16/12/1.
 *
 */
public class ServerClassLoader extends URLClassLoader {


    /**
     * 创建类加载器 指定目录下的所有 以 .jar   .zip  .war 结尾的文件 都为类加载器搜索路径
     *
     * */
    public ServerClassLoader(ClassLoader parent, File libDir) throws MalformedURLException {
        super(new URL[]{libDir.toURI().toURL()}, parent);

        File[] jars = libDir.listFiles((dir, name) -> {
            boolean accept = false;
            String smallName = name.toLowerCase();
            if (smallName.endsWith(".jar")) {
                accept = true;
            } else if (smallName.endsWith(".zip")) {
                accept = true;
            } else if (smallName.endsWith(".war")) {
                accept = true;
            }
            return accept;
        });

        if (jars == null) {
            return;
        }

        //添加到类加载器搜寻路径
        for (File file : jars) {
            if (file.isFile()) {
                addURL(file.toURI().toURL());
            }
        }
    }
}
