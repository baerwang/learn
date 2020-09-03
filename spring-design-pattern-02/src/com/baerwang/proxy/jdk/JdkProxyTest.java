package com.baerwang.proxy.jdk;

import com.baerwang.proxy.dynamic.Customer;
import com.baerwang.proxy.dynamic.proxy.JDKMeiPo;
import com.baerwang.proxy.xx.Person;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JDK动态代理
 * <p>
 * JDK动态代理采用字节重组，重新生成对象来替代原始对象，以达到动态代理的目的。
 * </p>
 * JDK动态代理生成对象步骤：
 * <p>
 * 1.获取被代理对象的引用，并且获取它的所有接口，反射获取。
 * 2.JDK动态代理类重新生成一个新的类，同时新的类要实现被代理类实现的所有接口。
 * 3.动态生成Java代码，新加的业务逻辑方法由一定的逻辑代码被调用（在代码中体现）。
 * 4.编译新生成的Java代码.class文件
 * 5.重新加载到JVM中运行。
 * </p>
 *
 * @author baerwang
 * @since 2020/9/2 10:54
 */
public class JdkProxyTest {

    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;
        try {
            Person obj = (Person) new JDKMeiPo().getInstance(new Customer());
            obj.findLove();
            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
            fileOutputStream = new FileOutputStream("G://$Proxy0.class");
            fileOutputStream.write(bytes);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
