package com.gxa.boot338.controller;

import com.gxa.boot338.common.R;
import com.gxa.boot338.util.COSUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Api(tags = "上传接口")
@RestController
@RequestMapping("/upload")
@Slf4j
public class UploadController {

    /*
    * multipartFile 接收图像信息
    * */
    @ApiOperation("上传图像接口，上传到COS服务器")
    @PostMapping("/img")
    public R uploadImg(@RequestParam("file")MultipartFile multipartFile) throws IOException {
        //把multipartFile上传到COS

        String originalFilename = multipartFile.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));

        //转换之前创建临时文件
        File localfile=File.createTempFile("temp-",substring);
        //通过transferto传输方法，将上传的文件内容传输到目标临时文件中
        multipartFile.transferTo(localfile);

        //通过COS的工具类，把接收内容放在upfile中
        String prefix="/spu";
        String uploadfile=COSUtil.uploadfile(localfile,prefix);
        System.out.println(uploadfile);

        if (localfile!=null){
            boolean delete=localfile.delete();
            System.out.println(delete);
            log.info("delete:"+delete);
        }

        //声明存储桶的固定路径
        String url="/uploadImg";

           return R.success(url+uploadfile);
    }


}
