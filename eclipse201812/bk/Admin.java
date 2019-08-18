package com.liangx.practice.booksystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	private String admId;
	private String admName;
	private String admPassword;
	public Admin(String admId, String admName, String admPassword) {
		this.admId = admId;
		this.admName = admName;
		this.admPassword = admPassword;
	}
	public Admin() {
		super();
	}
	public String getAdmId() {
		return admId;
	}
	public void setAdmId(String admId) {
		this.admId = admId == null ? null : admId.trim();
	}
	public String getAdmName() {
		return admName;
	}
	public void setAdmName(String admName) {
		this.admName = admName == null ? null : admName.trim();
	}
	public String getAdmPassword() {
		return admPassword;
	}
	public void setAdmPassword(String admPassword) {
		this.admPassword = admPassword == null ? null : admPassword.trim();
	}
	private String id;
	private String name;
	private String password;
}
