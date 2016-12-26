package com.ivhhs.wechat.model;


import java.util.Date;

/**
 * WcWhzjstaff entity. @author MyEclipse Persistence Tools
 */

public class WcWhzjstaff implements java.io.Serializable {

	// Fields

	private Integer wwid;
	private Integer wcpid;
	private String SName;
	private String SNum;
	private String SWechat;
	private String SPhone;
	private String SClass;
	private Integer VId;
	private String openid;
	private Date creattime;
	private Integer createid;
	private Integer enabled;

	// Constructors

	/** default constructor */
	public WcWhzjstaff() {
	}

	/** minimal constructor */
	public WcWhzjstaff(Integer wwid, Integer wcpid, Date creattime,
			Integer createid, Integer enabled) {
		this.wwid = wwid;
		this.wcpid = wcpid;
		this.creattime = creattime;
		this.createid = createid;
		this.enabled = enabled;
	}

	/** full constructor */
	public WcWhzjstaff(Integer wwid, Integer wcpid, String SName,
			String SNum, String SWechat, String SPhone, String SClass,
			Integer VId, String openid, Date creattime, Integer createid,
			Integer enabled) {
		this.wwid = wwid;
		this.wcpid = wcpid;
		this.SName = SName;
		this.SNum = SNum;
		this.SWechat = SWechat;
		this.SPhone = SPhone;
		this.SClass = SClass;
		this.VId = VId;
		this.openid = openid;
		this.creattime = creattime;
		this.createid = createid;
		this.enabled = enabled;
	}

	// Property accessors

	public Integer getWwid() {
		return this.wwid;
	}

	public void setWwid(Integer wwid) {
		this.wwid = wwid;
	}

	public Integer getWcpid() {
		return this.wcpid;
	}

	public void setWcpid(Integer wcpid) {
		this.wcpid = wcpid;
	}

	public String getSName() {
		return this.SName;
	}

	public void setSName(String SName) {
		this.SName = SName;
	}

	public String getSNum() {
		return this.SNum;
	}

	public void setSNum(String SNum) {
		this.SNum = SNum;
	}

	public String getSWechat() {
		return this.SWechat;
	}

	public void setSWechat(String SWechat) {
		this.SWechat = SWechat;
	}

	public String getSPhone() {
		return this.SPhone;
	}

	public void setSPhone(String SPhone) {
		this.SPhone = SPhone;
	}

	public String getSClass() {
		return this.SClass;
	}

	public void setSClass(String SClass) {
		this.SClass = SClass;
	}

	public Integer getVId() {
		return this.VId;
	}

	public void setVId(Integer VId) {
		this.VId = VId;
	}

	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Date getCreattime() {
		return this.creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public Integer getCreateid() {
		return this.createid;
	}

	public void setCreateid(Integer createid) {
		this.createid = createid;
	}

	public Integer getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

}