package com.bonree;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bonree.constant.Constants;
import com.bonree.util.HttpClientResult;
import com.bonree.util.HttpClientUtils;
import com.bonree.util.JsonUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kehandi
 * @title: UploadDemo
 * @projectName test
 * @description: TODO
 * @date 2020/4/2 15:17
 */
public class UploadDemo {
    public static HttpClientResult upload() {

        // upload 接口地址
        String configUrl = Constants.baseUrl + "/upload" + "?key=" + Constants.md5 + "_" + System.currentTimeMillis()/1000;

        // 定义一个文件对象，接收config.json文件数据
        File file = new File("src/main/resources/upload.txt");
        // 读取json文件到字符串
        String jsonStr = JsonUtil.readJsonFile(file);
        // json字符串转JSON对象
        JSONObject paramObject = (JSONObject) JSON.parse(jsonStr);
        // 把JSON对象 转成 包含两个参数的键值对Map，用于调用post请求的参数
        Map<String, String> params = new HashMap<String, String>();
        for (Map.Entry entry : paramObject.entrySet()) {
            String value = entry.getValue().toString();
            params.put(entry.getKey().toString(), value);
        }

        // 构造headers参数
        Map<String, String> headers = (Map<String, String>) JSON.parse("{\"ProtoTYPE\": \"json\",\"brkey\":\"45645454\"}");

        try {
            // 发送post请求
            HttpClientResult httpClientResult = HttpClientUtils.doPost(configUrl, headers, params);
            // 在控制台打印 upload 结果
            System.out.println("upload 结果" + httpClientResult);
            return  httpClientResult;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
