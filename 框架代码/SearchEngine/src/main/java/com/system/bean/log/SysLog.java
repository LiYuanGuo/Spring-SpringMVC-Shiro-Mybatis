package com.system.bean.log;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiParam;

@Table(name = "SYS_LOG")
public class SysLog {
	@ApiParam(value = "主键", name = "fId")
    @Id
    @Column(name = "F_ID")
    private String fId;

	@ApiParam(value = "用户id", name = "fUserid")
    @Column(name = "F_USERID")
    private String fUserid;

	@ApiParam(value = "姓名", name = "fRealname")
    @Column(name = "F_REALNAME")
    private String fRealname;

	@ApiParam(value = "类型", name = "fType")
    @Column(name = "F_TYPE")
    private String fType;

	@ApiParam(value = "IP地址", name = "fIpaddress")
    @Column(name = "F_IPADDRESS")
    private String fIpaddress;

	@ApiParam(value = "IP所在城市", name = "fIpaddressname")
    @Column(name = "F_IPADDRESSNAME")
    private String fIpaddressname;

	@ApiParam(value = "系统模块Id", name = "fModuleid")
    @Column(name = "F_MODULEID")
    private String fModuleid;

	@ApiParam(value = "系统模块", name = "fModulename")
    @Column(name = "F_MODULENAME")
    private String fModulename;

	@ApiParam(value = "1成功0失败", name = "fResult")
    @Column(name = "F_RESULT")
    private Integer fResult;

	@ApiParam(value = "操作日志内容", name = "fDescription")
    @Column(name = "F_DESCRIPTION")
    private String fDescription;

	@ApiParam(value = "创建时间", name = "fCreatortime")
    @Column(name = "F_CREATORTIME")
    private Date fCreatortime;

	@ApiParam(value = "创建人", name = "fCreatoruserid")
    @Column(name = "F_CREATORUSERID")
    private String fCreatoruserid;

	@ApiParam(value = "日志关键信息描述", name = "fKey")
    @Column(name = "F_KEY")
    private String fKey;

    /**
     * @return F_Id
     */
    public String getfId() {
        return fId;
    }

    /**
     * @param fId
     */
    public void setfId(String fId) {
        this.fId = fId;
    }

    /**
     * @return F_USERID
     */
    public String getfUserid() {
        return fUserid;
    }

    /**
     * @param fUserid
     */
    public void setfUserid(String fUserid) {
        this.fUserid = fUserid;
    }

    /**
     * @return F_REALNAME
     */
    public String getfRealname() {
        return fRealname;
    }

    /**
     * @param fRealname
     */
    public void setfRealname(String fRealname) {
        this.fRealname = fRealname;
    }

    /**
     * @return F_TYPE
     */
    public String getfType() {
        return fType;
    }

    /**
     * @param fType
     */
    public void setfType(String fType) {
        this.fType = fType;
    }

    /**
     * @return F_IPADDRESS
     */
    public String getfIpaddress() {
        return fIpaddress;
    }

    /**
     * @param fIpaddress
     */
    public void setfIpaddress(String fIpaddress) {
        this.fIpaddress = fIpaddress;
    }

    /**
     * @return F_IPADDRESSNAME
     */
    public String getfIpaddressname() {
        return fIpaddressname;
    }

    /**
     * @param fIpaddressname
     */
    public void setfIpaddressname(String fIpaddressname) {
        this.fIpaddressname = fIpaddressname;
    }

    /**
     * @return F_MODULEID
     */
    public String getfModuleid() {
        return fModuleid;
    }

    /**
     * @param fModuleid
     */
    public void setfModuleid(String fModuleid) {
        this.fModuleid = fModuleid;
    }

    /**
     * @return F_MODULENAME
     */
    public String getfModulename() {
        return fModulename;
    }

    /**
     * @param fModulename
     */
    public void setfModulename(String fModulename) {
        this.fModulename = fModulename;
    }

    /**
     * @return F_RESULT
     */
    public Integer getfResult() {
        return fResult;
    }

    /**
     * @param fResult
     */
    public void setfResult(Integer fResult) {
        this.fResult = fResult;
    }

    /**
     * @return F_DESCRIPTION
     */
    public String getfDescription() {
        return fDescription;
    }

    /**
     * @param fDescription
     */
    public void setfDescription(String fDescription) {
        this.fDescription = fDescription;
    }

    /**
     * @return F_CREATORTIME
     */
    public Date getfCreatortime() {
        return fCreatortime;
    }

    /**
     * @param fCreatortime
     */
    public void setfCreatortime(Date fCreatortime) {
        this.fCreatortime = fCreatortime;
    }

    /**
     * @return F_CREATORUSERID
     */
    public String getfCreatoruserid() {
        return fCreatoruserid;
    }

    /**
     * @param fCreatoruserid
     */
    public void setfCreatoruserid(String fCreatoruserid) {
        this.fCreatoruserid = fCreatoruserid;
    }
    /**
     * @param fKey
     */
    public void setfKey(String fKey) {
        this.fKey = fKey;
    }
    /**
     * @param fKey
     */
    public String getfKey() {
    	 return fKey;
    }

	@Override
	public String toString() {
		return "SysLog [fId=" + fId + ", fUserid=" + fUserid + ", fRealname=" + fRealname + ", fType=" + fType
				+ ", fIpaddress=" + fIpaddress + ", fIpaddressname=" + fIpaddressname + ", fModuleid=" + fModuleid
				+ ", fModulename=" + fModulename + ", fResult=" + fResult + ", fDescription=" + fDescription
				+ ", fCreatortime=" + fCreatortime + ", fCreatoruserid=" + fCreatoruserid + ", fKey=" + fKey + "]";
	}


    
    
    
}