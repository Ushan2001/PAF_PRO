package com.example.paf.service;


import com.example.paf.dto.LearningPlanDTO;
import com.example.paf.model.LearningPlan;
import com.example.paf.repo.LearningPlanRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class LearningPlanService {
    @Autowired
    private LearningPlanRepo learningPlanRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<LearningPlanDTO> getAllLearningPlans() {
        List<LearningPlan> learningPlanList = learningPlanRepo.findAll();
        return modelMapper.map(learningPlanList, new TypeToken<List<LearningPlanDTO>>() {
        }.getType());
    }

    public LearningPlanDTO saveLearningPlan(LearningPlanDTO learningPlanDTO) {
        learningPlanRepo.save(modelMapper.map(learningPlanDTO, LearningPlan.class));
        return learningPlanDTO;
    }

    public LearningPlanDTO updateLearningPlan(LearningPlanDTO learningPlanDTO) {
        learningPlanRepo.save(modelMapper.map(learningPlanDTO, LearningPlan.class));
        return learningPlanDTO;
    }

    public String deleteLearningPlan(Integer learningPlanId) {
        learningPlanRepo.deleteById(learningPlanId);
        return "Learning Plan Deleted Successfully";
    }

    public LearningPlanDTO getLearningPlanById(Integer learningPlanId) {
        LearningPlan learningPlan = learningPlanRepo.getLearningPlanById(learningPlanId);
        return modelMapper.map(learningPlan, LearningPlanDTO.class);
    }
}

