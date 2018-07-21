package com.buildup.model;
	
	import javax.persistence.Column;
	import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
	

	@Entity
	public class Liked {
		
		@Id
	    @GeneratedValue(strategy=GenerationType.AUTO) // to generate a random ID
		private int id;
		
		@Column
		private String uid;	
		@Column
		private int pid;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUid() {
			return uid;
		}
		public void setUid(String uid) {
			this.uid = uid;
		}
		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
		}
		
		
		
		
		
	}


