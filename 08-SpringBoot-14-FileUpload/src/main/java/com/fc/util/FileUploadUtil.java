package com.fc.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUploadUtil {
    public static String fileUpload(MultipartFile file){
        //文件上传步骤
        //准备路径
        String path="D:\\tomcat\\server\\apache-tomcat-8.5.37\\webapps\\upload";

        File locationFile = new File(path);
        //如果路径不存在就创建一个
        if (!locationFile.exists()){
            locationFile.mkdirs();
        }
        //拿到文件名
        String filename =file.getOriginalFilename();

        //拿到文件后缀名
        String substring = filename.substring(filename.lastIndexOf("."));
        //获取日期格式器
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSS");

        //获取文件前缀
        String prefix = formatter.format(new Date());
        //获取新文件名
        filename=prefix+substring;

        //上传
        try {
            file.transferTo(new File(locationFile,filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "http://localhost:8081/upload/" + filename;
    }
}
