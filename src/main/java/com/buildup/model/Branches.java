package com.buildup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Branches 
{



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bid;
	
	@Column(unique=true)
	private String bname;
	
	@Column
	private String description;
	
	@Column
	private String fname;
	
	@Transient
	private MultipartFile bimage;

	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getBimage() {
		return bimage;
	}

	public void setBimage(MultipartFile bimage) {
		this.bimage = bimage;
	}

	
	
}
