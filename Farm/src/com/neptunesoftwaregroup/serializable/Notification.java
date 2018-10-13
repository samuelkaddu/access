package com.neptunesoftwaregroup.serializable;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Notification implements Serializable {

	String name, desc, create_by, updated_by, row_ts, create_date, last_modify;

	public Notification() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	public String getRow_ts() {
		return row_ts;
	}

	public void setRow_ts(String row_ts) {
		this.row_ts = row_ts;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getLast_modify() {
		return last_modify;
	}

	public void setLast_modify(String last_modify) {
		this.last_modify = last_modify;
	}

}
