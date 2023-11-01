package com.zyz.yu.SRCSqLite.helper;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.log4j.Logger;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author zyz
 * @version 1.0
 * @data 2023/10/30 16:29
 * @Description: 采用数据库连接池
 */
public class JdbcUtils_HKCP {
    public final static String DB_TRANSPATH ="D:\\GrgBanking\\iTerminal\\" + "Data" + File.separator + "trans.db";
    private static String Drivde = "org.sqlite.JDBC";
    private static Statement statement;
    private static Connection connection;
    private static ResultSet resultSet;
    /**
     * 4.提升作用域
     */
    private static HikariDataSource dataSource;
    private static HikariConfig config;

    //创建日志对象 Logger
    static final Logger log = Logger.getLogger(JdbcUtils_HKCP.class);


    /**
     * 1.获取数据源 dataSource
     */
    static {
        try {
            
            log.info("开始创建数据库连接池");
            config = new HikariConfig();
            String dbFilePath = "jdbc:sqlite:" + DB_TRANSPATH;
            config.setJdbcUrl(dbFilePath);
            config.setDriverClassName(Drivde);
            dataSource = new HikariDataSource(config);
        } catch (Exception e) {
            log.error("创建数据库连接池失败：", e);
        }
        log.info("创建数据库连接池结束");
    }

    /**
     * 2.获取连接 (数据源dataSource自带连接)
     *
     * @return
     * @throws SQLException
     * @throws SQLException
     */
    public void connect() {
        log.info("SqlLite connection start");
        try {
            if (null == connection) {
                connection = dataSource.getConnection();
                statement = connection.createStatement();
            }
        } catch (SQLException e) {
            log.error("SqlLite connection error：", e);
        }
        log.info("SqlLite connection end");

    }


    /**
     * @param sql sql语句
     * @return int
     * @author ZYZ
     * @description 插入数据库操作并返回数据ID
     */
    public int insertGoBackIDHKCP(String sql) throws SQLException {
        try {
            connect();
            log.info("insertGoBackID SQL:" + sql);
            statement.executeUpdate(sql);
            resultSet = statement.getGeneratedKeys();
            int iresult = resultSet.getInt(1);
            return iresult;
        } finally {
            release();
        }
    }

    /**
     * @param sql sql语句
     * @return int
     * @author ZYZ
     * @description 执行数据库更新sql语句
     */
    public int executeUpdateHKCP(String sql) throws SQLException {
        try {
            connect();
            log.info("executeUpdate SQL:"+sql);
            int iResult = statement.executeUpdate(sql);
            return iResult;
        } finally {
            release();
        }
    }


    /**
     * @param sql select 语句
     * @param rse 结果集处理类对象
     * @return T 查询结果
     * @author ZYZ
     * @description 执行sql查询
     */
    public <T> T executeQueryHKCP(String sql, ResultSetExtractor<T> rse) throws SQLException {
        try {
            connect();
            log.info("executeQueryHKCP SQL:" + sql);
            resultSet = statement.executeQuery(sql);
            T rs = rse.extractData(resultSet);
            return rs;
        } finally {
            release();
        }
    }


    /**
     * @param
     * @return
     * @author ZYZ
     * @description 3.释放数据库资源
     */
    public static void release() {
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

