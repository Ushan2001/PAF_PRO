package com.example.paf.controller;

import com.example.paf.dto.CommentDTO;
import com.example.paf.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")

public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public List<CommentDTO> getComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/comments/post/{postId}")
    public List<CommentDTO> getCommentsByPostId(@PathVariable Integer postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/comment/{commentId}")
    public CommentDTO getCommentById(@PathVariable Integer commentId) {
        return commentService.getCommentById(commentId);
    }

    @PostMapping("/comment")
    public CommentDTO saveComment(@RequestBody CommentDTO commentDTO) {
        return commentService.saveComment(commentDTO);
    }

    @PutMapping("/comment")
    public CommentDTO updateComment(@RequestBody CommentDTO commentDTO) {
        return commentService.updateComment(commentDTO);
    }

    @DeleteMapping("/comment/{commentId}")
    public String deleteComment(@PathVariable Integer commentId) {
        return commentService.deleteComment(commentId);
}

}
