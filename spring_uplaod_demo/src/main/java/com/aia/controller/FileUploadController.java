package com.aia.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
    @RequestMapping("/fileupload")
    public String fileupload(HttpServletRequest request) throws Exception {
       //文件存放路径
        String path = request.getSession().getServletContext().getRealPath("/uplaod/");
        File file = new File(path);
        if (!file.exists()){
            //文件不存在则创建
            file.mkdir();
        }
        //获取文件上传项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> list = upload.parseRequest(request);
        for (FileItem item :list) {
            //进行判断是否是上传文件项
            if (item.isFormField()){

            } else {
                //处理上传文件
               String fileName = item.getName();
               String uuid = UUID.randomUUID().toString().replace("-","");
               fileName = uuid + "_" + fileName;
               item.write(new File(path,fileName));
               //删除临时文件
               item.delete();
            }
        }
        return "success";
    }

    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception {
//文件存放路径
        String path = request.getSession().getServletContext().getRealPath("/uplaod/");
        File file = new File(path);
        if (!file.exists()){
            //文件不存在则创建
            file.mkdir();
        }

        String fileName = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-","");
        fileName = uuid + "_" + fileName;
        upload.transferTo(new File(path,fileName));
        return "success";
    }
}
