package controller;


import entity.assignemnt.Image;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;


/**
 * Created by tianxing on 16/9/5.
 *
 */

@RestController
public class FileUploadController {


    @RequestMapping(value="upload", method = RequestMethod.GET)
    public Image provideUploadInfo() {
        System.out.println("获取上传信息");
        return new Image();
        //return "You can upload a file by posting to this same URL.";
    }




    /**
     * 文件上传
     * */
    @RequestMapping(value="upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public Image handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        Image image = new Image();
        System.out.println("开始接收文件上传");
        if (!file.isEmpty()) {
            String name = UUID.randomUUID().toString().replace("-", "");
            System.out.println(file.getName() + "  "  + file.getOriginalFilename() + "  " +file.getSize());
            if (file.getOriginalFilename() != null){
                if (file.getOriginalFilename().contains(".")){
                    String stringArray[] = file.getOriginalFilename().split("\\.");
                    name = name.concat(".").concat(stringArray[stringArray.length -1]);
                }
            }
            image.setName(name);
            try {
                file.transferTo(new File("/Users/tianxing/Desktop/upload/".concat(name)));
                return image;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
                //return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return null;
            //return "You failed to upload because the file was empty.";
        }
    }












//    @RequestMapping(value="/upload", method = RequestMethod.POST, consumes = "multipart/form-data")
//    public Image handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("description") String a) throws IOException {
//        if (!file.isEmpty()) {
//            //String name = file.getOriginalFilename();
//            String name = UUID.randomUUID().toString().replace("-", "");
//            if (file.getOriginalFilename() != null){
//                if (file.getOriginalFilename().contains(".")){
//                    String stringArray[] = file.getOriginalFilename().split(".");
//                    name = name.concat(stringArray[stringArray.length -1]);
//                }
//
//            }
//            try {
//                file.transferTo(new File("/Users/tianxing/Desktop/upload/".concat(name)));
//                return new Image();
//            } catch (Exception e) {
//                return null;
//                //return "You failed to upload " + name + " => " + e.getMessage();
//            }
//        } else {
//            return null;
//            //return "You failed to upload because the file was empty.";
//        }
//    }



}
