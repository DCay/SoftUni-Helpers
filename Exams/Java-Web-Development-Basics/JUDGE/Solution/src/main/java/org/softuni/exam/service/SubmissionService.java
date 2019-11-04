package org.softuni.exam.service;

import org.softuni.exam.domain.models.service.SubmissionServiceModel;

public interface SubmissionService {
    SubmissionServiceModel createSubmission(SubmissionServiceModel submissionServiceModel);

    SubmissionServiceModel getSubmissionById(String id);
}
