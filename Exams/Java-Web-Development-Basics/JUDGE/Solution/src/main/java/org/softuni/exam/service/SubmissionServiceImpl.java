package org.softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.softuni.exam.domain.entities.Submission;
import org.softuni.exam.domain.models.service.SubmissionServiceModel;
import org.softuni.exam.repository.SubmissionRepository;

import javax.inject.Inject;

public class SubmissionServiceImpl implements SubmissionService {
    private final SubmissionRepository submissionRepository;

    private final ModelMapper modelMapper;

    @Inject
    public SubmissionServiceImpl(SubmissionRepository submissionRepository, ModelMapper modelMapper) {
        this.submissionRepository = submissionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SubmissionServiceModel createSubmission(SubmissionServiceModel submissionServiceModel) {
        return this.modelMapper.map(
                this.submissionRepository
                        .save(this.modelMapper.map(submissionServiceModel, Submission.class)),
                SubmissionServiceModel.class);
    }

    @Override
    public SubmissionServiceModel getSubmissionById(String id) {
        return this.modelMapper.map(
                this.submissionRepository.findById(id), SubmissionServiceModel.class);
    }
}
