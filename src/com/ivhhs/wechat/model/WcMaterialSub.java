package com.ivhhs.wechat.model;


import java.util.Date;

/**
 * WcMaterialSub entity. @author MyEclipse Persistence Tools
 */

public class WcMaterialSub implements java.io.Serializable {

	// Fields

	private Integer wcmsid;
	private Integer wcmsType;
	private String wcmsTitle;
	private String wcmsDesc;
	private String wcmsPicurl;
	private String wcmsUrl;
	private Integer wcmsOrder;
	private Date creattime;
	private Integer createid;
	private Integer enabled;

	// Constructors

	/** default constructor */
	public WcMaterialSub() {
	}

	/** minimal constructor */
	public WcMaterialSub(Integer wcmsid, Date creattime,
			Integer createid, Integer enabled) {
		this.wcmsid = wcmsid;
		this.creattime = creattime;
		this.createid = createid;
		this.enabled = enabled;
	}

	/** full constructor */
	public WcMaterialSub(Integer wcmsid, Integer wcmsType,
			String wcmsTitle, String wcmsDesc, String wcmsPicurl,
			String wcmsUrl, Integer wcmsOrder, Date creattime,
			Integer createid, Integer enabled) {
		this.wcmsid = wcmsid;
		this.wcmsType = wcmsType;
		this.wcmsTitle = wcmsTitle;
		this.wcmsDesc = wcmsDesc;
		this.wcmsPicurl = wcmsPicurl;
		this.wcmsUrl = wcmsUrl;
		this.wcmsOrder = wcmsOrder;
		this.creattime = creattime;
		this.createid = createid;
		this.enabled = enabled;
	}

	// Property accessors

	public Integer getWcmsid() {
		return this.wcmsid;
	}

	public void setWcmsid(Integer wcmsid) {
		this.wcmsid = wcmsid;
	}

	public Integer getWcmsType() {
		return this.wcmsType;
	}

	public void setWcmsType(Integer wcmsType) {
		this.wcmsType = wcmsType;
	}

	public String getWcmsTitle() {
		return this.wcmsTitle;
	}

	public void setWcmsTitle(String wcmsTitle) {
		this.wcmsTitle = wcmsTitle;
	}

	public String getWcmsDesc() {
		return this.wcmsDesc;
	}

	public void setWcmsDesc(String wcmsDesc) {
		this.wcmsDesc = wcmsDesc;
	}

	public String getWcmsPicurl() {
		return this.wcmsPicurl;
	}

	public void setWcmsPicurl(String wcmsPicurl) {
		this.wcmsPicurl = wcmsPicurl;
	}

	public String getWcmsUrl() {
		return this.wcmsUrl;
	}

	public void setWcmsUrl(String wcmsUrl) {
		this.wcmsUrl = wcmsUrl;
	}

	public Integer getWcmsOrder() {
		return this.wcmsOrder;
	}

	public void setWcmsOrder(Integer wcmsOrder) {
		this.wcmsOrder = wcmsOrder;
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