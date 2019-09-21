package com.wt.myspringcloud.user.jdbc;

import com.wt.myspringcloud.common.pojo.entity.User;
import com.wt.myspringcloud.user.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;

/**
 * @author 文通
 * @since 2019/9/5
 */
public class JdbcTest extends BaseTest {

    /**
     * 自动注入数据源
     */
    @Resource
    private DataSource dataSource;

    /**
     * 使用 Statement 执行 SQL
     */
    @Test
    public void testStatement() throws SQLException {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            printResultSet(statement.executeQuery("select * from user"));
        }
    }

    /**
     * 使用 PreparedStatement 执行 SQL
     */
    @Test
    public void testPreparedStatement() throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("select * from user where id = ?")) {
            statement.setInt(1, 4);
            printResultSet(statement.executeQuery());
        }
    }

    @Test
    public void testTransaction() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("update user set name = '已修改' where id = 4");
            }
            connection.commit();
        }
    }

    @Before
    public void printBeforeTest() throws SQLException {
        System.out.println("printBeforeTest:");
        printAllUser();
    }

    @After
    public void printAfterTest() throws SQLException {
        System.out.println("printAfterTest:");
        printAllUser();
    }

    /**
     * 打印所有用户
     */
    private void printAllUser() throws SQLException {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            printResultSet(statement.executeQuery("select * from user"));
        }
    }

    /**
     * 打印结果集
     *
     * @param resultSet 结果集
     */
    private void printResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " - " + resultSet.getString(2));
        }
    }
}
