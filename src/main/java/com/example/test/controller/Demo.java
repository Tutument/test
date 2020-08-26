package com.example.test.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

@Controller
public class Demo {


    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/downloadFile")
    @ResponseBody
    private String downloadFile(HttpServletResponse response, HttpServletRequest request){


        String downloadFilePath = "D:\\\\data\\\\a.jpg";//被下载的文件在服务器中的路径,
        String fileName = "mn.jpg";
        File file = new File(downloadFilePath);
        if(file.exists()){ //判断文件父目录是否存在
            response.setContentType("application/force-download");
            response.setHeader("Content-Length", file.length()+"");
            response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);

            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;
            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i ;
                while((i = bis.read(buffer)) != -1){
                    os.write(buffer,0,i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("file download:  " + fileName);
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //若这个return不是null，则必须在方法上加@ResponseBody这个注解，让他返回的数据转为json数据，不占getOutputStream()的流
        return "下载失败";
    }

    @RequestMapping("/upload")
    public String go(){
        return "upload";
    }

    @ResponseBody
    @RequestMapping(value = "/uploadFile" , method = RequestMethod.POST)
    public String getFile( HttpServletRequest request,@RequestParam("file") MultipartFile mfile) {
        String prixff = mfile.getOriginalFilename();

        try {

            File file = new File("D:\\\\jar\\\\heihei.mp4");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            FileOutputStream fos = null;
            InputStream fis = null;
            try {
                fos = new FileOutputStream(file);
                byte[] buff = new byte[1024];
                int length = 0;
                fis = mfile.getInputStream();
                while ((length = fis.read(buff)) > 0) {
                    fos.write(buff, 0, length);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "成功";
    }
}