package com.fc.service.impl;

import com.fc.service.UploadService;
import com.fc.vo.DataVo;
import com.fc.vo.ResultVo;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UploadServiceImpl implements UploadService {
    @Override
    public ResultVo upload(MultipartFile file, String type) {
        ResultVo resultVo=null;
        // 准备路径
        String path = "D:/tomcat/server/apache-tomcat-8.5.37/webapps/upload/poverty_alleviation/"+type;

        File file1 = new File(path);

        //判断路径是否可用
        if (!file1.exists()){
            //如果不可用创建
            file1.mkdirs();
        }
        //获取上传文件名
        String filename = file.getOriginalFilename();
        // 获取后缀名
        String suffix = filename.substring(filename.lastIndexOf('.'));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        String format = formatter.format(new Date());
        // 拼接成一个新的文件名
        filename = format + suffix;

        try {
            //上传到服务器
            file.transferTo(new File(path,filename));
            Map<String, Object> map = new HashMap<>();
            map.put("imgurl","http://localhost:8081/upload/poverty_alleviation"+"/"+type+"/"+filename);
            System.out.println(map.get("imgurl"));
            resultVo=new ResultVo(200,"文件上传成功",true,map);
        } catch (IOException e) {
            e.printStackTrace();
            resultVo=new ResultVo(400,"文件上传失败",false,"");
        }

        return resultVo;
        }
    }












//
//        ResultVo resultVo = null;
//        String path = "D:/tomcat/server/apache-tomcat-8.5.37/webapps/upload";
//        File files = new File(path);
//        //文件上传路径为空
//        if (!files.exists()) {
//            files.mkdirs();
//        }
//        //获取文件名
//        String originalFilename = file.getOriginalFilename();
//        try {
//            if (originalFilename != null) {
//                //上传文件
//                file.transferTo(new File(path, originalFilename));
//                resultVo = new ResultVo(200, "查询成功", true,  "http://localhost:8081/upload"+"/"+ originalFilename);
//                System.out.println(resultVo);
//            } else {
//                resultVo = new ResultVo(400, "查询失败", false, null);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return resultVo;
//    }





