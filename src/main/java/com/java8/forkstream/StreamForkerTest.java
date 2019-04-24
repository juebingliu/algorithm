package com.java8.forkstream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/4/24 18:04
 * @description
 */
public class StreamForkerTest {
    public static void main(String[] args) {
        StreamForker.Results results = new StreamForker<Phone>(StreamForkerTest.createList().stream())
                .fork("getAllNames",s -> s.map(Phone::getName).collect(Collectors.joining(", ")))
                .fork("getMostExpensivePhone",s -> s.collect(Collectors.reducing((p1,p2) -> p1.getPrice() > p2.getPrice() ? p1:p2)).get())
                .fork("groupBySystemType",s -> s.collect(Collectors.groupingBy(Phone::getSystemType,Collectors.counting())))
                .fork("totalPrice",s -> s.mapToInt(Phone::getPrice).sum())
                .getResults();

        String names = results.get("getAllNames");
        Phone mostExpensivePhone = results.get("getMostExpensivePhone");
        Map<SystemType,Integer> map = results.get("groupBySystemType");
        int totalPrice = results.get("totalPrice");
        System.out.println("names: "+names);
        System.out.println("mostExpensivePhone: "+mostExpensivePhone.getName());
        System.out.println("groupBySystemType: "+map);
        System.out.println("totalPrice: "+totalPrice);
    }

    public static List<Phone> createList() {
        return Arrays.asList(
            new Phone("iphoneX",7000,"A11",SystemType.IOS),
            new Phone("galaxy S10+",8000,"Snapdragon 855",SystemType.Android),
            new Phone("iphoneXR",5000,"A12",SystemType.IOS),
            new Phone("mi 8",2500,"Snapdragon 845",SystemType.Android),
            new Phone("huawei p30 pro",5500,"kirin980",SystemType.Android)
        );
    }
}