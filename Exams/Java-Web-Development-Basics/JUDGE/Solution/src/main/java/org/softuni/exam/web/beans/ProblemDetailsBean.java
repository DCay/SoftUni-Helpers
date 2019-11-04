package org.softuni.exam.web.beans;

import org.modelmapper.ModelMapper;
import org.softuni.exam.domain.entities.Problem;
import org.softuni.exam.domain.models.service.ProblemServiceModel;
import org.softuni.exam.domain.models.service.SubmissionServiceModel;
import org.softuni.exam.domain.models.view.DetailsProblemSubmissionViewModel;
import org.softuni.exam.domain.models.view.DetailsProblemViewModel;
import org.softuni.exam.service.ProblemService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;

@Named("problemDetailsBean")
@RequestScoped
public class ProblemDetailsBean extends BaseBean {
    private ProblemService problemService;

    private ModelMapper modelMapper;

    private DetailsProblemViewModel detailsProblemViewModel;

    public ProblemDetailsBean() {
    }

    @Inject
    public ProblemDetailsBean(ProblemService problemService, ModelMapper modelMapper) {
        this.problemService = problemService;
        this.modelMapper = modelMapper;
    }

    private double getProblemSuccessRate(int totalProblemResult, List<DetailsProblemSubmissionViewModel> submissions) {
        // This is intentionally broken (with educational purposes)+

        return ((double)submissions.stream()
                .filter(s -> s.getAchievedResult() == totalProblemResult).count() / submissions.size()) * 100;
    }

    @PostConstruct
    public void init() {
        String problemId = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("id");
        ProblemServiceModel problem = this.problemService.getProblemById(problemId);
        this.detailsProblemViewModel =
                this.modelMapper.map(problem, DetailsProblemViewModel.class);

        this.detailsProblemViewModel.setSuccessRate(this.getProblemSuccessRate(this.detailsProblemViewModel.getPoints(), this.detailsProblemViewModel.getSubmissions()));
    }

    public DetailsProblemViewModel getDetailsProblemViewModel() {
        return this.detailsProblemViewModel;
    }

    public void setDetailsProblemViewModel(DetailsProblemViewModel detailsProblemViewModel) {
        this.detailsProblemViewModel = detailsProblemViewModel;
    }
}
