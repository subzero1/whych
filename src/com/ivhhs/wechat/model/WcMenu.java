package com.ivhhs.wechat.model;

import java.util.Date;

/**
 * WcMenu entity. @author MyEclipse Persistence Tools
 */

public class WcMenu implements java.io.Serializable {

	// Fields

	private Integer wcmuid;
	private String wcmuType;
	private String wcmuName;
	private String wcmuKey;
	private String wcmuUrl;
	private Integer wcmuFid;
	private Integer wcmuOrder;
	private Date creattime;
	private Integer createid;
	private Integer enabled;

	// Constructors

	/** default constructor */
	public WcMenu() {
	}

	/** minimal constructor */
	public WcMenu(Integer wcmuid, Date creattime, Integer createid,
			Integer enabled) {
		this.wcmuid = wcmuid;
		this.creattime = creattime;
		this.createid = createid;
		this.enabled = enabled;
	}

	/** full constructor */
	public WcMenu(Integer wcmuid, String wcmuType, String wcmuName,
			String wcmuKey, String wcmuUrl, Integer wcmuFid, Integer wcmuOrder,
			Date creattime, Integer createid, Integer enabled) {
		this.wcmuid = wcmuid;
		this.wcmuType = wcmuType;
		this.wcmuName = wcmuName;
		this.wcmuKey = wcmuKey;
		this.wcmuUrl = wcmuUrl;
		this.wcmuFid = wcmuFid;
		this.wcmuOrder = wcmuOrder;
		this.creattime = creattime;
		this.createid = createid;
		this.enabled = enabled;
	}

	// Property accessors

	public Integer getWcmuid() {
		return this.wcmuid;
	}

	public void setWcmuid(Integer wcmuid) {
		this.wcmuid = wcmuid;
	}

	public String getWcmuType() {
		return this.wcmuType;
	}

	public void setWcmuType(String wcmuType) {
		this.wcmuType = wcmuType;
	}

	public String getWcmuName() {
		return this.wcmuName;
	}

	public void setWcmuName(String wcmuName) {
		this.wcmuName = wcmuName;
	}

	public String getWcmuKey() {
		return this.wcmuKey;
	}

	public void setWcmuKey(String wcmuKey) {
		this.wcmuKey = wcmuKey;
	}

	public String getWcmuUrl() {
		return this.wcmuUrl;
	}

	public void setWcmuUrl(String wcmuUrl) {
		this.wcmuUrl = wcmuUrl;
	}

	public Integer getWcmuFid() {
		return this.wcmuFid;
	}

	public void setWcmuFid(Integer wcmuFid) {
		this.wcmuFid = wcmuFid;
	}

	public Integer getWcmuOrder() {
		return this.wcmuOrder;
	}

	public void setWcmuOrder(Integer wcmuOrder) {
		this.wcmuOrder = wcmuOrder;
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