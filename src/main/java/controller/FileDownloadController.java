package controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by tianxing on 16/9/27.
 * 提供图片下载
 */
@RestController
public class FileDownloadController {


    /**
     * 图片下载
     * */
    @RequestMapping(value = "image/{imageName}", method = RequestMethod.GET)
    public void imgageDownload(@PathVariable(value = "imageName") String imageName, HttpServletRequest request, HttpServletResponse response){
        //response.addHeader("Content-Type", "image/jpeg");
        System.out.println("请求图片:" + imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);

        File file = new File("/Users/tianxing/Desktop/WB121712_8.jpg");
        response.setContentLengthLong(file.length());
        try {
            response.getOutputStream().write(Files.readAllBytes(file.toPath()));
            //response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    /**
     * 文件下载
     * */





    /**
     * 大文件下载 支持断点续传
     * */
    @RequestMapping(value = "file/large", method = RequestMethod.GET)
    public void largeFileDownload(){

    }
}
