package org.softuni.exam.domain.models.view;

public class DetailsProblemSubmissionViewModel {
    private String id;

    private String userUsername;

    private int achievedResult;

    public DetailsProblemSubmissionViewModel() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAchievementPercentage(int totalResult) {
        return String.format("%.2f", (((double)this.achievedResult / totalResult) * 100));
    }
}
