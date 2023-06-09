package com.longklxs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class FileuploadController {

    @RequestMapping("/testimage")
    public String fileUpload(MultipartFile file, HttpServletRequest request){
        String basePath = request.getServletContext().getRealPath("/upload");

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(date);
        File file1 = new File(basePath,format);
        if(!file1.exists()){
            file1.mkdirs();
        }

        String uuid = UUID.randomUUID().toString().replace("-", "");
        String fileName = uuid + file.getOriginalFilename();
        try {
            File file2 = new File(file1,fileName);
            file.transferTo(file2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "success";


    }
}
