package com.example.bean;

import java.io.Serializable;

public class UserBean implements Serializable {
	private int id;
	private String name;
	private String time;
	private String content;
	private String image;
	private String tagImage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTagImage() {
		return tagImage;
	}
	public void setTagImage(String tagImage) {
		this.tagImage = tagImage;
	}
	
	

}
