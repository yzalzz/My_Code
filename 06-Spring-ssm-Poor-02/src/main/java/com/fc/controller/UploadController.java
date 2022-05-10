package com.fc.controller;

import com.fc.service.UploadService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
@CrossOrigin("/*")
public class UploadController {
    @Autowired
    private UploadService uploadService;
    @PostMapping("uploadImg")
    public ResultVo upload(MultipartFile file,@RequestParam String type){
        return uploadService.upload(file,type);
    }

}

