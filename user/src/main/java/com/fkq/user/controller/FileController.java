package com.fkq.user.controller;

import com.fkq.user.entity.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileController {

    private String filePath = "D:/IntelliJ IDEA 2018.2.6/workspaces/Person/src/main/resources/static/images/";

    @RequestMapping(value = "page")
    public Object index() {
        return "upload";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Object upload(@RequestParam("file") MultipartFile file) {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名,比如图片的jpeg,png
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件上传后的路径
        fileName = UUID.randomUUID() + suffixName;

        File fileSave = new File(filePath + fileName);
        try {
            file.transferTo(fileSave);
            return new JsonData(0, fileName, "上传文件成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JsonData(-1, fileName, "上传文件出现错误");
    }
}
