package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Recipe")
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recipeid")
	private int recipeid;
	

	@Column(name = "name")
	private String name;

	@Column(name = "ingredients")
	private String ingredients;

	@Column(name = "description")
	private String description;

	@Column(name = "preparationtime")
	private String preparationtime;

	@Column(name = "image")
	private String image;

	@Column(name = "likes")
	private int likes;
	
	@Column(name="userid")
	private int userid;
	@ManyToOne(targetEntity = User.class,fetch = FetchType.EAGER)
	@JoinColumn(name="userid",insertable = false,updatable = false)
	private User user;
	
	@OneToMany(mappedBy="recipe")
	private List<Comment> comments;

	public Recipe() {
	}

	public Recipe(int recipeid, String name, String ingredients, String description, String preparationtime,
			String image, int likes, int userid) {
		this.recipeid = recipeid;
		this.name = name;
		this.ingredients = ingredients;
		this.description = description;
		this.preparationtime = preparationtime;
		this.image = image;
		this.likes = likes;
		this.userid = userid;
	}

	public int getRecipeid() {
		return recipeid;
	}

	public void setRecipeid(int recipeid) {
		this.recipeid = recipeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPreparationtime() {
		return preparationtime;
	}

	public void setPreparationtime(String preparationtime) {
		this.preparationtime = preparationtime;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Recipe [recipeid=" + recipeid + ", name=" + name + ", ingredients=" + ingredients + ", description="
				+ description + ", preparationtime=" + preparationtime + ", image=" + image + ", likes=" + likes
				+ ", userid=" + userid + "]";
	}

}
