package com.baerwang.template.jdbc;

import com.baerwang.template.dao.MemberDao;

import java.util.List;

/**
 * 模板模式优缺点
 * <p>
 * 优点：
 * （1）利用模板模式将相同处理逻辑的代码放到抽象父类中，可以提高代码的复用性。
 * （2）将不同的代码放到不同的子类中，通过对子类的扩展增加新的行为，可以提高代码的扩展性。
 * （3）把不变的行为写在父类中，去除子类的重复代码，提供了一个很好的代码复用平台，符合开闭原则。
 * </p>
 * <p>
 * 缺点：
 * （1）每个抽象类都需要一个子类来实现，导致了类的数量增加。
 * （2）类数量的增加间接地增加了系统的复杂性。
 * （3）因为继承关系自身的缺点，如果父类添加新的抽象方法，所有子类都要改一遍。
 * </p>
 *
 * @author baerwang
 * @since 2020/9/21 16:04
 */
public class MemberDaoTest {

    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao(null);
        List<?> result = memberDao.selectAll();
        System.out.println(result);
    }
}
