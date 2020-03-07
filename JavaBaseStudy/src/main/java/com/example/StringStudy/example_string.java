package com.example.StringStudy;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

//用+的方式效率最差，concat由于是内部机制实现，比+的方式好了不少。
//Join 和 StringBuffer，相差不大，Join方式要快些，可见这种JavaScript中快速拼接字符串的方式在Java中也非常适用。
//StringBuilder 的速度最快，但其有线程安全的问题，而且只有JDK5支持。
public class example_string {
    public static void main(String[] args) {
        example_string es=new example_string();
        es.testPlush();
        es.testConcat();
        es.testJoin();
        es.testStringBuilder();
        es.testStringBuffer();
    }

    public void testPlush(){
        String s="";
        long ts=System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            s=s+String.valueOf(i);
        }
        long te=System.currentTimeMillis();
        System.out.println("+ cost "+ (te - ts) +" ms");
    }

    public void testConcat() {
        String s = "";
        long ts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            s = s.concat(String.valueOf(i));
        }
        long te=System.currentTimeMillis();
        System.out.println("+ cost "+ (te - ts) +" ms");
    }

    public void testJoin() {
        List<String> list = new ArrayList<String>();
        long ts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list.add(String.valueOf(i));
        }

        StringUtils.join(list, "");
        long te = System.currentTimeMillis();
        System.out.println("+ cost "+ (te - ts) +" ms");
    }

    public void testStringBuffer() {
        StringBuffer sb = new StringBuffer();
        long ts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            sb.append(String.valueOf(i));
        }
        sb.toString();
        long te = System.currentTimeMillis();
        System.out.println("+ cost "+ (te - ts) +" ms");
    }

    public void testStringBuilder() {
        StringBuilder sb = new StringBuilder();
        long ts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            sb.append(String.valueOf(i));
        }
        sb.toString();
        long te = System.currentTimeMillis();
        System.out.println("+ cost "+ (te - ts) +" ms");
    }
}
