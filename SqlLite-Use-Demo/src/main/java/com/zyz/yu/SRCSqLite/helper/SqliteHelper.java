package com.zyz.yu.SRCSqLite.helper;


import org.apache.log4j.Logger;

import java.sql.*;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/10/27 14:25
 * @Description:  sqlLite工具类，创建该类实例，并调用相应的接口即可对sqlLite数据库进行操作
 *                这里没有使用到数据池，每次操作都需要连接断开数据库、耗费资源
 */
public class SqliteHelper {
    private static String Drivde="org.sqlite.JDBC";
    private static Statement statement;
    private static Connection connection;
    private static ResultSet resultSet;
    private static String dbFilePath;

    static final Logger log = Logger.getLogger(SqliteHelper.class);

    static {
        try {
            //静态加载sql工具类
            Class.forName(Drivde);
        } catch (ClassNotFoundException e) {
            log.error("SqlLite Class loading error：",e);
        }
    }

    public SqliteHelper(String dbFilePath){
        this.dbFilePath = dbFilePath;
    }

    /**
     * @author ZYZ
     * @description 初始化sqlite链接
     */

    public void connect(){
       log.info("SqlLite connection start");
        try {
            if(null == connection){
                connection =  DriverManager.getConnection("jdbc:sqlite:"+dbFilePath); //连接数据库,不存在则创建
                statement = connection.createStatement();
            }
        } catch (SQLException e) {
            log.error("SqlLite connection error：",e);
        }
        log.info("SqlLite connection end");
    }


    /**
     * @author ZYZ
     * @description 插入数据库操作并返回数据ID
     * @param sql sql语句
     * @return int
     */
    public int insertGoBackID(String sql) throws SQLException {
        try {
            connect();
            log.info("insertGoBackID SQL:"+sql);
            statement.executeUpdate(sql);
            resultSet = statement.getGeneratedKeys();
            int iresult = resultSet.getInt(1);
            return iresult;
        }finally {
            destroyed();
        }
    }


    /**
     * @author ZYZ
     * @description 执行数据库更新sql语句
     * @param sql sql语句
     * @return int
     */
    public int executeUpdate(String sql) throws SQLException {
        try {
            connect();
            log.info("executeUpdate SQL:"+sql);
            int iResult = statement.executeUpdate(sql);
            return iResult;
        }finally {
            destroyed();
        }
    }

    /**
     * @author ZYZ
     * @description 执行sql查询
     * @param sql select 语句
     * @param rse 结果集处理类对象
     * @return T 查询结果
     */
    public <T> T executeQuery(String sql, ResultSetExtractor<T> rse) throws SQLException {
        try {
            connect();
            log.info("executeQuery SQL:"+sql);
            resultSet = statement.executeQuery(sql);
            T rs = rse.extractData(resultSet);
            return rs;
        }finally {
            destroyed();
        }
    }


    /**
     * @author ZYZ
     * @description 批量更新带事务的方法
     * @param sqls
     * @return boolean
     */
    public boolean executeTransaction(String...sqls) throws SQLException {
        try {
            connect();
            connection.setAutoCommit(false);
            for (String sql : sqls) {
                log.info("executeTransaction SQL:"+sql);
                statement.executeUpdate(sql);
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        }catch (Exception e){
            log.error("executeTransaction SQL error:",e);
            connection.rollback();
            return false;
        }finally {
            destroyed();
        }
    }




    /**
     * @author ZYZ
     * @description 释放数据库资源
     * @param
     * @return
     */
    public void destroyed() {
        log.info("SqlLite close start");
        try {
            if (null != resultSet) {
                resultSet.close();
                resultSet = null;
            }
            if (null != statement) {
                statement.close();
                statement = null;
            }
            if (null != connection) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            log.error("SqlLite close error", e);
        }
        log.info("SqlLite close end");
    }



}
