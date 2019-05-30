package com.reflect;

import java.lang.reflect.Field;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/5/30 10:50
 * @description
 */
public class ReflectDemo {
    @Deprecated
    public static void main(String[] args) {
        Person p = new Person("aaa",111);
//        Class cls = p.getClass();
//        Method[] methods = cls.getMethods();
//        Field[] fileds = cls.getDeclaredFields();
//        for (int i = 0; i<fileds.length; i++) {
//            String fieldName = fileds[i].getName();
//            String methodName = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
//            try {
//                Method get = cls.getMethod(methodName,new Class[]{});
//                Object value = get.invoke(p,new Object[]{});
//                System.out.println(value);
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }

//        Class cls = Person.class;
//        try {
//            Person p = (Person) cls.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

        Class cls = p.getClass();
        for (Field f : cls.getDeclaredFields()) {
            if(!f.isAccessible()) {
                f.setAccessible(true);
            }
            Label label = f.getAnnotation(Label.class);
            String name = label != null ? label.value() : f.getName();
            System.out.printf(name);
        }

    }
}