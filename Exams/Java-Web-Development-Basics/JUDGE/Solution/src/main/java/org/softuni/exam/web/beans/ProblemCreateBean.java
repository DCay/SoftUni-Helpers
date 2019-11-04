package org.softuni.exam.web.beans;

import org.modelmapper.ModelMapper;
import org.softuni.exam.domain.models.binding.ProblemCreateBindingModel;
import org.softuni.exam.domain.models.binding.UserRegisterBindingModel;
import org.softuni.exam.domain.models.service.ProblemServiceModel;
import org.softuni.exam.domain.models.service.UserServiceModel;
import org.softuni.exam.service.ProblemService;
import org.softuni.exam.service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("problemCreateBean")
@RequestScoped
public class ProblemCreateBean extends BaseBean {
    private ProblemCreateBindingModel problemCreateBindingModel;

    private ProblemService problemService;

    private ModelMapper modelMapper;

    public ProblemCreateBean() {
    }

    @Inject
    public ProblemCreateBean(ProblemService problemService, ModelMapper modelMapper) {
        this.problemService = problemService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        this.problemCreateBindingModel = new ProblemCreateBindingModel();
    }

    public ProblemCreateBindingModel getProblemCreateBindingModel() {
        return this.problemCreateBindingModel;
    }

    public void setProblemCreateBindingModel(ProblemCreateBindingModel problemCreateBindingModel) {
        this.problemCreateBindingModel = problemCreateBindingModel;
    }

    public void create() {
        this.problemService.createProblem(
                this.modelMapper.map(this.problemCreateBindingModel, ProblemServiceModel.class));
        this.redirect("/home");
    }
}
