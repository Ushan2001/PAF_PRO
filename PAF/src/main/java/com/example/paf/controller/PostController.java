package com.example.paf.controller;

import com.example.paf.dto.PostDTO;
import com.example.paf.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")

public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<PostDTO> getPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/post/{postId}")
    public PostDTO getPostById(@PathVariable Integer postId) {
        return postService.getPostById(postId);
    }

    @PostMapping("/post")
    public PostDTO savePost(@RequestBody PostDTO postDTO) {
        return postService.savePost(postDTO);
    }

    @PutMapping("/post")
    public PostDTO updatePost(@RequestBody PostDTO postDTO) {
        return postService.updatePost(postDTO);
    }

    @DeleteMapping("/post/{postId}")
    public String deletePost(@PathVariable Integer postId) {
        return postService.deletePost(postId);
}
}
