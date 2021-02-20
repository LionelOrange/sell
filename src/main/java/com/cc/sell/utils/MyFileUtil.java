package com.cc.sell.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chencheng
 * @date 2021/1/17
 */
public class MyFileUtil {

    private static void filesTest(String filePath, String content) throws IOException {
        Files.write(Paths.get(filePath),content.getBytes());
    }

    private static void bufferOutputStreamTest(String filePath, String content) throws IOException {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath))) {
            bufferedOutputStream.write(content.getBytes());
        }
    }

    private static void fileOutputStreamTest(String filePath, String content) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            fileOutputStream.write(content.getBytes());
        }
    }

    private static void printWriter(String filePath, String content) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filePath))) {
            printWriter.append(content);
        }
    }

    private static void bufferWriterTest(String filePath, String content) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.append(content);
        }
    }

    private static void fileWriterTest(String filePath, String content) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.append(content);
        }
    }

    public static void writeDataAsTxt(List<String> result, String fileName, String filePath) throws IOException {
        if (result == null || result.isEmpty() || StringUtils.isBlank(fileName)) {
            return;
        }
        long start = System.currentTimeMillis();

        File pathFile = new File(filePath);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        String relFilePath = filePath + File.separator + fileName;
        File file = new File(relFilePath);
        if (!file.exists()) {
            file.createNewFile();
        }

        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "utf-8"))) {

            for (String info : result) {
                out.write(info);
                out.newLine();
            }
            System.out.println("写入文件耗时：*********************************" + (System.currentTimeMillis() - start) + "毫秒");
        }
    }

    public static void readDataAsTxt(List<String> result, String filePath) throws IOException {
        if (result == null || result.isEmpty() || StringUtils.isBlank(filePath)) {
            return;
        }
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }

        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), StandardCharsets.UTF_8))) {

            for (String info : result) {
                out.write(info);
                out.newLine();
            }
        }
    }

    public static String readFile(String filePath) throws IOException{
        String lastStr = "";
        String tempString ;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))){
            while ((tempString = reader.readLine()) != null) {
                lastStr += tempString;
            }
        }
        return lastStr;
    }

    public static List<String> readFileList(String filePath) throws IOException{
        List<String> list = new ArrayList<>();
        String tempString ;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))){
            while ((tempString = reader.readLine()) != null) {
                list.add(tempString);
            }
        }
        return list;
    }

    /**
     * http下载文件到本地
     * @param downloadUrl 下载链接
     * @param fileUrl 磁盘文件位置
     * @return
     */
    public static String saveToFile(String downloadUrl, String fileUrl) {
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpUrl = null;
        URL url = null;
        byte[] buf = new byte[1024];
        int size;

        try {
            //这里填入下载的URL
            url = new URL(downloadUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            fos = new FileOutputStream(fileUrl);
            while ((size = bis.read(buf)) != -1) {
                fos.write(buf, 0, size);
            }
            //记得及时释放资源
            fos.close();
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        httpUrl.disconnect();
        return fileUrl;
    }

    public static void main(String[] args) {
        System.out.println("ss");
    }
}