package com.fc.service;

import com.fc.vo.ResultVo;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    ResultVo upload(MultipartFile file, String type);

}
