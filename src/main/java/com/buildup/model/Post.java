package com.buildup.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

//import org.hibernate.annotations.ColumnDefault;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Post 
{
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO) // to generate a random ID
	private int pId;
	
	@Column
  private String mpost;
	
	@Transient
	private MultipartFile pimage;
	
	@Column(columnDefinition = "int default 0")
	private int likes;
	
	//@ColumnDefault(" ")
	//@Column
	//private String likedby ; 

	
	
	
	
	/* public String getLikedby() {
		return likedby;
	}

	public void setLikedby(String likedby) {
		this.likedby = likedby;
	}*/

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public MultipartFile getPimage() {
		return pimage;
	}

	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}

	

	public String getMpost() {
		return mpost;
	}

	public void setMpost(String mpost) {
		this.mpost = mpost;
	}

	
	
	
  
	
	
}
