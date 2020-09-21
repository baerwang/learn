package com.baerwang.template.jdbc;

import com.baerwang.template.dao.MemberDao;

import java.util.List;

/**
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
