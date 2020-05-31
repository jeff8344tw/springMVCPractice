package com.jeff.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;

@Controller
public class TestUploadAndDownController {

    @RequestMapping("/down")
    public ResponseEntity<byte[]> down(HttpSession session) throws IOException {

        // 獲取下載文件的路徑
        String realPath = session.getServletContext().getRealPath("img");
        String finalPath = realPath + File.separator + "YUvVtXL.jpg";
        InputStream is = new FileInputStream(finalPath);
        // available():獲取輸入劉所讀取文件的最大字節數
        byte[] b = new byte[is.available()];
        is.read(b);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=zzz.jpg");
        // 設置響應狀態
        HttpStatus statusCode = HttpStatus.OK;

        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(b, headers, statusCode);
        return entity;
    }


    @RequestMapping(value = "/up", method = RequestMethod.POST)
    public String up(String desc, MultipartFile uploadFile, HttpSession session) throws IOException {
        // 獲取上傳文件的名稱
        String fileName = uploadFile.getOriginalFilename();
        String finalFileName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));
        String path = session.getServletContext().getRealPath("photo") + File.separator + fileName;
        File file = new File(path);
        uploadFile.transferTo(file);
        return "success";
    }

    @RequestMapping(value = "/up_old", method = RequestMethod.POST)
    public String up_old(String desc, MultipartFile uploadFile, HttpSession session) throws IOException {
        // 獲取上傳文件的名稱
        String fileName = uploadFile.getOriginalFilename();
        String path = session.getServletContext().getRealPath("photo") + File.separator + fileName;
        // 獲取輸入流
        InputStream is = uploadFile.getInputStream();
        // 獲取輸出流
        File file = new File(path);
        OutputStream os = new FileOutputStream(file);
//        int i = 0;
//        while((i = is.read()) != -1){
//            os.write(i);
//        }
        int i = 0;
        byte[] b = new byte[1024];
        while((i = is.read(b)) != -1){
            os.write(b, 0, i);
        }

        os.close();
        is.close();
        return "success";
    }
}
