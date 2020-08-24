package com.example.SteamStudy.steam_1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MyTest {
    public static void printValur(String str) {
        System.out.println("print value:"+str);
    }

    public static void main(String[] args){
        List<String> al= Arrays.asList("a","b","c","d");
        al.forEach(MyTest::printValur);

        Consumer<String> methodParam=MyTest::printValur;
        al.forEach(x->methodParam.accept(x));
    }
}
