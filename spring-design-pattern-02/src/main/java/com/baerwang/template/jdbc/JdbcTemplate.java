package com.baerwang.template.jdbc;

import com.baerwang.template.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author baerwang
 * @since 2020/9/21 15:26
 */
public abstract class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) {
        try {
            // 获取链接
            Connection connection = this.getConnection();
            // 创建语句集
            PreparedStatement prepareStatement = this.createPrepareStatement(connection, sql);
            // 执行语句集
            ResultSet resultSet = this.executeQuery(prepareStatement, values);
            // 处理结果集
            List<?> result = this.paresResultSet(resultSet, rowMapper);
            // 关闭结果集
            this.closeResultSet(resultSet);
            // 关闭语句集
            this.closeStatement(prepareStatement);
            // 关闭连接
            this.closeConnection(connection);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void closeConnection(Connection connection) throws Exception {
        connection.close();
    }

    protected void closeStatement(PreparedStatement preparedStatement) throws Exception {
        preparedStatement.close();
    }

    protected void closeResultSet(ResultSet resultSet) throws Exception {
        resultSet.close();
    }

    protected List<?> paresResultSet(ResultSet resultSet, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<>();
        int rowNum = 1;
        while (resultSet.next()) {
            result.add(rowMapper.mapRow(resultSet, rowNum++));
        }
        return result;
    }

    protected ResultSet executeQuery(PreparedStatement preparedStatement, Object[] values) throws Exception {
        for (int i = 0; i < values.length; i++) {
            preparedStatement.setObject(i, values[i]);
        }
        return preparedStatement.executeQuery();
    }

    protected PreparedStatement createPrepareStatement(Connection connection, String sql) throws Exception {
        return connection.prepareStatement(sql);
    }

    public Connection getConnection() throws Exception {
        return this.dataSource.getConnection();
    }

}

