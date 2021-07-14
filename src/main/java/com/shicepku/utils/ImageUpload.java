package com.shicepku.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ImageUpload {
    public String saveImage(MultipartFile file){
        String staticPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        String fileName = file.getOriginalFilename();

        String exts = fileName.substring(fileName.lastIndexOf(".") + 1);
        fileName = UUID.randomUUID().toString().replace("-","")+"."+exts;
        String urlPath = "images" + File.separator + fileName;
        String savePath = staticPath + File.separator + urlPath;
        // 访问路径=静态资源路径+文件目录路径
        String visitPath = urlPath;
        File saveFile = new File(savePath);
        if (!saveFile.exists()) {
            saveFile.mkdirs();
        }
        try {
            file.transferTo(saveFile);  //将临时存储的文件移动到真实存储路径下
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlPath;
    }
}
