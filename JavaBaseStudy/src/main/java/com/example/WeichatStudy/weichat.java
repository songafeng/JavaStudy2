package com.example.WeichatStudy;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import javafx.util.Pair;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class weichat {
    public static void main(String[] args) {

        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");
        items.add("E");

        //method reference
        //Output : A,B,C,D,E
        items.forEach(System.out::println);

        items.stream()
                .filter(s->s.contains("B"))
                .forEach(System.out::println);

//        String url = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=0af094a4-4f0a-4cd9-8352-17565691fe0b";
//        Map<String, Object> param  =  new HashMap<>();
//        param.put("msgtype", "markdown");
//        Map<String, String> content  =  new  HashMap<>();
//        content.put("content", "实时新增用户反馈<font color=\"warning\">132例</font>，请相关同事注意。\n "
//                + ">类型:<font color=\"comment\">用户反馈</font>\n"
//                + ">普通用户反馈:<font color=\"comment\">117例</font>\n"
//                + ">VIP用户反馈:<font color=\"comment\">15例</font>");
//        param.put("markdown", content);    //发送消息
//        String post = HttpUtil.post(url, JSONObject.toJSONString(param));
//        System.out.println(post);
    }

}
