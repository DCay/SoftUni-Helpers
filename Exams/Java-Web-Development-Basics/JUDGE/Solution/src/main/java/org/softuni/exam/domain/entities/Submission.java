package org.softuni.exam.domain.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "submissions")
public class Submission {
    private String id;

    private String code;

    private int achievedResult;

    private LocalDateTime createdOn;

    private Problem problem;

    private User user;

    public Submission() {
    }

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(
            name = "uuid-string",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "code", nullable = false)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "achieved_result", nullable = false)
    public int getAchievedResult() {
        return this.achievedResult;
    }

    public void setAchievedResult(int achievedResult) {
        this.achievedResult = achievedResult;
    }

    @Column(name = "created_on", nullable = false)
    public LocalDateTime getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    @ManyToOne
    @JoinColumn(name = "problem_id", nullable = false)
    public Problem getProblem() {
        return this.problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
