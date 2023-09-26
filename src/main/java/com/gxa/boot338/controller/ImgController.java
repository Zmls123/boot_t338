package com.gxa.boot338.controller;

import com.gxa.boot338.common.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("img")
public class ImgController {

    @PostMapping("/upload")
    public R update(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        //接收上传文件的一种对象类型MultipartFile

        //获取特征
        String originalFilename=multipartFile.getOriginalFilename();
        String name=multipartFile.getName();
        long size=multipartFile.getSize();
        byte[] bytes = multipartFile.getBytes();


        System.out.println(originalFilename);
        System.out.println(name);
        System.out.println(size+"字节");

        //获取后缀名
        String ext=originalFilename.substring(originalFilename.lastIndexOf(".")+1);
        System.out.println(ext);
        //设置一个随机的文件名
        String filename=UUID.randomUUID().toString().replaceAll("-","");
        System.out.println(filename);
        //把用户成功上传的图片，保存再服务器中
        File file = new File("D:\\img\\"+filename+"."+ext);
        //创建文件输出流
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        fileOutputStream.close();
        return R.success("上传成功！");
    }
}
