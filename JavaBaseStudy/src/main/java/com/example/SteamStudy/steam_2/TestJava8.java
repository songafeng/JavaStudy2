package com.example.SteamStudy.steam_2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestJava8 {

    public static void main(String[] args) {

        List<Staff> staff = Arrays.asList(
                new Staff("m-m-k-yong", 30, new BigDecimal(10000)),
                new Staff("ja-ck", 27, new BigDecimal(20000)),
                new Staff("law-rence", 33, new BigDecimal(30000))
        );

        //Before Java 8
        List<String> result = new ArrayList<>();
        for (Staff x : staff) {
            result.add(x.getName());
        }
        System.out.println(result); //[mkyong, jack, lawrence]

        //Java 8
//        List<String> collect = staff.stream().map(x -> x.getName()).collect(Collectors.toList());
//        System.out.println(collect); //[mkyong, jack, lawrence]
//        staff.stream()
//                .map(x->x.getName().length())
//                .forEach(System.out::println);
        boolean result2=staff.stream()
                .map(x -> x.getName())
                .flatMap(e-> Stream.of(e.split("-")))
                .distinct()
                .anyMatch(x->x.equals("m"));


        System.out.println(result2);
    }

}