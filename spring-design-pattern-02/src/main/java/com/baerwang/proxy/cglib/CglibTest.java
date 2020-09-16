package com.baerwang.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * CGLIB 代理的目标对象不需要实现任何接口，它是通过动态继承目标对象实现动态代理的
 * CGLIB 代理执行代理方法的效率之所以比JDK高，是因为CGLIB采用了FastClass机制，
 * 它的原理就是说：为代理类和被代理类各生成一个类，这个类会为代理类或被代理类的方法分配一个index(int类型)；
 * 这个index当作一个入参，FastClass就可以直接定位要调用的方法并直接进行调用，省去了反射的调用，所以调用效率比JDK代理通过反射调用高。
 * ----------------------------------------------------
 * CGLIB和JDK动态代理对比
 * 1.JDK动态代理实现了被代理对象的接口，CGLIB代理继承了被代理对象。
 * 2.JDK动态代理和CGLIB代理都在运行期生成字节码，JDK动态代理直接写Class字节码。CGLIB代理使用ASM框架写Class字节码。CGLIB代理实现
 * 更复杂，生成代理类比JDK动态代理效率低。
 * 3.JDK动态代理调用代理方法是通过反射机制调用的，CGLIB代理是通过FastClass机制直接调用方法的，CGLIB代理的执行效率更高。
 * @author baerwang
 * @since 2020/9/3 17:49
 */
public class CglibTest {

    public static void main(String[] args) {

        try {
            // 代理类会获得父类所有的方法，并且会有MethodProxy与之对应
            // 该代码是cglib代理后的.class文件写入指定的磁盘里
            System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"G:/cglib_proxy_class/");
            CglibCustomer customer = (CglibCustomer) new CglibMeiPo().getInstance(CglibCustomer.class);
            customer.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
