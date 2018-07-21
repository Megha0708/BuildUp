package com.buildup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lesson 
{
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private int lid;
   
   @Column
   private String name;
   
   @Column
   private String mentor;
   
   @Column
   private String description;
   
   @Column
   private String field;
   
   @Column
   private String domain;
   
   @Column
   private String branch;
   
   @Column
   private float cost;

public int getLid() {
	return lid;
}

public void setLid(int lid) {
	this.lid = lid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getMentor() {
	return mentor;
}

public void setMentor(String mentor) {
	this.mentor = mentor;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getField() {
	return field;
}

public void setField(String field) {
	this.field = field;
}

public String getDomain() {
	return domain;
}

public void setDomain(String domain) {
	this.domain = domain;
}

public String getBranch() {
	return branch;
}

public void setBranch(String branch) {
	this.branch = branch;
}

public float getCost() {
	return cost;
}

public void setCost(float cost) {
	this.cost = cost;
}
   
   
}
