package com.example.paf.controller;

import com.example.paf.dto.CommentDTO;
import com.example.paf.service.CommentService;
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

public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public List<CommentDTO> getComments(@AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        return commentService.getAllComments();
    }

    @GetMapping("/comments/post/{postId}")
    public List<CommentDTO> getCommentsByPostId(@PathVariable Integer postId, @AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        return commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/comment/{commentId}")
    public CommentDTO getCommentById(@PathVariable Integer commentId, @AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        return commentService.getCommentById(commentId);
    }

    @PostMapping("/comment")
    public CommentDTO saveComment(@RequestBody CommentDTO commentDTO, @AuthenticationPrincipal OAuth2User principal) {

        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        return commentService.saveComment(commentDTO);
    }

    @PutMapping("/comment")
    public CommentDTO updateComment(@RequestBody CommentDTO commentDTO, @AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        return commentService.updateComment(commentDTO);
    }

    @DeleteMapping("/comment/{commentId}")
    public String deleteComment(@PathVariable Integer commentId, @AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }

        return commentService.deleteComment(commentId);
}

}
