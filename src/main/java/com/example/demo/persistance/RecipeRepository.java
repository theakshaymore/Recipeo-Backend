package com.example.demo.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer>{
	@Query("from Recipe where name=?1")
	public List<Recipe> displayingByName(String name);
	
	@Modifying
    @Query("UPDATE Recipe r SET r.likes = :likes WHERE r.recipeid = :recipeId")
    void updateLikesCount(@Param("recipeId") int recipeId, @Param("likes") int likes);
	
	@Query("from Recipe where userid=?1")
	public List<Recipe> findRecipesByUserId(int userId);
	
	@Modifying
    @Query("DELETE FROM Recipe r WHERE r.userid = :userid")
    void deleteRecipeByuserId(@Param("userid") int userid);
}
