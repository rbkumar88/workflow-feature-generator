package com.workflow.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class Workflow {
    @ApiModelProperty(notes = "Feature file name",required = true)
    private String featureName;
    @ApiModelProperty(notes = "Feature description",required = true)
    private String featureDescription;
    @ApiModelProperty(notes = "Scenario description",required = true)
    private String scenarioDescription;
    @ApiModelProperty(notes = "Scenario steps",required = true)
    private List<WorkflowStep> scenarioSteps;
}
