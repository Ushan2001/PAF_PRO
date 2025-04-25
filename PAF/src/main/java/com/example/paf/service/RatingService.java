package com.example.paf.service;


import com.example.paf.dto.PostDTO;
import com.example.paf.dto.RatingDTO;
import com.example.paf.model.Post;
import com.example.paf.model.Rating;
import com.example.paf.repo.RatingRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class RatingService {

    @Autowired
    private RatingRepo ratingRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<RatingDTO> getAllOrders() {
        List<Rating> ratingList = ratingRepo.findAll();
        return modelMapper.map(ratingList, new TypeToken<List<RatingDTO>>() {
        }.getType());
    }

    public RatingDTO saveRating(RatingDTO ratingDTO) {
        ratingRepo.save(modelMapper.map(ratingDTO, Rating.class));
        return ratingDTO;
    }

    public RatingDTO updateRating(RatingDTO ratingDTO) {
        ratingRepo.save(modelMapper.map(ratingDTO, Rating.class));
        return ratingDTO;
    }

    public String deleteRating(Integer ratingId) {
        ratingRepo.deleteById(ratingId);
        return "Rating Deleted Successfully";
    }

    public RatingDTO getRatingById(Integer ratingId) {
        Rating rating = ratingRepo.getRatingBy(ratingId);
        return modelMapper.map(rating, RatingDTO.class);
    }
}
