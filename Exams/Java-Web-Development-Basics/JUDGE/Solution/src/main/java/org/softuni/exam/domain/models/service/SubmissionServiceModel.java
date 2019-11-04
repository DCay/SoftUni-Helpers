package org.softuni.exam.domain.models.service;

import java.time.LocalDateTime;

public class SubmissionServiceModel {
    private String id;

    private String code;

    private int achievedResult;

    private LocalDateTime createdOn;

    private ProblemServiceModel problem;

    private UserServiceModel user;

    public SubmissionServiceModel() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAchievedResult() {
        return this.achievedResult;
    }

    public void setAchievedResult(int achievedResult) {
        this.achievedResult = achievedResult;
    }

    public LocalDateTime getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public ProblemServiceModel getProblem() {
        return this.problem;
    }

    public void setProblem(ProblemServiceModel problem) {
        this.problem = problem;
    }

    public UserServiceModel getUser() {
        return this.user;
    }

    public void setUser(UserServiceModel user) {
        this.user = user;
    }
}
