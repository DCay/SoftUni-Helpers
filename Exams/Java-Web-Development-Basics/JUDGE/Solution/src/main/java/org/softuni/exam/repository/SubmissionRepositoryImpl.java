package org.softuni.exam.repository;

import org.softuni.exam.domain.entities.Problem;
import org.softuni.exam.domain.entities.Submission;
import org.softuni.exam.domain.entities.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class SubmissionRepositoryImpl extends BaseRepository implements SubmissionRepository {
    @Inject
    protected SubmissionRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Submission save(Submission submission) {
        return this.executeTransaction((em) -> {
            Problem problem = (Problem) em.createNativeQuery("SELECT * FROM problems WHERE id = '" + submission.getProblem().getId() + "'", Problem.class).getSingleResult();

            User user = (User) em.createNativeQuery("SELECT * FROM users WHERE id = '" + submission.getUser().getId() + "'", User.class).getSingleResult();

            submission.setUser(user);
            submission.setProblem(problem);
            submission.setAchievedResult((int)Math.round(Math.random() * problem.getPoints()));

            em.refresh(user);
            em.refresh(problem);
            em.persist(submission);
            return submission;
        });
    }

    @Override
    public List<Submission> findAll() {
        return this.executeTransaction((em) -> {
            return em.createNativeQuery("SELECT * FROM submissions", Submission.class)
                    .getResultList();
        });
    }

    @Override
    public Submission findById(String id) {
        return this.executeTransaction((em) -> {
            return (Submission) em.createNativeQuery("SELECT * FROM submissions WHERE id = '" + id + "'", Submission.class)
                    .getSingleResult();
        });
    }
}
