package org.softuni.exam.domain.models.view;

import java.util.List;

public class HomeProblemViewModel {
    private String id;

    private String name;

    private int points;

    private double completedPercentage;

    private List<HomeProblemSubmissionViewModel> submissions;

    public HomeProblemViewModel() {
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

    public double getCompletedPercentage() {
        return this.completedPercentage;
    }

    public void setCompletedPercentage(double completedPercentage) {
        this.completedPercentage = completedPercentage;
    }

    public List<HomeProblemSubmissionViewModel> getSubmissions() {
        return this.submissions;
    }

    public void setSubmissions(List<HomeProblemSubmissionViewModel> submissions) {
        this.submissions = submissions;
    }

    public String getFormattedCompletedPercentage() {
        return String.format("%.2f", this.getCompletedPercentage());
    }
}
