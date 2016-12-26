package com.ivhhs.wechat.model;



/**
 * WcKeywordRef entity. @author MyEclipse Persistence Tools
 */

public class WcKeywordRef implements java.io.Serializable {

	// Fields

	private Integer wckrfid;
	private Integer wcmid;
	private Integer wckid;

	// Constructors

	/** default constructor */
	public WcKeywordRef() {
	}

	/** full constructor */
	public WcKeywordRef(Integer wckrfid, Integer wcmid, Integer wckid) {
		this.wckrfid = wckrfid;
		this.wcmid = wcmid;
		this.wckid = wckid;
	}

	// Property accessors

	public Integer getWckrfid() {
		return this.wckrfid;
	}

	public void setWckrfid(Integer wckrfid) {
		this.wckrfid = wckrfid;
	}

	public Integer getWcmid() {
		return this.wcmid;
	}

	public void setWcmid(Integer wcmid) {
		this.wcmid = wcmid;
	}

	public Integer getWckid() {
		return this.wckid;
	}

	public void setWckid(Integer wckid) {
		this.wckid = wckid;
	}

}