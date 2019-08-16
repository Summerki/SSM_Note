package com.suki.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class DownloadController {

    @RequestMapping("download")
    public String download(HttpServletResponse response){

        try {
            // 为了解决文件名字中有中文的问题
            response.setHeader("content-disposition","attachment;filename=" + new String("测试文件.mp4".getBytes("UTF-8"), "ISO-8859-1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        ServletOutputStream out = null;  // 输出流对象，当前响应里面有输出对象
        InputStream in = null;
        try {
            in = new FileInputStream(new File("E:\\学习视频\\测试文件.mp4"));
            out = response.getOutputStream();
            IOUtils.copy(in, out);
        }catch (IOException e){
            e.printStackTrace();
        }


        return "suc";
    }

}
