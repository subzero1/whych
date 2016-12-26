package com.ivhhs.wechat.model;


import java.util.Date;

/**
 * WcPersonnel entity. @author MyEclipse Persistence Tools
 */

public class WcPersonnel implements java.io.Serializable {

	// Fields

	private Integer wcpid;
	private String userid;
	private String wcpdepart;
	private String wcpname;
	private String wcpposition;
	private String wcpemail;
	private String wcpmobile;
	private String wcpgender;
	private String weixinid;
	private String wcpmavatar;
	private String wcpstatus;
	private Date creattime;
	private Integer createid;
	private Integer enabled;

	// Constructors

	/** default constructor */
	public WcPersonnel() {
	}

	/** minimal constructor */
	public WcPersonnel(Integer wcpid, Date creattime, Integer createid,
			Integer enabled) {
		this.wcpid = wcpid;
		this.creattime = creattime;
		this.createid = createid;
		this.enabled = enabled;
	}

	/** full constructor */
	public WcPersonnel(Integer wcpid, String userid, String wcpdepart,
			String wcpname, String wcpposition, String wcpemail,
			String wcpmobile, String wcpgender, String weixinid,
			String wcpmavatar, String wcpstatus, Date creattime,
			Integer createid, Integer enabled) {
		this.wcpid = wcpid;
		this.userid = userid;
		this.wcpdepart = wcpdepart;
		this.wcpname = wcpname;
		this.wcpposition = wcpposition;
		this.wcpemail = wcpemail;
		this.wcpmobile = wcpmobile;
		this.wcpgender = wcpgender;
		this.weixinid = weixinid;
		this.wcpmavatar = wcpmavatar;
		this.wcpstatus = wcpstatus;
		this.creattime = creattime;
		this.createid = createid;
		this.enabled = enabled;
	}

	// Property accessors

	public Integer getWcpid() {
		return this.wcpid;
	}

	public void setWcpid(Integer wcpid) {
		this.wcpid = wcpid;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getWcpdepart() {
		return this.wcpdepart;
	}

	public void setWcpdepart(String wcpdepart) {
		this.wcpdepart = wcpdepart;
	}

	public String getWcpname() {
		return this.wcpname;
	}

	public void setWcpname(String wcpname) {
		this.wcpname = wcpname;
	}

	public String getWcpposition() {
		return this.wcpposition;
	}

	public void setWcpposition(String wcpposition) {
		this.wcpposition = wcpposition;
	}

	public String getWcpemail() {
		return this.wcpemail;
	}

	public void setWcpemail(String wcpemail) {
		this.wcpemail = wcpemail;
	}

	public String getWcpmobile() {
		return this.wcpmobile;
	}

	public void setWcpmobile(String wcpmobile) {
		this.wcpmobile = wcpmobile;
	}

	public String getWcpgender() {
		return this.wcpgender;
	}

	public void setWcpgender(String wcpgender) {
		this.wcpgender = wcpgender;
	}

	public String getWeixinid() {
		return this.weixinid;
	}

	public void setWeixinid(String weixinid) {
		this.weixinid = weixinid;
	}

	public String getWcpmavatar() {
		return this.wcpmavatar;
	}

	public void setWcpmavatar(String wcpmavatar) {
		this.wcpmavatar = wcpmavatar;
	}

	public String getWcpstatus() {
		return this.wcpstatus;
	}

	public void setWcpstatus(String wcpstatus) {
		this.wcpstatus = wcpstatus;
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