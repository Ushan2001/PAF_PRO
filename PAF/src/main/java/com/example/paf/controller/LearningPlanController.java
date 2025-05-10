package com.example.paf.controller;


import com.example.paf.dto.LearningPlanDTO;
import com.example.paf.service.LearningPlanService;
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
public class LearningPlanController {
    @Autowired
    private LearningPlanService learningPlanService;

    @GetMapping("/learning-plans")
    public List<LearningPlanDTO> getLearningPlans(@AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        return learningPlanService.getAllLearningPlans();
    }

    @GetMapping("/learning-plan/{learningPlanId}")
    public LearningPlanDTO getLearningPlanById(@PathVariable Integer learningPlanId, @AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        return learningPlanService.getLearningPlanById(learningPlanId);
    }

    @PostMapping("/learning-plan")
    public LearningPlanDTO saveLearningPlan(@RequestBody LearningPlanDTO learningPlanDTO, @AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        return learningPlanService.saveLearningPlan(learningPlanDTO);
    }

    @PutMapping("/learning-plan")
    public LearningPlanDTO updateLearningPlan(@RequestBody LearningPlanDTO learningPlanDTO, @AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        return learningPlanService.updateLearningPlan(learningPlanDTO);
    }

    @DeleteMapping("/learning-plan/{learningPlanId}")
    public String deleteLearningPlan(@PathVariable Integer learningPlanId, @AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        return learningPlanService.deleteLearningPlan(learningPlanId);
    }
}
