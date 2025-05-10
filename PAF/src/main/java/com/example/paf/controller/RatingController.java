package com.example.paf.controller;

import com.example.paf.dto.RatingDTO;
import com.example.paf.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/ratings")
    public List<RatingDTO> getRatings(@AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        return ratingService.getAllRatings();
    }

    @GetMapping("/rating/{ratingId}")
    public RatingDTO getRatingById(@PathVariable Integer ratingId, @AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        return ratingService.getRatingById(ratingId);
    }

    @PostMapping("/rating")
    public RatingDTO saveRating(@RequestBody RatingDTO ratingDTO, @AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        return ratingService.saveRating(ratingDTO);
    }

    @PutMapping("/rating")
    public RatingDTO updateRating(@RequestBody RatingDTO ratingDTO, @AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        return ratingService.updateRating(ratingDTO);
    }

    @DeleteMapping("/rating/{ratingId}")
    public String deleteRating(@PathVariable Integer ratingId, @AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        return ratingService.deleteRating(ratingId);
    }
}