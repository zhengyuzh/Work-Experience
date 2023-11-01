package com.zyz.yu.SRCSqLite.utils;

import com.alibaba.fastjson.JSONObject;
import com.zyz.yu.SRCSqLite.helper.JdbcUtils_HKCP;
import com.zyz.yu.SRCSqLite.helper.ResultSetExtractor;
import com.zyz.yu.SRCSqLite.model.ElectronicFlow;
import com.zyz.yu.SRCSqLite.model.JSCommandKey;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/10/27 14:41
 * @Description: 电子流水数据库处理
 */
public class ElectronicFlowUtils extends SqlBaseUtils {
    //创建日志对象 Logger
    static final Logger log = Logger.getLogger(ElectronicFlowUtils.class);

    /**
     * @param serialNumber
     * @param content
     * @return java.lang.String
     * @author ZYZ
     * @description 电子流水内容数据存入
     */
    public static String insert(String serialNumber, String content) {
        try {
            String sql = setInsertSql(serialNumber, content);
           // int ireuslt = transHelper.insertGoBackID(sql);
            int ireuslt = jdbcUtils_HKCP.insertGoBackIDHKCP(sql);//数据池方式
            if (ireuslt > 0) {
                return JSResult.packSuccess(JSCommandKey.s_SuccessCode);
            } else {
                return JSResult.packFail("电子流水数据存入操作失败");
            }

        } catch (Exception e) {
            log.error("electronic_flow insert error：", e);
            return JSResult.packFail("电子流水数据存入操作异常");
        }
    }

    /**
     * @param serialNumberJson
     * @return java.lang.String
     * @author ZYZ
     * @description 电子流水序列号更新数据
     */
    public static String updateBySerialNumber(JSONObject serialNumberJson) {
        try {
            if (!compareJsonGet(serialNumberJson, "serialNumber")) {
                return JSResult.packFail("电子流水序列号数据为空");
            }
           // int iresult = transHelper.executeUpdate(setUpdateSql(serialNumberJson));
            int iresult = jdbcUtils_HKCP.executeUpdateHKCP(setUpdateSql(serialNumberJson));//数据池方式
            return JSResult.packSuccess(iresult);
        } catch (Exception e) {
            log.error("serial_number update error：", e);
            return JSResult.packFail("电子流水号数据更新操作异常");
        }
    }


    /**
     * @author ZYZ
     * @description 根据电子流水序列号查询数据
     * @param serialNumber
     *         transHelper.executeQuery
     * @return java.lang.String
     */
    public static ElectronicFlow queryByserialNumber(String serialNumber) {
        try {
            ElectronicFlow electronicFlowResult = jdbcUtils_HKCP.executeQueryHKCP(
                    "select * from electronic_flow where serial_number='" + serialNumber + "';",
                    new ResultSetExtractor<ElectronicFlow>() {
                        @Override
                        public ElectronicFlow extractData(ResultSet rs) throws SQLException {
                            return setBatchData(rs);
                        }
                    });
            return electronicFlowResult;
        } catch (Exception e) {
            log.error("serial_number query by serialNumber error：", e);
            return null;
        }
    }

    /**
     * @author ZYZ
     * @description 查询要发送的电子流水
     * @param
     * @return java.lang.String
     */
    public static ElectronicFlow queryOneData() {
        try {
            ElectronicFlow electronicFlowResult = jdbcUtils_HKCP.executeQueryHKCP(
                    "select * from electronic_flow where upload_flag='" + 0 + "' order by create_time asc limit 1;",
                    new ResultSetExtractor<ElectronicFlow>() {
                        @Override
                        public ElectronicFlow extractData(ResultSet rs) throws SQLException {
                            return setBatchData(rs);
                        }
                    });
            return electronicFlowResult;
        } catch (Exception e) {
            log.error("queryOneData query  error：", e);
        }
        return null;
    }


    /**
     * @author ZYZ
     * @description 电子流水数据表赋值
     * @param rs
     * @return
     */
    private static ElectronicFlow setBatchData(ResultSet rs) throws SQLException {
        ElectronicFlow electronicFlow = new ElectronicFlow();
        if(rs.next()){
            electronicFlow.setId(rs.getInt("id"));
            electronicFlow.setSerialNumber(rs.getString("serial_number"));
            electronicFlow.setContent(rs.getString("content"));
            electronicFlow.setCreateTime(rs.getString("create_time"));
            electronicFlow.setUpdateTime(rs.getString("update_time"));
            electronicFlow.setUploadFlag(rs.getInt("upload_flag"));
            electronicFlow.setResCode(rs.getString("res_code"));
            electronicFlow.setDescription(rs.getString("description"));
        }
        return electronicFlow;
    }



    /**
     * @param serialNumber
     * @param content
     * @return java.lang.String
     * @author ZYZ
     * @description 生成统一 Insert 语句
     */
    private static String setInsertSql(String serialNumber, String content) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuffer insertSql = new StringBuffer();
        insertSql.append("insert into electronic_flow(serial_number,content,create_time,update_time,upload_flag," +
                "description,res_code) " +
                "values(" + (StringUtils.isEmpty(serialNumber) ? null : ("'" + serialNumber + "'")) +
                "," + (StringUtils.isEmpty(content) ? null : ("'" + content + "'")) + ",'" +
                simpleDateFormat.format(date) + "','',0,'',''" +
                ");");
        return insertSql.toString();
    }

    /**
     * @param electronicFlowJson
     * @return java.lang.String
     * @author ZYZ
     * @description 生成统一 update 语句
     */
    public static String setUpdateSql(JSONObject electronicFlowJson) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        StringBuffer updateSql = new StringBuffer();
        updateSql.append("UPDATE electronic_flow SET update_time='" + simpleDateFormat.format(date) + "'");

        if (compareJsonGet(electronicFlowJson, "uploadFlag")) {
            updateSql.append(String.format(",upload_flag='%s'", electronicFlowJson.get("uploadFlag")));
        }
        if (compareJsonGet(electronicFlowJson, "resCode")) {
            updateSql.append(String.format(",res_code='%s'", electronicFlowJson.get("resCode")));
        }
        if (compareJsonGet(electronicFlowJson, "description")) {
            updateSql.append(String.format(",description='%s'", electronicFlowJson.get("description")));
        }

        updateSql.append(" WHERE serial_number='" + electronicFlowJson.get("serialNumber") + "';");

        return updateSql.toString();
    }

    public static boolean compareJsonGet(JSONObject jsonObject, String keyName) {
        return jsonObject.get(keyName) == null ? false : (StringUtils.isEmpty(jsonObject.getString(keyName)) ? false : true);
    }


}
