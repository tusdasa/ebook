package net.tusdasa.domain;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -8871773374415918420L;
	
	//uid唯一
	private int uid;
	//用户名
	private String username;
	//密码
	private String password;
	//电子邮件
	private String email;
	//用户类型  0/1 0 管理员 1 普通用户
	private int type=1;
	//用户类型 0/1/2 0未验证 1已验证 2被禁用
	private int status=0;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
