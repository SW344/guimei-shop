package com.dao;

import com.util.C3P0Util;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    // 使用DbUtils
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update方法: 用来执行insert、update、delete语句
     *
     * @param sql    sql语句
     * @param params 参数
     * @return 如果返回的是-1 执行失败，其他返回表示影响行数
     */
    public int update(String sql, Object... params) {
        Connection conn = null;
        try {
            // 先创建数据库连接
            conn = C3P0Util.getConn();
            return queryRunner.update(conn, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }


    /**
     * 查询返回一个javaBean的sql语句方法
     *
     * @param type   返回对象的类型
     * @param sql    sql语句
     * @param params 参数
     * @param <T>    指定类型
     * @return 返回的javaBean
     */
    public <T> T queryByOne(Class<T> type, String sql, Object... params) {
        Connection conn = null;
        try {
            // 先创建数据库连接
            conn = C3P0Util.getConn();
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    /**
     * 查询返回多个list的javabean
     *
     * @param type   返回对象的类型
     * @param sql    sql语句
     * @param params 参数
     * @param <T>    指定类型
     * @return 返回一个集合，多个javaBean
     */
    public <T> List<T> queryByList(Class<T> type, String sql, Object... params) {
        Connection conn = null;
        try {
            // 先创建数据库连接
            conn = C3P0Util.getConn();
            return queryRunner.query(conn, sql, new BeanListHandler<>(type), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    /**
     * 查询返回函数的语句方法
     *
     * @param sql    sql语句
     * @param params 参数
     * @return 返回函数的语句
     */
    public Object queryBySingLeValue(String sql, Object... params) {
        Connection conn = null;
        try {
            // 先创建数据库连接
            conn = C3P0Util.getConn();
            return queryRunner.query(conn, sql, new ScalarHandler<>(), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    private class QueryRunner {
        public int update(Connection conn, String sql, Object[] params) {
        }
    }
}
