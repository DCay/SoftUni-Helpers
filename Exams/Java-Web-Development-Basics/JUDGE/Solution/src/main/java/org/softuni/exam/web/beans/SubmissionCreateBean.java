package org.softuni.exam.web.beans;

import org.modelmapper.ModelMapper;
import org.softuni.exam.domain.models.binding.ProblemCreateBindingModel;
import org.softuni.exam.domain.models.binding.SubmissionCreateBindingModel;
import org.softuni.exam.domain.models.service.ProblemServiceModel;
import org.softuni.exam.domain.models.service.SubmissionServiceModel;
import org.softuni.exam.domain.models.service.UserServiceModel;
import org.softuni.exam.service.ProblemService;
import org.softuni.exam.service.SubmissionService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Named("submissionCreateBean")
@RequestScoped
public class SubmissionCreateBean extends BaseBean {
    private SubmissionCreateBindingModel submissionCreateBindingModel;

    private ProblemServiceModel problem;

    private SubmissionService submissionService;

    private ProblemService problemService;

    private ModelMapper modelMapper;

    public SubmissionCreateBean() {
    }

    @Inject
    public SubmissionCreateBean(SubmissionService submissionService, ProblemService problemService, ModelMapper modelMapper) {
        this.submissionService = submissionService;
        this.problemService = problemService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        this.submissionCreateBindingModel = new SubmissionCreateBindingModel();

        String problemId = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("id");
        this.problem = this.problemService.getProblemById(problemId);
    }

    public SubmissionCreateBindingModel getSubmissionCreateBindingModel() {
        return this.submissionCreateBindingModel;
    }

    public void setSubmissionCreateBindingModel(SubmissionCreateBindingModel submissionCreateBindingModel) {
        this.submissionCreateBindingModel = submissionCreateBindingModel;
    }

    public ProblemServiceModel getProblem() {
        return this.problem;
    }

    public void setProblem(ProblemServiceModel problem) {
        this.problem = problem;
    }

    public void create() {
        String problemId = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("id");
        String userId = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user-id").toString();

        SubmissionServiceModel submissionServiceModel = this.modelMapper.map(this.submissionCreateBindingModel, SubmissionServiceModel.class);

        submissionServiceModel.setProblem(new ProblemServiceModel());
        submissionServiceModel.setUser(new UserServiceModel());

        submissionServiceModel.getProblem().setId(problemId);
        submissionServiceModel.getUser().setId(userId);

        submissionServiceModel.setCreatedOn(LocalDateTime.now());

        this.submissionService.createSubmission(submissionServiceModel);

        this.redirect("/home");
    }
}
