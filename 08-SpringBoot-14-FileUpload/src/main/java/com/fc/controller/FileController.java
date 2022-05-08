package com.fc.controller;

import com.fc.util.FileUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


@Controller
@RequestMapping("fileUpload")
public class FileController {
    @PostMapping("form")
    //前端给后端传个文件我们要用MultipartFile 来接收
    //MultipartFile headImg 接受单个文件
    //MultipartFile [] photo 接受多个文件
    //@RequestPart 用来进行参数绑定但是它只能用来绑定文件

    public String formFileUpload(@RequestParam("headImg") MultipartFile headImg, @RequestParam("photo") MultipartFile [] photo){
        //表单
        //单文件上传
        if(!headImg.isEmpty()){
            FileUploadUtil.fileUpload(headImg);
        }
        //多文件上传
        //photo.length>0数组个数大于0
        if (photo !=null && photo.length>0){
            for (MultipartFile file : photo) {
                FileUploadUtil.fileUpload(file);
            }
        }
        return "redirect:/success.html";
    }
    //json
    @PostMapping("json")
    @ResponseBody //后端传给前端一个json
    public Map<String,Object> jsonFileUpload(@RequestParam("headImg") MultipartFile headImg, @RequestParam("photo") MultipartFile [] photo){
        HashMap<String, Object> map = new HashMap<>();
        HashSet<String> paths = new HashSet<>();
        if (!headImg.isEmpty()){
        FileUploadUtil.fileUpload(headImg);
    }
        System.out.println( FileUploadUtil.fileUpload(headImg));
    if (photo !=null&&photo.length>0){
        for (MultipartFile file : photo) {
            String path = FileUploadUtil.fileUpload(file);
            paths.add(path);
        }
    }
    map.put("code",200);
        map.put("message","文件上传成功");
        map.put("success",true);
        map.put("data",paths);

    return map;

    }
}
