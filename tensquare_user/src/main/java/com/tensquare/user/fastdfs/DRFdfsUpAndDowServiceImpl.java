package com.tensquare.user.fastdfs;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Created by 1 on 2018/10/26.
 */
@Service
public class DRFdfsUpAndDowServiceImpl {

    @Autowired
    private FastDFSClientWrapper fastDFSClientWrapper;

    private final Logger logger = LoggerFactory.getLogger(DRFdfsUpAndDowServiceImpl.class);

    public void deleteFile(String url){
        fastDFSClientWrapper.deleteFile(url);
    }

    public String uploadFile2(File file){
        byte[] bytes = new byte[0];
        try {
            bytes = DRFdfsUpAndDowServiceImpl.getBytes(file);
        } catch (Exception e) {
            logger.error("获取文件错误");
            e.printStackTrace();
        }
        //获取源文件名称
        String originalFileName = file.getName();
        //获取文件后缀--.doc
        String extension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String fileName = file.getName();
        //获取文件大小
        long fileSize = file.length();
        System.out.println(originalFileName + "==" + fileName + "==" + fileSize + "==" + extension + "==" + bytes.length);
        return fastDFSClientWrapper.uploadFile(bytes, fileSize, extension);
    }

    /**
     *  文件上传
     *  最后返回fastDFS中的文件名称;group1/M00/01/04/CgMKrVvS0geAQ0pzAACAAJxmBeM793.doc
     * @param file 页面提交时文件
     * @return
     */
    public String uploadFile(MultipartFile file){
        byte[] bytes = new byte[0];
        try {
            bytes = file.getBytes();
        } catch (IOException e) {
            logger.error("获取文件错误");
            e.printStackTrace();
        }
        //获取源文件名称
        String originalFileName = file.getOriginalFilename();
        //获取文件后缀--.doc
        String extension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String fileName = file.getName();
        //获取文件大小
        long fileSize = file.getSize();
        System.out.println(originalFileName + "==" + fileName + "==" + fileSize + "==" + extension + "==" + bytes.length);
        return fastDFSClientWrapper.uploadFile(bytes, fileSize, extension);
    }

    /**
     *  文件下载
     * @param fileUrl 当前对象文件名称
     * @param response   HttpServletResponse 内置对象
     * @throws IOException
     */
    public void downloadFile(String fileUrl, HttpServletResponse response) throws IOException {
        byte[] bytes = fastDFSClientWrapper.downloadFile(fileUrl);
        // 这里只是为了整合fastdfs，所以写死了文件格式。需要在上传的时候保存文件名。下载的时候使用对应的格式
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("sb.xlsx", "UTF-8"));
        response.setCharacterEncoding("UTF-8");
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static byte[] getBytes(File file){
        byte[] buffer = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

}

