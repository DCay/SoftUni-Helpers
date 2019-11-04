package org.softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.softuni.exam.domain.entities.Problem;
import org.softuni.exam.domain.models.service.ProblemServiceModel;
import org.softuni.exam.repository.ProblemRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemServiceImpl implements ProblemService {
    private final ProblemRepository problemRepository;

    private final ModelMapper modelMapper;

    @Inject
    public ProblemServiceImpl(ProblemRepository problemRepository, ModelMapper modelMapper) {
        this.problemRepository = problemRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProblemServiceModel getProblemById(String problemId) {
        return this.modelMapper.map(
                this.problemRepository.findById(problemId), ProblemServiceModel.class);
    }

    @Override
    public ProblemServiceModel createProblem(ProblemServiceModel problemServiceModel) {
        return this.modelMapper.map(
                this.problemRepository
                        .save(this.modelMapper.map(problemServiceModel, Problem.class)),
                ProblemServiceModel.class);
    }

    @Override
    public List<ProblemServiceModel> getAllProblems() {
        return this.problemRepository.findAll()
                .stream()
                .map(x -> this.modelMapper.map(x, ProblemServiceModel.class))
                .collect(Collectors.toList());
    }
}
