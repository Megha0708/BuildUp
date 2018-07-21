package com.buildup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Fields 
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int fid;
	
	@Column(unique=true)
	private String fname;
	
	@Column
	private String description;
	
	@Transient
	private MultipartFile fimage;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getFimage() {
		return fimage;
	}

	public void setFimage(MultipartFile fimage) {
		this.fimage = fimage;
	}
	
}
