package com.revature.dto;

public class ReqCommentDTO {
	private int id;
	private int anime_id;
	private int author;
	private String comment;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAnime_id() {
		return anime_id;
	}
	public void setAnime_id(int anime_id) {
		this.anime_id = anime_id;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "ReqCommentDTO [id=" + id + ", anime_id=" + anime_id + ", author=" + author + ", comment=" + comment
				+ "]";
	}
	
	
}
