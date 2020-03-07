package com.example.ArrayStudy;

//动态数组,三个点"..."动态参数
//在Java1.5之后在方法上传参时便出现了**"…"**,这三个点的学名叫做可变长参数,也就是相当于一个数组,能够传入0个至n个参数
public class DynamicArray {
    public static void main(String[] args) {
        String[] t1 = {};
        String[] t2 = {"java","C++"};
        String t3 = "java";
        threePoint("java","C++","Python");
        threePoint(t1);
        threePoint(t2);
        threePoint(t3);
        //threePoint(t3,t2);//类型错误,数组只能传一个
    }


    public static void threePoint(String... s) {
        if (s == null) {
            return;
        }

        int len = s.length;
        if (len == 0) {
            System.out.println("没有字符");
        } else {
            for (String s1 : s
            ) {
                System.out.println(s1 + " ");
            }
        }
        System.out.println("==============================");
    }
}
