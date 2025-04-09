package com.example.paf.controller;


import com.example.paf.dto.RatingDTO;
import com.example.paf.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/ratings")
    public List<RatingDTO> getRatings() {
        return ratingService.getAllOrders();
    }

    @GetMapping("/rating/{ratingId}")
    public RatingDTO getOrderById(@PathVariable Integer ratingId) {
        return ratingService.getRatingById(ratingId);
    }

    @PostMapping("/rating")
    public RatingDTO saveRating(@RequestBody RatingDTO ratingDTO) {
        return ratingService.saveRating(ratingDTO);
    }

    @PutMapping("/rating")
    public RatingDTO updateRating(@RequestBody RatingDTO ratingDTO) {
        return ratingService.updateRating(ratingDTO);
    }

    @DeleteMapping("/rating/{ratingId}")
    public String deleteRating(@PathVariable Integer ratingId) {
        return ratingService.deleteRating(ratingId);
    }


}
