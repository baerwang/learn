package com.baerwang.template;

import java.sql.ResultSet;

/**
 * @author baerwang
 * @since 2020/9/21 15:25
 */
public interface RowMapper<T> {

    T mapRow(ResultSet rs, int rowNum) throws Exception;
}
