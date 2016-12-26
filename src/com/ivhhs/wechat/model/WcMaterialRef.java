package com.ivhhs.wechat.model;



/**
 * WcMaterialRef entity. @author MyEclipse Persistence Tools
 */

public class WcMaterialRef implements java.io.Serializable {

	// Fields

	private Integer wcmrfid;
	private Integer wcmid;
	private Integer wcmsid;

	// Constructors

	/** default constructor */
	public WcMaterialRef() {
	}

	/** full constructor */
	public WcMaterialRef(Integer wcmrfid, Integer wcmid, Integer wcmsid) {
		this.wcmrfid = wcmrfid;
		this.wcmid = wcmid;
		this.wcmsid = wcmsid;
	}

	// Property accessors

	public Integer getWcmrfid() {
		return this.wcmrfid;
	}

	public void setWcmrfid(Integer wcmrfid) {
		this.wcmrfid = wcmrfid;
	}

	public Integer getWcmid() {
		return this.wcmid;
	}

	public void setWcmid(Integer wcmid) {
		this.wcmid = wcmid;
	}

	public Integer getWcmsid() {
		return this.wcmsid;
	}

	public void setWcmsid(Integer wcmsid) {
		this.wcmsid = wcmsid;
	}

}