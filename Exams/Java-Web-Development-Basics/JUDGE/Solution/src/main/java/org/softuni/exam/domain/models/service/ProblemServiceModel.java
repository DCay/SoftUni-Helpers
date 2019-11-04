package org.softuni.exam.domain.models.service;

import java.util.ArrayList;
import java.util.List;

public class ProblemServiceModel {
    private String id;

    private String name;

    private int points;

    private List<SubmissionServiceModel> submissions;

    public ProblemServiceModel() {
        this.submissions = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<SubmissionServiceModel> getSubmissions() {
        return this.submissions;
    }

    public void setSubmissions(List<SubmissionServiceModel> submissions) {
        this.submissions = submissions;
    }
}
