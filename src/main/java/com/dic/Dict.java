package com.dic;

import java.util.*;

/**
 * 字典类实现
 */
public class Dict {

    //存放字典的索引值->ASCII码
    private ArrayList<Integer> index;
    //存放同一索引下的字典值
    private Map<String, List<Element>> dict;

    private static class Element {
        private String key;
        private String value;

        public Element(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return key +"="+ value;
        }
    }

    public Dict() {
        index = new ArrayList<>();
        dict = new TreeMap<>();
    }

    public ArrayList<Integer> getIndex() {
        return index;
    }

    public void setIndex(ArrayList<Integer> index) {
        this.index = index;
    }

    public Map<String, List<Element>> getDict() {
        return dict;
    }

    public void setDict(Map<String, List<Element>> dict) {
        this.dict = dict;
    }

    /**
     * 拿到首个字符进行ASCII转码作为索引值,然后进行插入
     * @param key
     * @param value
     */
    public void add(String key ,String value) {
        char[] ch = key.toCharArray();
        int ascValue = Integer.valueOf(ch[0]);
        for (int i=0; i<index.size(); i++) {
            //比较index中所有索引值,若全不同，则插入，有相同key则对比对应map中list
            if(null == index.get(i) || index.get(i) != ascValue) {
                continue;
            } else {
                //得到索引值对应的map
                List<Element> list = dict.get(String.valueOf(index.get(i)));
                if(null != list) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        Element e = (Element) it.next();
                        if(e.getKey().equals(key)) {
                            e.setValue(value);
                            return ;
                        }
                    }
                    list.add(new Element(key,value));
                    dict.put(String.valueOf(index.get(i)),list);
                    return ;
                }else {
                    list = new ArrayList<>();
                    list.add(new Element(key,value));
                    dict.put(String.valueOf(index.get(i)),list);
                    return ;
                }
            }
        }
        //计算索引位置,新增
        //int location = (ascValue - 64) & ascValue;
        //index[location] = ascValue;
        index.add(ascValue);
        List<Element> list = new ArrayList<>();
        list.add(new Element(key,value));
        dict.put(String.valueOf(ascValue),list);
    }

    /**
     * 字符串化某一索引下所有字典值
     * @param index
     */
    public String getOneDictByIndex(int index) {
        StringBuffer sb = new StringBuffer();
        List<Element> list = dict.get(String.valueOf(index));
        for (int i=0; i<list.size(); i++) {
            if(i == list.size()-1) {
                sb.append(list.get(i).toString());
                return sb.toString();
            }
            sb.append(list.get(i).toString() + ";");
        }
        return null;
    }

    /**
     * 输出所有字典值
     * @return
     */
    public void store(Map<String,String>[] arr,Dict dict) {
        for(int i = 0; i<arr.length; i++) {
            for (Map.Entry<String,String> kv : arr[i].entrySet()) {
                dict.add(kv.getKey(),kv.getValue());
            }
        }
        for (int j =0; j<dict.getIndex().size(); j++) {
            if(null != dict.getIndex().get(j)){
                System.out.println(getOneDictByIndex(index.get(j)));
            }
        }
    }

    /**
     * 储存所有字典值
     * @param text
     * @param taget
     * @return
     */
    public Map[] load(String text,Dict taget) {
        String key = "";
        String value = "";
        StringBuffer sb = new StringBuffer();
        char[] ch = text.toCharArray();
        for (int i=0; i<ch.length; i++) {
            if(ch[i] == '\n')
            {
                value = sb.toString();
                sb.setLength(0);
            } else if(ch[i] == '=' || ch[i] == ';') {//过滤\n,;,=
                continue;
            } else {
                sb.append(ch[i]);
                if(i < ch.length-1 && ch[i+1] == '=') {
                    key = sb.toString();
                    sb.setLength(0);
                }
                if((i < ch.length-1 && ch[i+1] == ';') || i == ch.length-1) {
                    value = sb.toString();
                    sb.setLength(0);
                }
            }
            if (!"".equals(key) && !"".equals(value)) {
                taget.add(key,value);
                key = "";
                value = "";
            }
        }
        Map[] maps = new Map[taget.index.size()];
        for (int i=0; i<maps.length; i++) {
            Map<String,String> map = new HashMap<>();
            for (Element e : taget.dict.get(String.valueOf(taget.index.get(i)))) {
                map.put(e.getKey(),e.getValue());
            }
            maps[i] = map;
        }
        return maps;
    }

    /**
     * 判断字典中是否含有某个key
     * @param key
     * @return
     */
    public boolean contain(String key) {
        char[] ch = key.toCharArray();
        int ascValue = ch[0];
        if(!index.contains(ascValue)) {
            return false;
        } else {
           List<Element> list = dict.get(String.valueOf(ascValue));
           Iterator<Element> it = list.iterator();
           while (it.hasNext()) {
               Element e = it.next();
               if(e.getKey().equals(key)) {
                   return true;
               }
           }
           return false;
        }
    }

    /**
     * 删除某个字典值
     * @param key
     * @return
     */
    public boolean remove(String key) {
        if(!contain(key)) {
            return false;
        }
        char[] ch = key.toCharArray();
        int ascValue = ch[0];
        List<Element> list = dict.get(String.valueOf(ascValue));
        Iterator<Element> it = list.iterator();
        while (it.hasNext()) {
            Element e = it.next();
            if(e.getKey().equals(key)) {
                list.remove(e);
                return true;
            }
        }
        return false;
    }

    /**
     * 获取某个key对应的value
     * @param key
     * @return
     */
    public String get(String key) {
        if(!contain(key)) {
            return null;
        }
        char[] ch = key.toCharArray();
        int ascValue = ch[0];
        List<Element> list = dict.get(String.valueOf(ascValue));
        Iterator<Element> it = list.iterator();
        while (it.hasNext()) {
            Element e = it.next();
            if(e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        return null;
    }

}