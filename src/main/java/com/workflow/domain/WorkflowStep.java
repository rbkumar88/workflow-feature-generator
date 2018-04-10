package com.workflow.domain;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.HttpMethod;
import lombok.Data;

import java.util.Map;

@Data
public class WorkflowStep {
    @ApiModelProperty(notes = "Translates to \"Given\" in the feature file",required=true)
    private String context;
    @ApiModelProperty(notes = "Context Variables which are set at scenario/feature level (if any)")
    private Map<String,Object> contextVariables;
    @ApiModelProperty(name="Step Type", allowableValues = "ACTION,VALIDATION")
    private STEP_TYPE stepType;
    @ApiModelProperty(notes = "Request/Message body")
    private String requestBody;
    @ApiModelProperty(notes = "Request HTTP Method",allowableValues = "GET,POST,DELETE,PUT,PATCH,HEAD")
    private HttpMethod httpMethod;
    @ApiModelProperty(notes = "Response body")
    private String responseBody;
    @ApiModelProperty(notes = "Response HTTP STATUS Code",example ="400")
    private Integer httpStatusCode;
    @ApiModelProperty(notes = "Content Type mandatory")
    private String contentType;
    @ApiModelProperty(notes = "Endpoint URL",example = "http://localhost:8080/")
    private String endpointUrl;
    @ApiModelProperty(notes = "Context/Resource Path (if any)",example = "/test")
    private String contextPath;
    @ApiModelProperty(notes = "Schema Location (if any)")
    private String schemaLocation;
    @ApiModelProperty(notes = "Request Headers (if any)")
    private Map<String,Object> requestHeaders;
    @ApiModelProperty(name = "Communication Protocol", allowableValues = "JMS,HTTP_REST,HTTP_SOAP,FTP,MAIL")
    private COMMUNICATION_PROTOCOL communicationProtocol;
    @ApiModelProperty(notes = "Additional Params like queueName,queryParams (if any)")
    private Map<String,Object> additionalParams;
//    @ApiModelProperty(notes = "Scenario Completion flag (true/false), defaults to false")
//    private Boolean scenarioCompletion;
//    @ApiModelProperty(notes = "Feature Completion flag (true/false), defaults to false")
//    private Boolean featureCompletion;

    public enum COMMUNICATION_PROTOCOL {
        JMS,
        HTTP_REST,
        HTTP_SOAP,
        FTP,
        MAIL;
    }
    public enum STEP_TYPE {
        ACTION,
        VALIDATION
    }

}
