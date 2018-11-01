package com.system.bean.sys;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "SYS_PERMISSION")
public class SysPermission {
    @Id
    @Column(name = "F_ID")
    private String fId;

    @Column(name = "F_PARENTID")
    private String fParentid;

    @Column(name = "F_LAYERS")
    private BigDecimal fLayers;

    @Column(name = "F_ENCODE")
    private String fEncode;

    @Column(name = "F_FULLNAME")
    private String fFullname;

    @Column(name = "F_ICON")
    private String fIcon;

    @Column(name = "F_URLADDRESS")
    private String fUrladdress;

    @Column(name = "F_TARGET")
    private String fTarget;

    @Column(name = "F_ISMENU")
    private BigDecimal fIsmenu;

    @Column(name = "F_ISEXPAND")
    private BigDecimal fIsexpand;

    @Column(name = "F_ISPUBLIC")
    private BigDecimal fIspublic;

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
     * @return F_PARENTID
     */
    public String getfParentid() {
        return fParentid;
    }

    /**
     * @param fParentid
     */
    public void setfParentid(String fParentid) {
        this.fParentid = fParentid;
    }

    /**
     * @return F_LAYERS
     */
    public BigDecimal getfLayers() {
        return fLayers;
    }

    /**
     * @param fLayers
     */
    public void setfLayers(BigDecimal fLayers) {
        this.fLayers = fLayers;
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
     * @return F_ICON
     */
    public String getfIcon() {
        return fIcon;
    }

    /**
     * @param fIcon
     */
    public void setfIcon(String fIcon) {
        this.fIcon = fIcon;
    }

    /**
     * @return F_URLADDRESS
     */
    public String getfUrladdress() {
        return fUrladdress;
    }

    /**
     * @param fUrladdress
     */
    public void setfUrladdress(String fUrladdress) {
        this.fUrladdress = fUrladdress;
    }

    /**
     * @return F_TARGET
     */
    public String getfTarget() {
        return fTarget;
    }

    /**
     * @param fTarget
     */
    public void setfTarget(String fTarget) {
        this.fTarget = fTarget;
    }

    /**
     * @return F_ISMENU
     */
    public BigDecimal getfIsmenu() {
        return fIsmenu;
    }

    /**
     * @param fIsmenu
     */
    public void setfIsmenu(BigDecimal fIsmenu) {
        this.fIsmenu = fIsmenu;
    }

    /**
     * @return F_ISEXPAND
     */
    public BigDecimal getfIsexpand() {
        return fIsexpand;
    }

    /**
     * @param fIsexpand
     */
    public void setfIsexpand(BigDecimal fIsexpand) {
        this.fIsexpand = fIsexpand;
    }

    /**
     * @return F_ISPUBLIC
     */
    public BigDecimal getfIspublic() {
        return fIspublic;
    }

    /**
     * @param fIspublic
     */
    public void setfIspublic(BigDecimal fIspublic) {
        this.fIspublic = fIspublic;
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
}