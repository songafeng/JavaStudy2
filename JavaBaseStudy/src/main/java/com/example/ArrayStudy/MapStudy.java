package com.example.ArrayStudy;

import java.util.HashMap;
import java.util.Map;

public class MapStudy {
    static Map map = new HashMap();

    public static void main(String[] args) {

        MapStudy mapStudy=new MapStudy();
        for(int i=0;i<10;i++)
            mapStudy.show(i);
    }

    public void show(int i)
    {
        map.put("x",i);
        System.out.println("x="+map.get("x"));
    }
}
