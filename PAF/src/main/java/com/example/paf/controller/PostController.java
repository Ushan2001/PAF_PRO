package com.example.paf.controller;

import com.example.paf.dto.PostDTO;
import com.example.paf.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")

public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<PostDTO> getPosts(@AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        return postService.getAllPosts();
    }

    @GetMapping("/post/{postId}")
    public PostDTO getPostById(@PathVariable Integer postId, @AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        return postService.getPostById(postId);
    }

    @PostMapping("/post")
    public PostDTO savePost(@RequestBody PostDTO postDTO, @AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        return postService.savePost(postDTO);
    }

    @PutMapping("/post")
    public PostDTO updatePost(@RequestBody PostDTO postDTO, @AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        return postService.updatePost(postDTO);
    }

    @DeleteMapping("/post/{postId}")
    public String deletePost(@PathVariable Integer postId, @AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        return postService.deletePost(postId);
}
}
