package com.dmm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 *
 * 文件上传
 * @author DMM
 * @create 2019/9/27
 */
@Controller
public class UploadController {

    @RequestMapping(value = "upload",method = RequestMethod.POST)
    @ResponseBody
    //file 要与表单的name相同
    public String uploadFile(MultipartFile file, HttpServletRequest servletRequest){


        try {

            //创建文件在服务器端的路径
            String dir=servletRequest.getServletContext().getRealPath("/upload");

            File fileDir=new File(dir);

            //判断文件夹是否存在
            if(!fileDir.exists()){
                fileDir.mkdirs();
            }

            //获取后缀名
            String fileSuffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

            String fileName= UUID.randomUUID().toString()+fileSuffix;

            File file1=new File(fileDir+"/"+fileName);

            //上传
            file.transferTo(file1);

        } catch (Exception e) {
            e.printStackTrace();

            return "上传失败";
        }

        return "上传成功";
    }


    @RequestMapping(value = "/upload/batch",method = RequestMethod.POST)
    @ResponseBody
    //file 要与表单的name相同
    public String uploadFiles(MultipartFile[] file, HttpServletRequest servletRequest){


        try {

            //创建文件在服务器端的路径
            String dir=servletRequest.getServletContext().getRealPath("/upload");

            File fileDir=new File(dir);

            //判断文件夹是否存在
            if(!fileDir.exists()){
                fileDir.mkdirs();
            }

            for(int i=0;i<file.length;i++){
                //获取后缀名
                String fileSuffix=file[i].getOriginalFilename().substring(file[i].getOriginalFilename().lastIndexOf("."));

                String fileName= UUID.randomUUID().toString()+fileSuffix;

                File file1=new File(fileDir+"/"+fileName);

                //上传
                file[i].transferTo(file1);
            }





        } catch (Exception e) {
            e.printStackTrace();

            return "上传失败";
        }

        return "上传成功";
    }
}

