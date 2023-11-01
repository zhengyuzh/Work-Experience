package com.zyz.yu.SRCSqLite.utils;



import com.zyz.yu.SRCSqLite.helper.JdbcUtils_HKCP;
import com.zyz.yu.SRCSqLite.helper.SqliteHelper;

import java.io.File;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/10/27 14:37
 * @Description:
 */
public class SqlBaseUtils {

    public final static String DB_TRANSPATH = "D:\\GrgBanking\\iTerminal\\" + "Data" + File.separator + "trans.db";
    public static SqliteHelper transHelper = new SqliteHelper(DB_TRANSPATH);
    public static JdbcUtils_HKCP jdbcUtils_HKCP = new JdbcUtils_HKCP();//采用数据池操作
}
