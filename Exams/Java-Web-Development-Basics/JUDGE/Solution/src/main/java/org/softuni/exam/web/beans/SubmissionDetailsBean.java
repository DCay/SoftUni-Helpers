package org.softuni.exam.web.beans;

import org.modelmapper.ModelMapper;
import org.softuni.exam.domain.models.service.SubmissionServiceModel;
import org.softuni.exam.domain.models.view.DetailsSubmissionViewModel;
import org.softuni.exam.service.SubmissionService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named("submissionDetailsBean")
@RequestScoped
public class SubmissionDetailsBean extends BaseBean {
    private DetailsSubmissionViewModel detailsSubmissionViewModel;

    private SubmissionService submissionService;

    private ModelMapper modelMapper;

    public SubmissionDetailsBean() {
    }

    @Inject
    public SubmissionDetailsBean(SubmissionService submissionService, ModelMapper modelMapper) {
        this.submissionService = submissionService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        String submissionId = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("id");
        this.detailsSubmissionViewModel =
                this.modelMapper.map(
                    this.submissionService.getSubmissionById(submissionId),
                    DetailsSubmissionViewModel.class);
    }

    public DetailsSubmissionViewModel getDetailsSubmissionViewModel() {
        return this.detailsSubmissionViewModel;
    }

    public void setDetailsSubmissionViewModel(DetailsSubmissionViewModel detailsSubmissionViewModel) {
        this.detailsSubmissionViewModel = detailsSubmissionViewModel;
    }
}
