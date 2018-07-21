package com.buildup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Domain 
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int did;
	
	@Column(unique=true)
	private String dname;
	
	@Column
	private String description;
	
	@Column
	private String fname;
	
	@Column
	private String bname;
	
	@Column(columnDefinition = "int default 10.0")
	private float price;
	
	@Transient
	private MultipartFile dimage;
	
	

	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getDimage() {
		return dimage;
	}

	public void setDimage(MultipartFile dimage) {
		this.dimage = dimage;
	}
	
	

}
