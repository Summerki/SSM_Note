package com.suki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

@Controller
public class UploadController {

    private String uploadParent = "D:" + File.separator;

    @RequestMapping("upload")
    public String upload(@RequestParam("files")MultipartFile[] multipartFiles){

        File subDir = handle(uploadParent);


        for (MultipartFile mf : multipartFiles) {
            File dest = new File(subDir, mf.getOriginalFilename());
            try {
                mf.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "suc";
    }

    private File handle(String uploadParent){
        LocalDate localDate = LocalDate.now();
        File parent = new File(uploadParent);
        File[] files = parent.listFiles();

        for (File f : files) {
            if (f.isDirectory()) {
                if (f.getName().equals(localDate.toString())) {
                    return f;
                }
            }
        }

        File file = new File(uploadParent, localDate.toString());
        return file;

    }

}
