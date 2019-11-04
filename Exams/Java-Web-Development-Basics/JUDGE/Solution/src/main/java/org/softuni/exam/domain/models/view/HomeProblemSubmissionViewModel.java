package org.softuni.exam.domain.models.view;

public class HomeProblemSubmissionViewModel {
    private String userUsername;

    private int achievedResult;

    public HomeProblemSubmissionViewModel() {
    }

    public String getUserUsername() {
        return this.userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public int getAchievedResult() {
        return this.achievedResult;
    }

    public void setAchievedResult(int achievedResult) {
        this.achievedResult = achievedResult;
    }
}
