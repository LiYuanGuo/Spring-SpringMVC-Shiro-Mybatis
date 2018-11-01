package com.system.bean.sys;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "SYS_USER")
public class SysUser {
    @Id
    @Column(name = "F_ID")
    private String fId;

    @Column(name = "F_ACCOUNT")
    private String fAccount;

    @Column(name = "F_REALNAME")
    private String fRealname;

    @Column(name = "F_NICKNAME")
    private String fNickname;

    @Column(name = "F_HEADICON")
    private String fHeadicon;

    @Column(name = "F_GENDER")
    private BigDecimal fGender;

    @Column(name = "F_BIRTHDAY")
    private Date fBirthday;

    @Column(name = "F_MOBILEPHONE")
    private String fMobilephone;

    @Column(name = "F_EMAIL")
    private String fEmail;

    @Column(name = "F_WECHAT")
    private String fWechat;

    @Column(name = "F_MANAGERID")
    private String fManagerid;

    @Column(name = "F_SECURITYLEVEL")
    private BigDecimal fSecuritylevel;

    @Column(name = "F_SIGNATURE")
    private String fSignature;

    @Column(name = "F_ORGANIZEID")
    private String fOrganizeid;

    @Column(name = "F_DEPARTMENTID")
    private String fDepartmentid;

   

    @Column(name = "F_DUTYID")
    private String fDutyid;

    @Column(name = "F_JOBNUMBER")
    private String fJobnumber;

    @Column(name = "F_ISADMINISTRATOR")
    private BigDecimal fIsadministrator;

    @Column(name = "F_SORTCODE")
    private BigDecimal fSortcode;

    @Column(name = "F_DELETEMARK")
    private BigDecimal fDeletemark;

    @Column(name = "F_ENABLEDMARK")
    private BigDecimal fEnabledmark;

    @Column(name = "F_DESCRIPTION")
    private String fDescription;

    @Column(name = "F_CREATORTIME")
    private Date fCreatortime;

    @Column(name = "F_CREATORUSERID")
    private String fCreatoruserid;

    @Column(name = "F_LASTMODIFYTIME")
    private Date fLastmodifytime;

    @Column(name = "F_LASTMODIFYUSERID")
    private String fLastmodifyuserid;

    @Column(name = "F_DELETETIME")
    private Date fDeletetime;

    @Column(name = "F_DELETEUSERID")
    private String fDeleteuserid;

    @Column(name = "F_PASSWORD")
    private String fPassword;
    
    private List<SysRole> roles;
    private List<SysPermission> permissions;

    public List<SysRole> getRoles() {
		return roles;
	}

