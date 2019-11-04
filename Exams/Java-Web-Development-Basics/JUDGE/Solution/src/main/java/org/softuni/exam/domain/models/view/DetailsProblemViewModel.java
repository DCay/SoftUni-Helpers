package org.softuni.exam.domain.models.view;

import java.util.List;

public class DetailsProblemViewModel {
    private String id;

    private String name;

    private int points;

    private double successRate;

    private List<DetailsProblemSubmissionViewModel> submissions;

    public DetailsProblemViewModel() {
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

    public double getSuccessRate() {
        return this.successRate;
    }

    public void setSuccessRate(double successRate) {
        this.successRate = successRate;
    }

    public List<DetailsProblemSubmissionViewModel> getSubmissions() {
        return this.submissions;
    }

    public void setSubmissions(List<DetailsProblemSubmissionViewModel> submissions) {
        this.submissions = submissions;
    }
}
