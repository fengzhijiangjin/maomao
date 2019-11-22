package com.wxinnb.maomao.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class FileUtils {

    public static String saveIcon(MultipartFile icon) {

//        String mkdir = mkdir() + "/newsIcon/";
        String path = "D:/imgs/";
        //保存图片到
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        //jpg
//        String ext = FilenameUtils.getExtension(newsIcon.getOriginalFilename());
        String fileName = icon.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf("."));
        String url_path = path + name + "." + ext;
        try {
            icon.transferTo(new File( url_path)); //保存图片
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url_path;
    }

}
