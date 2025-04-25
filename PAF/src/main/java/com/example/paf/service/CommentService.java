package com.example.paf.service;

import com.example.paf.dto.CommentDTO;
import com.example.paf.model.Comment;
import com.example.paf.repo.CommentRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional


public class CommentService {
    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<CommentDTO> getAllComments() {
        List<Comment> commentList = commentRepo.findAll();
        return modelMapper.map(commentList, new TypeToken<List<CommentDTO>>() {
        }.getType());
    }

    public List<CommentDTO> getCommentsByPostId(Integer postId) {
        List<Comment> commentList = commentRepo.getCommentsByPostId(postId);
        return modelMapper.map(commentList, new TypeToken<List<CommentDTO>>() {
        }.getType());
    }

    public CommentDTO saveComment(CommentDTO commentDTO) {
        if (commentDTO.getDate() == null) {
            commentDTO.setDate(LocalDateTime.now());
        }
        commentRepo.save(modelMapper.map(commentDTO, Comment.class));
        return commentDTO;
    }

    public CommentDTO updateComment(CommentDTO commentDTO) {
        commentRepo.save(modelMapper.map(commentDTO, Comment.class));
        return commentDTO;
    }

    public String deleteComment(Integer commentId) {
        commentRepo.deleteById(commentId);
        return "Comment Deleted Successfully";
    }

    public CommentDTO getCommentById(Integer commentId) {
        Comment comment = commentRepo.getCommentById(commentId);
        return modelMapper.map(comment, CommentDTO.class);
    }

}
