package com.example.paf.repo;

import com.example.paf.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository


public interface CommentRepo extends JpaRepository<Comment, Integer> {
    @Query(value = "SELECT * FROM comment WHERE id = ?1", nativeQuery = true)
    Comment getCommentById(Integer commentId);

    @Query(value = "SELECT * FROM comment WHERE post_id = ?1", nativeQuery = true)
    List<Comment> getCommentsByPostId(Integer postId);
}
