package com.ivhhs.wechat.model;


import java.util.Date;

/**
 * WhychLike entity. @author MyEclipse Persistence Tools
 */

public class WhychLike implements java.io.Serializable {

	// Fields

	private Integer whlid;
	private Integer wcpid;
	private Integer wcpidL;
	private Date whlTime;

	// Constructors

	/** default constructor */
	public WhychLike() {
	}

	/** minimal constructor */
	public WhychLike(Integer whlid, Date whlTime) {
		this.whlid = whlid;
		this.whlTime = whlTime;
	}

	/** full constructor */
	public WhychLike(Integer whlid, Integer wcpid, Integer wcpidL,
			Date whlTime) {
		this.whlid = whlid;
		this.wcpid = wcpid;
		this.wcpidL = wcpidL;
		this.whlTime = whlTime;
	}

	// Property accessors

	public Integer getWhlid() {
		return this.whlid;
	}

	public void setWhlid(Integer whlid) {
		this.whlid = whlid;
	}

	public Integer getWcpid() {
		return this.wcpid;
	}

	public void setWcpid(Integer wcpid) {
		this.wcpid = wcpid;
	}

	public Integer getWcpidL() {
		return this.wcpidL;
	}

	public void setWcpidL(Integer wcpidL) {
		this.wcpidL = wcpidL;
	}

	public Date getWhlTime() {
		return this.whlTime;
	}

	public void setWhlTime(Date whlTime) {
		this.whlTime = whlTime;
	}

}