package com.example.ForStudy;

import java.util.Collection;
import java.util.Iterator;

public class For1Study {
    public static void main(String[] args)
    {
        String[] strings = {"A","B", "C","D"};
        Collection stringList = java.util.Arrays.asList(strings);
        /* 开始遍历 */
        for (Iterator itr = stringList.iterator(); itr.hasNext();) {
            Object str = itr.next();
            System.out.println(str);
        }
    }
}
