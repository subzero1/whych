package com.ivhhs.wechat.model;


import java.util.Date;

/**
 * WcKeyword entity. @author MyEclipse Persistence Tools
 */

public class WcKeyword implements java.io.Serializable {

	// Fields

	private Integer wckid;
	private String wckKey;
	private Integer wckType;
	private String wckDesc;
	private Date creattime;
	private Integer createid;
	private Integer enabled;

	// Constructors

	/** default constructor */
	public WcKeyword() {
	}

	/** minimal constructor */
	public WcKeyword(Integer wckid, Date creattime, Integer createid,
			Integer enabled) {
		this.wckid = wckid;
		this.creattime = creattime;
		this.createid = createid;
		this.enabled = enabled;
	}

	/** full constructor */
	public WcKeyword(Integer wckid, String wckKey, Integer wckType,
			String wckDesc, Date creattime, Integer createid,
			Integer enabled) {
		this.wckid = wckid;
		this.wckKey = wckKey;
		this.wckType = wckType;
		this.wckDesc = wckDesc;
		this.creattime = creattime;
		this.createid = createid;
		this.enabled = enabled;
	}

	// Property accessors

	public Integer getWckid() {
		return this.wckid;
	}

	public void setWckid(Integer wckid) {
		this.wckid = wckid;
	}

	public String getWckKey() {
		return this.wckKey;
	}

	public void setWckKey(String wckKey) {
		this.wckKey = wckKey;
	}

	public Integer getWckType() {
		return this.wckType;
	}

	public void setWckType(Integer wckType) {
		this.wckType = wckType;
	}

	public String getWckDesc() {
		return this.wckDesc;
	}

	public void setWckDesc(String wckDesc) {
		this.wckDesc = wckDesc;
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