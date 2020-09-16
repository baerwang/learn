package com.baerwang.prototype.deep;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author baerwang
 * @since 2020/8/29 8:57
 */
public class PrototypeDeepTest {

    public static void main(String[] args) {
        QiTianDaSheng deep = new QiTianDaSheng();
        QiTianDaSheng clone = (QiTianDaSheng) deep.clone();
        System.out.println("深克隆：" + (deep.jinGuBang == clone.jinGuBang));


        QiTianDaSheng shallow = new QiTianDaSheng();
        QiTianDaSheng qiTianDaSheng = shallow.shallowClone(shallow);
        System.out.println("浅克隆：" + (shallow.jinGuBang == qiTianDaSheng.jinGuBang));

    }

    public void test() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(12);
        while (byteArrayOutputStream.size() != 5) {
            byteArrayOutputStream.write(System.in.read());
        }

        byte[] bytes = byteArrayOutputStream.toByteArray();

        for (byte aByte : bytes) {
            System.out.print((char) aByte);
        }
        System.out.println();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        int c;
        for (int i = 0; i < 1; i++) {
            while ((c = byteArrayInputStream.read()) != -1) {
                System.out.print(Character.toUpperCase((char) c));
            }
            byteArrayInputStream.reset();
        }
    }
}
