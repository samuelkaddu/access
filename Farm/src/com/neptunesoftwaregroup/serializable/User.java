package com.neptunesoftwaregroup.serializable;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {

	private String role_id, user_id, passwd, status, rec_st, gender, phone, email, last_nm, first_nm, login_id,
			create_dt, row_ts, retype_new_passwd, new_passwd;

	public User() {
		super();
	}

	public User(String user_id, String passwd, String status, String rec_st, String gender, String phone, String email,
			String last_nm, String first_nm, String login_id, String create_dt, String row_ts, String role_id) {
		super();
		this.user_id = user_id;
		this.passwd = passwd;
		this.status = status;
		this.rec_st = rec_st;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.last_nm = last_nm;
		this.first_nm = first_nm;
		this.login_id = login_id;
		this.create_dt = create_dt;
		this.row_ts = row_ts;
		this.role_id = role_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRec_st() {
		return rec_st;
	}

	public void setRec_st(String rec_st) {
		this.rec_st = rec_st;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLast_nm() {
		return last_nm;
	}

	public void setLast_nm(String last_nm) {
		this.last_nm = last_nm;
	}

	public String getFirst_nm() {
		return first_nm;
	}

	public void setFirst_nm(String first_nm) {
		this.first_nm = first_nm;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getCreate_dt() {
		return create_dt;
	}

	public void setCreate_dt(String create_dt) {
		this.create_dt = create_dt;
	}

	public String getRow_ts() {
		return row_ts;
	}

	public void setRow_ts(String row_ts) {
		this.row_ts = row_ts;
	}

	public String getRetype_new_passwd() {
		return retype_new_passwd;
	}

	public void setRetype_new_passwd(String retype_new_passwd) {
		this.retype_new_passwd = retype_new_passwd;
	}

	public String getNew_passwd() {
		return new_passwd;
	}

	public void setNew_passwd(String new_passwd) {
		this.new_passwd = new_passwd;
	}

}
