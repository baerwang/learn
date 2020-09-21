package com.baerwang.template.dao;

import com.baerwang.template.RowMapper;
import com.baerwang.template.entity.Member;
import com.baerwang.template.jdbc.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author baerwang
 * @since 2020/9/21 15:43
 */
public class MemberDao extends JdbcTemplate {

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll() {
        String sql = "select * from member";
        return super.executeQuery(sql, (RowMapper<Member>) (rs, rowNum) -> {
            Member member = new Member();
            member.setUserName(rs.getString("username"));
            member.setPassword(rs.getString("password"));
            member.setNickName(rs.getString("nickname"));
            member.setAge(rs.getInt("password"));
            member.setAdd(rs.getString("addr"));
            return member;
        }, null);
    }
}
