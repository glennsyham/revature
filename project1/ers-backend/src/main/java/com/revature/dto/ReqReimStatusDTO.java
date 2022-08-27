package com.revature.dto;

public class ReqReimStatusDTO {
	private int id;
	private int user_id;
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "ReqReimStatusDTO [id=" + id + ", user_id=" + user_id + ", status=" + status + "]";
	}
}
