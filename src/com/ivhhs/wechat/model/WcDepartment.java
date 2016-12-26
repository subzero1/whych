package com.ivhhs.wechat.model;

import java.util.Date;

/**
 * WcDepartment entity. @author MyEclipse Persistence Tools
 */

public class WcDepartment implements java.io.Serializable {

	// Fields

	private Integer wcdid;
	private Integer wcdId;
	private String wcdName;
	private Integer wcd;
	private Integer wcdFid;
	private Date creattime;
	private Integer createid;
	private Integer enabled;

	// Constructors

	/** default constructor */
	public WcDepartment() {
	}

	/** minimal constructor */
	public WcDepartment(Integer wcdid, Date creattime, Integer createid,
			Integer enabled) {
		this.wcdid = wcdid;
		this.creattime = creattime;
		this.createid = createid;
		this.enabled = enabled;
	}

	/** full constructor */
	public WcDepartment(Integer wcdid, Integer wcdId, String wcdName,
			Integer wcd, Integer wcdFid, Date creattime,
			Integer createid, Integer enabled) {
		this.wcdid = wcdid;
		this.wcdId = wcdId;
		this.wcdName = wcdName;
		this.wcd = wcd;
		this.wcdFid = wcdFid;
		this.creattime = creattime;
		this.createid = createid;
		this.enabled = enabled;
	}

	// Property accessors

	public Integer getWcdid() {
		return this.wcdid;
	}

	public void setWcdid(Integer wcdid) {
		this.wcdid = wcdid;
	}

	public Integer getWcdId() {
		return this.wcdId;
	}

	public void setWcdId(Integer wcdId) {
		this.wcdId = wcdId;
	}

	public String getWcdName() {
		return this.wcdName;
	}

	public void setWcdName(String wcdName) {
		this.wcdName = wcdName;
	}

	public Integer getWcd() {
		return this.wcd;
	}

	public void setWcd(Integer wcd) {
		this.wcd = wcd;
	}

	public Integer getWcdFid() {
		return this.wcdFid;
	}

	public void setWcdFid(Integer wcdFid) {
		this.wcdFid = wcdFid;
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