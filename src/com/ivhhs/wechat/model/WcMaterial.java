package com.ivhhs.wechat.model;


import java.util.Date;

/**
 * WcMaterial entity. @author MyEclipse Persistence Tools
 */

public class WcMaterial implements java.io.Serializable {

	// Fields

	private Integer wcmId;
	private Integer wcmType;
	private String wcmName;
	private String wcmDesc;
	private Date creattime;
	private Integer createid;
	private Integer enabled;

	// Constructors

	/** default constructor */
	public WcMaterial() {
	}

	/** minimal constructor */
	public WcMaterial(Integer wcmId, Date creattime, Integer createid,
			Integer enabled) {
		this.wcmId = wcmId;
		this.creattime = creattime;
		this.createid = createid;
		this.enabled = enabled;
	}

	/** full constructor */
	public WcMaterial(Integer wcmId, Integer wcmType, String wcmName,
			String wcmDesc, Date creattime, Integer createid,
			Integer enabled) {
		this.wcmId = wcmId;
		this.wcmType = wcmType;
		this.wcmName = wcmName;
		this.wcmDesc = wcmDesc;
		this.creattime = creattime;
		this.createid = createid;
		this.enabled = enabled;
	}

	// Property accessors

	public Integer getWcmId() {
		return this.wcmId;
	}

	public void setWcmId(Integer wcmId) {
		this.wcmId = wcmId;
	}

	public Integer getWcmType() {
		return this.wcmType;
	}

	public void setWcmType(Integer wcmType) {
		this.wcmType = wcmType;
	}

	public String getWcmName() {
		return this.wcmName;
	}

	public void setWcmName(String wcmName) {
		this.wcmName = wcmName;
	}

	public String getWcmDesc() {
		return this.wcmDesc;
	}

	public void setWcmDesc(String wcmDesc) {
		this.wcmDesc = wcmDesc;
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