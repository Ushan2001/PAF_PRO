package com.example.paf.controller;


import com.example.paf.dto.LearningPlanDTO;
import com.example.paf.service.LearningPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class LearningPlanController {
    @Autowired
    private LearningPlanService learningPlanService;

    @GetMapping("/learning-plans")
    public List<LearningPlanDTO> getLearningPlans() {
        return learningPlanService.getAllLearningPlans();
    }

    @GetMapping("/learning-plan/{learningPlanId}")
    public LearningPlanDTO getLearningPlanById(@PathVariable Integer learningPlanId) {
        return learningPlanService.getLearningPlanById(learningPlanId);
    }

    @PostMapping("/learning-plan")
    public LearningPlanDTO saveLearningPlan(@RequestBody LearningPlanDTO learningPlanDTO) {
        return learningPlanService.saveLearningPlan(learningPlanDTO);
    }

    @PutMapping("/learning-plan")
    public LearningPlanDTO updateLearningPlan(@RequestBody LearningPlanDTO learningPlanDTO) {
        return learningPlanService.updateLearningPlan(learningPlanDTO);
    }

    @DeleteMapping("/learning-plan/{learningPlanId}")
    public String deleteLearningPlan(@PathVariable Integer learningPlanId) {
        return learningPlanService.deleteLearningPlan(learningPlanId);
    }
}
