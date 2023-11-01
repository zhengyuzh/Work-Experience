package com.zyz.yu.SRCSqLite.model;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/10/27 9:23
 * @Description:  电子流水实体类
 */
public class ElectronicFlow {
    private Integer id;
    private String serialNumber; //流水序列号
    private String content;      //上传内容
    private String createTime;   //创建时间
    private String updateTime;   //更新时间
    private Integer uploadFlag;  //电子流水上传标志 0-未上传 1-已上传
    private String description;  //响应结果描述
    private String resCode;      //响应码、上传失败响应码

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUploadFlag() {
        return uploadFlag;
    }

    public void setUploadFlag(Integer uploadFlag) {
        this.uploadFlag = uploadFlag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }
}
