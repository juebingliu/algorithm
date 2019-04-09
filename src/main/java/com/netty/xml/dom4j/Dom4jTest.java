package com.netty.xml.dom4j;

import com.util.JaxbUtil;
import com.util.XmlUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author juebing
 * @date 2018/11/22 18:13
 * @description
 */
public class Dom4jTest {

    public static void main(String[] args) throws Exception{
        Dom4jTest t = new Dom4jTest();
        t.saveXmlTest();
        //t.getUserTest();
    }

    public void saveXmlTest() throws Exception{
        User user = new User("陈本布衣", 2018, "超级管理员","瞎哔哔");
        List<Menu> list1 = new ArrayList<Menu>();
        Menu menu1 = new Menu("系统管理","9527");
        Menu child1 = new Menu("权限管理","9999");
        Menu child2 = new Menu("用户管理","2322");
        list1.add(child1);
        list1.add(child2);
        menu1.setChild(list1);
        List<Menu> list2 = new ArrayList<Menu>();
        Menu menu2 = new Menu("参数配置","2222");
        Menu child3 = new Menu("权限管理","3333");
        Menu child4 = new Menu("用户管理","4444");
        list2.add(child3);
        list2.add(child4);
        menu2.setChild(list2);
        List<Menu> menus = new ArrayList<Menu>();
        menus.add(menu1);
        menus.add(menu2);
        user.setMenus(menus);
//        File file = new File("D://user.xml");
//        JaxbUtil.convertToXml(user,file);
        System.out.println(XmlUtil.marshal(user,"UTF-8"));
    }

    public void getUserTest() {
        File file = new File("D://user.xml");
        User user = JaxbUtil.convertToJavaBean(User.class, file);
        System.out.println(user);
    }
}