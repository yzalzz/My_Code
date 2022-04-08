package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("file")
public class UploadController {
    @RequestMapping("upload")
    //MultipartFile 是Spring封装好的文件上传 他代表我们上传的文件
public ModelAndView testUpload(MultipartFile upload, ModelAndView mv){
        //准备上传路径
        String path="D:/图片";

        File file = new File(path);
        //文件上传路径为空
        if (!file.exists()){
            //创建一个上传路径
            file.mkdirs();
        }
        //获取文件名
        String originalFilename = upload.getOriginalFilename();

        try {
            if (originalFilename != null) {
                //上传文件
                upload.transferTo(new File(path,originalFilename));
                mv.addObject("img","http://localhost:8081/upload/"+originalFilename);
                mv.setViewName("/success.jsp");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mv;
}


}
