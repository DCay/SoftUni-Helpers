package org.softuni.exam.service;

import org.softuni.exam.domain.models.service.ProblemServiceModel;

import java.util.List;

public interface ProblemService {
    ProblemServiceModel getProblemById(String problemId);

    ProblemServiceModel createProblem(ProblemServiceModel problemServiceModel);

    List<ProblemServiceModel> getAllProblems();
}