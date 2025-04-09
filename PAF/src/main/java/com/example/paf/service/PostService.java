package com.example.paf.service;


import com.example.paf.dto.PostDTO;
import com.example.paf.model.Post;
import com.example.paf.repo.PostRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class PostService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<PostDTO> getAllPosts() {
        List<Post> postList = postRepo.findAll();
        return modelMapper.map(postList, new TypeToken<List<PostDTO>>() {
        }.getType());
    }

    public PostDTO savePost(PostDTO postDTO) {
        postRepo.save(modelMapper.map(postDTO, Post.class));
        return postDTO;
    }

    public PostDTO updatePost(PostDTO postDTO) {
        postRepo.save(modelMapper.map(postDTO, Post.class));
        return postDTO;
    }

    public String deletePost(Integer postId) {
        postRepo.deleteById(postId);
        return "Post Deleted Successfully";
    }

    public PostDTO getPostById(Integer postId) {
        Post post = postRepo.getPostById(postId);
        return modelMapper.map(post, PostDTO.class);
    }

}
