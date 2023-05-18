package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Recipe;
import com.example.demo.entity.User;

public interface ServiceDeclaration {
	
	//FOR USER
	public List<User> displayAlldata();
	public User displayById(int id);
	public List<User> displayByName(String name);
	public User getUserByEmailAndPassword(String email, String password);
	public void insertUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	
	//FOR RECIPE
	public List<Recipe> displayAllRecipeData();
	public Recipe getByRecipeId(int id);
	public List<Recipe> getRecipesByUserId(int userId);
	public List<Recipe> getByRecipeName(String name);
	public void insertRecipe(Recipe rec);
	public void updateRecipeDetails(Recipe rec); 
    public void deletionRecipe(int id);
    public void deleteUserAndRecipeByUserID(int userId);
    public void addLikeByRecipeId(int recipeId, int likes);
    
    //FOR COMMENT
    public List<Comment> displayAllComments(); 
    public List<Comment> getCommentsByRecipeId(int id); 
	public Comment displayByCommentId(int id); 
	public void insertComment(Comment com); 
	public void updateCommentDetails(Comment com); 
    public void deletionOfComment(int id);
    public List<String> getUserNameByRecipeId(int id);
}
