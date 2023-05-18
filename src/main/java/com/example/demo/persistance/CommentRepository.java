package com.example.demo.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Comment;
import com.example.demo.entity.User;


public interface CommentRepository extends JpaRepository<Comment, Integer> {
	@Query("from Comment where recipeid=?1")
	public List<Comment> displayCommentsByRecipeName(int id);
	
//	@Query("SELECT User.username FROM Comment JOIN Comment.userid = User.userid WHERE Comment.recipeid = ?1")
//	String findUsernameByRecipeId(int id);
//	@Query("SELECT c.user.username FROM Comment c WHERE c.recipe.id = :recipeId")
	@Query("SELECT DISTINCT  u.username FROM Comment c JOIN User u ON c.user.userid = u.userid WHERE c.recipeid =?1")
	public List<String> findUsernameByRecipeId(@Param("recipeId") int recipeId);
	
//	SELECT u.username FROM Comment c JOIN User u ON c.user.userid = u.userid WHERE c.recipeid =?1;
	
	@Modifying
    @Query("DELETE FROM Comment c WHERE c.recipeid = :recipeId")
    void deleteCommentsByRecipeId(@Param("recipeId") int recipeId);

}
