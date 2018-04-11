
Feature: ${featureDescription}
    Scenario: ${scenarioDescription}
        <#--Given variable [name] is "[value]"-->
<#assign i = 0>
<#list scenarioSteps as step >
<#switch step.communicationProtocol.name() >
    <#case "JMS">
    sir
        <#break>
    <#case "HTTP_REST">
    <#--<#if i == 0>-->
    <#if step?index == 0>
        Given http-client "votingClient"
        Given URL: ${step.endpointUrl}
        Given variable id is "citrus:randomUUID()"
    </#if>
    <#if step.stepType == "ACTION" >
        <#if step.requestBody?? && step.requestBody?length &gt; 5>
        And Payload:
        """
        ${step.requestBody}
        """
        </#if>
        <#if step.contentType?? && step.contentType?length &gt; 5>
        And Content-Type: ${step.contentType}
        </#if>
        <#if step.requestHeaders??>
            <#list step.requestHeaders?keys as prop>
            And Header ${prop}: ${step.requestHeaders.get(prop)}
            </#list>
        </#if>
        When send ${step.httpMethod} ${step.contextPath}
    <#elseif step.stepType == "VALIDATION" >
        Then receives status ${step.httpStatusCode}
    </#if>
    <#--</#if>-->
    <#break>
    <#case "HTTP_SOAP">
    <#break>
    <#case "FTP">
    <#break>
    <#case "MAIL">
    <#break>
    <#default>
    sir/madam
</#switch>
</#list>