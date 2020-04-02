package com.bonree.util;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.Map;

/**
 * Json读取工具类
 */
public class JsonUtil {

    /**
     * 读取json文件
     * @param jsonFile json文件名
     * @return 返回json字符串
     */
    public static String readJsonFile(File jsonFile) {
        String jsonStr = "";
        System.out.println("————开始读取" + jsonFile.getPath() + "文件————");
        try {
            //File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            System.out.println("————读取" + jsonFile.getPath() + "文件结束!————");
            return jsonStr;
        } catch (Exception e) {
            System.out.println("————读取" + jsonFile.getPath() + "文件出现异常，读取失败!————");
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        File file = new File("src/main/resources/config.json");
        String jsonStr = readJsonFile(file);
        Map jsonMap = (Map) JSON.parse(jsonStr);
        System.out.println(jsonMap);
    }
}
