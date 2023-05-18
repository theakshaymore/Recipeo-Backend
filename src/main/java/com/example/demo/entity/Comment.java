package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Comment")
public class Comment {
	@Id           
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="commentid")
	private int commentid;
	
	@Column(name="text")
	private String text;
	
	@Column(name="recipeid")
	private int recipeid;
	
	@Column(name="userid")
	private int userid;
	
	@ManyToOne(targetEntity = Recipe.class,fetch = FetchType.EAGER)
	@JoinColumn(name="recipeid",insertable = false,updatable = false)
	private Recipe recipe;
	
	@ManyToOne(targetEntity = User.class,fetch = FetchType.EAGER)
	@JoinColumn(name="userid",insertable = false,updatable = false)
	private User user;
	
	public Comment() {
		
	}
	public Comment(int commentid, String text, int recipeid, int userid) {
		this.commentid = commentid;
		this.text = text;
		this.recipeid = recipeid;
		this.userid = userid;
	}
	
	
	
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getRecipeid() {
		return recipeid;
	}
	public void setRecipeid(Integer recipeid) {
		this.recipeid = recipeid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	@Override
	public String toString() {
		return "Comment [commentid=" + commentid + ", text=" + text + ", recipeid=" + recipeid + ", userid="
				+ userid + "]";
	}

}

