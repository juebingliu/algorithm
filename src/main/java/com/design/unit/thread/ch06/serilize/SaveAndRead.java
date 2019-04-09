package com.design.unit.thread.ch06.serilize;

import java.io.*;

/**
 * Created by juebingliu on 2018/7/3.
 */
public class SaveAndRead {
    public static void main(String[] args) {
        try {
            MyObject myObject = MyObject.getInstatnce();
            FileOutputStream out = new FileOutputStream(new File("MyObjectFile.txt"));
            ObjectOutputStream os = new ObjectOutputStream(out);
            os.writeObject(myObject);
            os.close();
            out.close();
            System.out.println(myObject.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream in = new FileInputStream(new File("MyObjectFile.txt"));
            ObjectInputStream is = new ObjectInputStream(in);
            MyObject myObject = (MyObject) is.readObject();
            is.close();
            in.close();
            System.out.println(myObject.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
