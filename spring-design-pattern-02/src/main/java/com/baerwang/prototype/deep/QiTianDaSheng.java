package com.baerwang.prototype.deep;

import java.io.*;
import java.time.LocalDateTime;

/**
 * @author baerwang
 * @since 2020/8/29 8:53
 */
public class QiTianDaSheng extends Monkey implements Cloneable, Serializable {

    public JinGuBang jinGuBang;

    public QiTianDaSheng() {
        this.birthday = LocalDateTime.now();
        this.jinGuBang = new JinGuBang();
    }

    @Override
    protected Object clone() {
        return this.deepClone();
    }

    /**
     * 深克隆
     *
     * @return
     */
    public Object deepClone() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            QiTianDaSheng qiTianDaSheng = (QiTianDaSheng) objectInputStream.readObject();
            qiTianDaSheng.birthday = LocalDateTime.now();
            return qiTianDaSheng;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public QiTianDaSheng shallowClone(QiTianDaSheng target) {
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        qiTianDaSheng.weight = target.weight;
        qiTianDaSheng.height = target.height;
        qiTianDaSheng.jinGuBang = target.jinGuBang;
        qiTianDaSheng.birthday = LocalDateTime.now();
        return qiTianDaSheng;
    }
}