	public List<SysPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}

	/**
     * @return F_ID
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
     * @return F_ACCOUNT
     */
    public String getfAccount() {
        return fAccount;
    }

    /**
     * @param fAccount
     */
    public void setfAccount(String fAccount) {
        this.fAccount = fAccount;
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
     * @return F_NICKNAME
     */
    public String getfNickname() {
        return fNickname;
    }

    /**
     * @param fNickname
     */
    public void setfNickname(String fNickname) {
        this.fNickname = fNickname;
    }

    /**
     * @return F_HEADICON
     */
    public String getfHeadicon() {
        return fHeadicon;
    }

    /**
     * @param fHeadicon
     */
    public void setfHeadicon(String fHeadicon) {
        this.fHeadicon = fHeadicon;
    }

    /**
     * @return F_GENDER
     */
    public BigDecimal getfGender() {
        return fGender;
    }

    /**
     * @param fGender
     */
    public void setfGender(BigDecimal fGender) {
        this.fGender = fGender;
    }

    /**
     * @return F_BIRTHDAY
     */
    public Date getfBirthday() {
        return fBirthday;
    }

    /**
     * @param fBirthday
     */
    public void setfBirthday(Date fBirthday) {
        this.fBirthday = fBirthday;
    }

    /**
     * @return F_MOBILEPHONE
     */
    public String getfMobilephone() {
        return fMobilephone;
    }

    /**
     * @param fMobilephone
     */
    public void setfMobilephone(String fMobilephone) {
        this.fMobilephone = fMobilephone;
    }

    /**
     * @return F_EMAIL
     */
    public String getfEmail() {
        return fEmail;
    }

    /**
     * @param fEmail
     */
    public void setfEmail(String fEmail) {
        this.fEmail = fEmail;
    }

    /**
     * @return F_WECHAT
     */
    public String getfWechat() {
        return fWechat;
    }

    /**
     * @param fWechat
     */
    public void setfWechat(String fWechat) {
        this.fWechat = fWechat;
    }

    /**
     * @return F_MANAGERID
     */
    public String getfManagerid() {
        return fManagerid;
    }

    /**
     * @param fManagerid
     */
    public void setfManagerid(String fManagerid) {
        this.fManagerid = fManagerid;
    }

    /**
     * @return F_SECURITYLEVEL
     */
    public BigDecimal getfSecuritylevel() {
        return fSecuritylevel;
    }

    /**
     * @param fSecuritylevel
     */
    public void setfSecuritylevel(BigDecimal fSecuritylevel) {
        this.fSecuritylevel = fSecuritylevel;
    }

    /**
     * @return F_SIGNATURE
     */
    public String getfSignature() {
        return fSignature;
    }

    /**
     * @param fSignature
     */
    public void setfSignature(String fSignature) {
        this.fSignature = fSignature;
    }

    /**
     * @return F_ORGANIZEID
     */
    public String getfOrganizeid() {
        return fOrganizeid;
    }

    /**
     * @param fOrganizeid
     */
    public void setfOrganizeid(String fOrganizeid) {
        this.fOrganizeid = fOrganizeid;
    }

    /**
     * @return F_DEPARTMENTID
     */
    public String getfDepartmentid() {
        return fDepartmentid;
    }

    /**
     * @param fDepartmentid
     */
    public void setfDepartmentid(String fDepartmentid) {
        this.fDepartmentid = fDepartmentid;
    }

   

    /**
     * @return F_DUTYID
     */
    public String getfDutyid() {
        return fDutyid;
    }

    /**
     * @param fDutyid
     */
    public void setfDutyid(String fDutyid) {
        this.fDutyid = fDutyid;
    }

    /**
     * @return F_JOBNUMBER
     */
    public String getfJobnumber() {
        return fJobnumber;
    }

    /**
     * @param fJobnumber
     */
    public void setfJobnumber(String fJobnumber) {
        this.fJobnumber = fJobnumber;
    }

    /**
     * @return F_ISADMINISTRATOR
     */
    public BigDecimal getfIsadministrator() {
        return fIsadministrator;
    }

    /**
     * @param fIsadministrator
     */
    public void setfIsadministrator(BigDecimal fIsadministrator) {
        this.fIsadministrator = fIsadministrator;
    }

    /**
     * @return F_SORTCODE
     */
    public BigDecimal getfSortcode() {
        return fSortcode;
    }

    /**
     * @param fSortcode
     */
    public void setfSortcode(BigDecimal fSortcode) {
        this.fSortcode = fSortcode;
    }

    /**
     * @return F_DELETEMARK
     */
    public BigDecimal getfDeletemark() {
        return fDeletemark;
    }

    /**
     * @param fDeletemark
     */
    public void setfDeletemark(BigDecimal fDeletemark) {
        this.fDeletemark = fDeletemark;
    }

    /**
     * @return F_ENABLEDMARK
     */
    public BigDecimal getfEnabledmark() {
        return fEnabledmark;
    }

    /**
     * @param fEnabledmark
     */
    public void setfEnabledmark(BigDecimal fEnabledmark) {
        this.fEnabledmark = fEnabledmark;
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
     * @return F_LASTMODIFYTIME
     */
    public Date getfLastmodifytime() {
        return fLastmodifytime;
    }

    /**
     * @param fLastmodifytime
     */
    public void setfLastmodifytime(Date fLastmodifytime) {
        this.fLastmodifytime = fLastmodifytime;
    }

    /**
     * @return F_LASTMODIFYUSERID
     */
    public String getfLastmodifyuserid() {
        return fLastmodifyuserid;
    }

    /**
     * @param fLastmodifyuserid
     */
    public void setfLastmodifyuserid(String fLastmodifyuserid) {
        this.fLastmodifyuserid = fLastmodifyuserid;
    }

    /**
     * @return F_DELETETIME
     */
    public Date getfDeletetime() {
        return fDeletetime;
    }

    /**
     * @param fDeletetime
     */
    public void setfDeletetime(Date fDeletetime) {
        this.fDeletetime = fDeletetime;
    }

    /**
     * @return F_DELETEUSERID
     */
    public String getfDeleteuserid() {
        return fDeleteuserid;
    }

    /**
     * @param fDeleteuserid
     */
    public void setfDeleteuserid(String fDeleteuserid) {
        this.fDeleteuserid = fDeleteuserid;
    }

    /**
     * @return F_PASSWORD
     */
    public String getfPassword() {
        return fPassword;
    }

    /**
     * @param fPassword
     */
    public void setfPassword(String fPassword) {
        this.fPassword = fPassword;
    }
}