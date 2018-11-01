package com.system.bean.sys;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "SYS_ROLE")
public class SysRole {
    @Id
    @Column(name = "F_ID")
    private String fId;

    @Column(name = "F_ORGANIZEID")
    private String fOrganizeid;

    @Column(name = "F_CATEGORY")
    private BigDecimal fCategory;

    @Column(name = "F_ENCODE")
    private String fEncode;

    @Column(name = "F_FULLNAME")
    private String fFullname;

    @Column(name = "F_TYPE")
    private String fType;

    @Column(name = "F_RESPONSIBILITY")
    private String fResponsibility;

    @Column(name = "F_ALLOWEDIT")
    private BigDecimal fAllowedit;

    @Column(name = "F_ALLOWDELETE")
    private BigDecimal fAllowdelete;

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

    @Column(name = "F_TEMPLATEID")
    private String fTemplateid;

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
     * @return F_CATEGORY
     */
    public BigDecimal getfCategory() {
        return fCategory;
    }

    /**
     * @param fCategory
     */
    public void setfCategory(BigDecimal fCategory) {
        this.fCategory = fCategory;
    }

    /**
     * @return F_ENCODE
     */
    public String getfEncode() {
        return fEncode;
    }

    /**
     * @param fEncode
     */
    public void setfEncode(String fEncode) {
        this.fEncode = fEncode;
    }

    /**
     * @return F_FULLNAME
     */
    public String getfFullname() {
        return fFullname;
    }

    /**
     * @param fFullname
     */
    public void setfFullname(String fFullname) {
        this.fFullname = fFullname;
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
     * @return F_RESPONSIBILITY
     */
    public String getfResponsibility() {
        return fResponsibility;
    }

    /**
     * @param fResponsibility
     */
    public void setfResponsibility(String fResponsibility) {
        this.fResponsibility = fResponsibility;
    }

    /**
     * @return F_ALLOWEDIT
     */
    public BigDecimal getfAllowedit() {
        return fAllowedit;
    }

    /**
     * @param fAllowedit
     */
    public void setfAllowedit(BigDecimal fAllowedit) {
        this.fAllowedit = fAllowedit;
    }

    /**
     * @return F_ALLOWDELETE
     */
    public BigDecimal getfAllowdelete() {
        return fAllowdelete;
    }

    /**
     * @param fAllowdelete
     */
    public void setfAllowdelete(BigDecimal fAllowdelete) {
        this.fAllowdelete = fAllowdelete;
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
     * @return F_TEMPLATEID
     */
    public String getfTemplateid() {
        return fTemplateid;
    }

    /**
     * @param fTemplateid
     */
    public void setfTemplateid(String fTemplateid) {
        this.fTemplateid = fTemplateid;
    }
}