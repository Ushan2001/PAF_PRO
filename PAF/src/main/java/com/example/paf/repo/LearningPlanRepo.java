package com.example.paf.repo;


import com.example.paf.model.LearningPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningPlanRepo extends JpaRepository<LearningPlan, Integer> {
    @Query(value = "SELECT * FROM learning_plan WHERE id = ?1", nativeQuery = true)
    LearningPlan getLearningPlanById(Integer learningPlanId);
}
