package com.example.paf.repo;

import com.example.paf.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface PostRepo extends JpaRepository<Post,Integer> {
    @Query(value = "SELECT * FROM post WHERE id = ?1", nativeQuery = true)
    Post getPostById(Integer postId);
}
