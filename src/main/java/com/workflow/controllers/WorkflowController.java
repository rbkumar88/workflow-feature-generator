package com.workflow.controllers;

import com.workflow.domain.Workflow;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/workflow")
@Api(value="workflow", description="Cucumber feature generator from Workflow")
public class WorkflowController {


    @ApiOperation(value = "Add a workflow")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveProduct(@RequestBody Workflow workflow){
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
        try {
            //Load template from source folder
            cfg.setDirectoryForTemplateLoading(new File("src/main/resources/"));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setLocale(Locale.US);

            Template template = cfg.getTemplate("feature-file-generator.ftl");

                Writer file = null;
                Map<String, Object> root = new HashMap<String, Object>();
                root.put( "scenarioSteps", workflow.getScenarioSteps() );
                root.put( "featureDescription", workflow.getFeatureDescription() );
                root.put( "scenarioDescription", workflow.getScenarioDescription() );
                try {
                    file = new FileWriter(new File("src/test/resources/features/"+workflow.getFeatureName()+".feature"));
                    template.process(workflow, file);
                    file.flush();
                    file.close();
                    try {
                        InvocationRequest request = new DefaultInvocationRequest();
                        request.setPomFile(new File("pom.xml"));
                        request.setGoals(Arrays.asList("verify"));

                        Invoker invoker = new DefaultInvoker();
                        invoker.execute(request);
                    }catch(org.apache.maven.shared.invoker.MavenInvocationException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TemplateException e) {
                    e.printStackTrace();
                }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity("Cucumber feature created successfully", HttpStatus.OK);
    }


}
