package org.softuni.exam.domain.models.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class DetailsSubmissionViewModel {
    private String id;

    private String problemName;

    private String userUsername;

    private String code;

    private int achievedResult;

    private int problemPoints;

    private LocalDateTime createdOn;

    public DetailsSubmissionViewModel() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProblemName() {
        return this.problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    public String getUserUsername() {
        return this.userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
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

    public int getProblemPoints() {
        return this.problemPoints;
    }

    public void setProblemPoints(int problemPoints) {
        this.problemPoints = problemPoints;
    }

    public LocalDateTime getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public List<String> getCodeLines() {
        return Arrays.asList(this.getCode().split("\r\n"));
    }

    public String getFormattedCreatedOn() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return this.createdOn.format(formatter);
    }
}
