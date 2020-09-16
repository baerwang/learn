package com.baerwang.singleton.register;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 枚举式单例模式
 *
 * @author baerwang
 * @since 2020/8/31 16:54
 */
public class EnumSingletonTest {

    public static void main(String[] args) {
        try {

            EnumSingleton enumSingleton = null;

            EnumSingleton instance = EnumSingleton.getInstance();
            instance.setData(new Object());
            String str = "EnumSingleton.obj";
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(instance);

            objectOutputStream.flush();
            objectOutputStream.close();

            FileInputStream fileInputStream = new FileInputStream(str);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            enumSingleton = (EnumSingleton) objectInputStream.readObject();

            objectInputStream.close();
            System.out.println(enumSingleton.getData());
            System.out.println(instance.getData());

            System.out.println(enumSingleton.getData() == instance.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
