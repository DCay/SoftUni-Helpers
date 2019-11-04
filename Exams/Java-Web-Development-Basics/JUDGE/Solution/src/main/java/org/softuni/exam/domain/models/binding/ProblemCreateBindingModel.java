package org.softuni.exam.domain.models.binding;

public class ProblemCreateBindingModel {
    private String name;

    private int points;

    public ProblemCreateBindingModel() {
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
}
