package com.bonree;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bonree.util.HttpClientResult;
import com.bonree.util.JsonUtil;

/**
 * @author kehandi
 * @title: Test
 * @projectName test
 * @description: TODO
 * @date 2020/4/2 16:59
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {

        int i = 0;
        while (true) {
            Thread.sleep(20 * 1000);
            HttpClientResult configResult = ConfigDemo.config();
            if (configResult == null || configResult.getContent() == null) continue;
            HttpClientResult uploadResult = UploadDemo.upload();
            if (uploadResult == null || uploadResult.getContent() == null) continue;

            JSONObject jsonObject = (JSONObject) JSON.parse(uploadResult.getContent());
            JSONObject jsonObject1 = (JSONObject) jsonObject.get("ur");
            Integer ss = (Integer) jsonObject1.get("rc");
            if (ss == 19) {
                i++;
                System.out.println("request number:" + i);
            } else {
                System.out.println("发送失败");
                break;
            }

        }
    }
}
