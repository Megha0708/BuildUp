package com.buildup.model;
import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.Transient;

	@Entity
	public class Organisation
	 {
		
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO) // to generate a random ID
		private int comId;
	    
		@Column(unique = true)
		private String orgName;
		
		@Column
		private String fullName;
		
		@Column(unique=true)
		private String username;
		
		@Column
		private String phone;

		@Column
		private String email;
		
		@Transient
		private String password;
		
		@Column
		private String orgSize;
		
		@Column
		private String objective;
		
		@Column
		private String timeslot;
		
		

		public String getTimeslot() {
			return timeslot;
		}

		public void setTimeslot(String timeslot) {
			this.timeslot = timeslot;
		}

		public int getComId() {
			return comId;
		}

		public void setComId(int comId) {
			this.comId = comId;
		}

		public String getOrgName() {
			return orgName;
		}

		public void setOrgName(String orgName) {
			this.orgName = orgName;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getOrgSize() {
			return orgSize;
		}

		public void setOrgSize(String orgSize) {
			this.orgSize = orgSize;
		}

		public String getObjective() {
			return objective;
		}

		public void setObjective(String objective) {
			this.objective = objective;
		}
		
		
	 
	 }
