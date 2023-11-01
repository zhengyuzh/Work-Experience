package com.zyz.yu.SRCSqLite.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/10/30 9:22
 * @Description: 查询数据处理
 */
public interface ResultSetExtractor<T> {
    /**
     * 返回结果处理
     * @param rs
     * @return
     * @throws SQLException
     */
    T extractData(ResultSet rs) throws SQLException;
}
