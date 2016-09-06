package com.web.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

	private static final long serialVersionUID = 1845830984737917078L;

	private int uid;//0员工工号
	
	private int number;//工號
	
	private String userName;//1用户登录名
	
	private String userPass;//2rivate
	
	private String realName;//3真实姓名
	
	private String phone;//4手机号
		
	private String picture;//5用户头像图片路径
	
	private String email;//6邮箱
	
	private String qq;//7QQ
	
	private String weChat;
	
	private String emContact;//8緊急聯係人
	
	private String emPhone;//9紧急联系人手机号
	
	private int deptid;//10所属部门ID
	
	private Date intime;//11入职时间
	
	private int bol;//12是否有效

	public User() {
	}

	public User(int uid, int number, String userName, String userPass,
			String realName, String phone, String picture, String email,
			String qq, String weChat, String emContact, String emPhone,
			int deptid, Date intime, int bol) {
		this.uid = uid;
		this.number = number;
		this.userName = userName;
		this.userPass = userPass;
		this.realName = realName;
		this.phone = phone;
		this.picture = picture;
		this.email = email;
		this.qq = qq;
		this.weChat = weChat;
		this.emContact = emContact;
		this.emPhone = emPhone;
		this.deptid = deptid;
		this.intime = intime;
		this.bol = bol;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeChat() {
		return weChat;
	}

	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}

	public String getEmContact() {
		return emContact;
	}

	public void setEmContact(String emContact) {
		this.emContact = emContact;
	}

	public String getEmPhone() {
		return emPhone;
	}

	public void setEmPhone(String emPhone) {
		this.emPhone = emPhone;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public Date getIntime() {
		return intime;
	}

	public void setIntime(Date intime) {
		this.intime = intime;
	}

	public int getBol() {
		return bol;
	}

	public void setBol(int bol) {
		this.bol = bol;
	}

}
