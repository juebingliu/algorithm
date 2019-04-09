package com.dic;

import java.util.HashMap;
import java.util.Map;

/**
 * map[]->String&String->map[]
 */
public class DictUtil {

//    public static String store(Map<String,String> arr[]) {
////        if(arr.length == 0) {
////            return "";
////        }
////        StringBuffer sb = new StringBuffer();
////        for (int i = 0; i<arr.length; i++) {
////            Map<String,String> map = arr[i];
////            for(Map.Entry<String,String> e : map.entrySet()) {
////                sb.append(e.getKey()).append("=").append(e.getValue()).append(";");
////            }
////            sb.append("\n");
////        }
////        return sb.toString().substring(0,sb.toString().length()-2).replaceAll(";\\n","\n");
////    }
////
////    public static Map[] load(String text) {
////        String[] arr = text.split("\n",-1);
////        if(arr.length == 0 ) {
////            return null;
////        }
////        Map[] maps = new Map[arr.length];
////        for(int i=0; i<arr.length; i++) {
////            Map<String,String> map = new HashMap<>();
////            String[] kvs = arr[i].split(";",-1);
////            for(int j = 0; j<kvs.length; j++) {
////                String[] kv = kvs[j].split("=",-1);
////                map.put(kv[0],kv[1]);
////            }
////            maps[i] = map;
////        }
////        return maps;
////    }

    public static void store(Map<String,String>[] arr) {
        if(arr.length == 0) {
            return ;
        }
        Dict dict = new Dict();
        dict.store(arr,dict);
    }

    public static Map[] load(String text) {
        if("".equals(text)) {
            return null;
        }
        Dict dict = new Dict();
        return dict.load(text,dict);
    }

    public static void main(String[] args) {
        //store
        Map<String,String> map1 = new HashMap<>();
        Map<String,String> map2 = new HashMap<>();
        map1.put("k1","v1");
        map1.put("k2","v2");
        map2.put("A","XXX");
        Map[] map = {map1,map2};
        DictUtil.store(map);

        System.out.println("-----------------");

        //load
        String str = "k1=v1;k2=v2\nA=XXX";
        Map<String,String>[] maps = DictUtil.load(str);
        for (int i=0; i<maps.length; i++){
            for (Map.Entry<String,String> kv : maps[i].entrySet()) {
                System.out.println(kv.getKey() +":"+kv.getValue());
            }
        }

        System.out.println("-----------------");

        //contain&remove
        Dict dict = new Dict();
        dict.add("a1","v1");
        dict.add("a2","v2");
        dict.add("b1","v3");
        dict.add("c1","v4");
        System.out.println(dict.contain("a1"));
        dict.remove("a1");
        System.out.println(dict.contain("a1"));
        System.out.println(dict.contain("a2"));
        System.out.println(dict.contain("a3"));
        System.out.println(dict.contain("d1"));

        System.out.println("-----------------");

        //get
        System.out.println(dict.get("a2"));
    }
}