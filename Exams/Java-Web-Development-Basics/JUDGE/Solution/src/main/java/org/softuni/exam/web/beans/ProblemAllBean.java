package org.softuni.exam.web.beans;

import org.modelmapper.ModelMapper;
import org.softuni.exam.domain.models.binding.ProblemCreateBindingModel;
import org.softuni.exam.domain.models.service.ProblemServiceModel;
import org.softuni.exam.domain.models.view.HomeProblemSubmissionViewModel;
import org.softuni.exam.domain.models.view.HomeProblemViewModel;
import org.softuni.exam.service.ProblemService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named("problemAllBean")
@RequestScoped
public class ProblemAllBean extends BaseBean {
    private ProblemService problemService;

    private ModelMapper modelMapper;

    private List<HomeProblemViewModel> problems;

    public ProblemAllBean() {
    }

    @Inject
    public ProblemAllBean(ProblemService problemService, ModelMapper modelMapper) {
        this.problemService = problemService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        String username = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username").toString();

        List<HomeProblemViewModel> problemViewModels = this.problemService.getAllProblems().stream().map(p -> this.modelMapper.map(p, HomeProblemViewModel.class)).collect(Collectors.toList());

        for (HomeProblemViewModel problemViewModel : problemViewModels) {
            double currentMax = 0;

            for (HomeProblemSubmissionViewModel submission : problemViewModel.getSubmissions()) {
                if (submission.getUserUsername().equals(username) && submission.getAchievedResult() > currentMax) {
                    currentMax = submission.getAchievedResult();
                }
            }

            problemViewModel.setCompletedPercentage((currentMax / problemViewModel.getPoints()) * 100);
        }

        this.setProblems(problemViewModels);
    }

    public List<HomeProblemViewModel> getProblems() {
        return this.problems;
    }

    public void setProblems(List<HomeProblemViewModel> problems) {
        this.problems = problems;
    }
}
