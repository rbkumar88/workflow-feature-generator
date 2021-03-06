# workflow-feature-generator
==============

The sample uses a JSON request to generate/setup a workflow which in turn generates a Cucumber feature file and immediately invoke ```mvn verify``` to run the same. The tests combine BDD feature stories with the famous 
Gherkin syntax and Citrus integration test capabilities. 

Build
-------
```mvn clean install``` 

The above step will complete with 0 tests
 
Run
---------
```mvn spring:boot run``` or ```java -jar target/workflow-feature-generator-0.0.1-SNAPSHOT.jar```

Pre-requisite
---------
In order to test the same, the [demo-service](../../../demo-service/) jar which must have been installed into your local maven repository using `mvn clean install` and be running too beforehand.

Swagger url
----------
The service also exposes a Swagger API documentation endpoint at /v2/api-docs. This can also be used to import into Postman as a collection.

http://localhost:8080/swagger-ui.html

Running the below request under /workflow/add will create a feature file with name as given in "featureName" value and run the scenarios in the feature file.

```
{
  "featureDescription": "feature description",
  "featureName": "test",
  "scenarioDescription": "scenario description",
  "scenarioSteps": [
    {
      "additionalParams": {},
      "communicationProtocol": "HTTP_REST",
      "contentType": "",
      "context": "string",
      "contextPath": "/test",
      "contextVariables": {},
      "endpointUrl": "http://localhost:8181/",
      "httpMethod": "GET",
      "stepType": "ACTION"
    },
{
      "additionalParams": {},
      "communicationProtocol": "HTTP_REST",
      "contentType": "application/json",
      "context": "string",
      "contextPath": "/test",
      "contextVariables": {},
      "endpointUrl": "http://localhost:8181/",
      "httpStatusCode": 200,
      "responseBody": "string",
      "schemaLocation": "string",
      "stepType": "VALIDATION"
    }
  ]
}
```
TO-DO (in the order of importance)
-------
* Currently works with dynamic creation of HttpClient, but need to read the endpoint url and bean name/id from properties/cucumber file- TBD
* Separate out generating feature file creation and actual test run
* Email notification on test failure
* Currently works only for HTTP_REST protocol.Implement the same for other communication protocols like JMS,HTTP_SOAP etc.

Further information
---------

For more information on Citrus see [www.citrusframework.org][2], including
a complete [reference manual][3].

 [1]: https://www.citrusframework.org/img/brand-logo.png "Citrus"
 [2]: https://www.citrusframework.org
 [3]: https://www.citrusframework.org/reference/html/
 [4]: https://www.citrusframework.org/reference/html#cucumber
 [5]: https://github.com/rbkumar88/workflow-feature-generator/blob/master/src/test/java/com/workflow/CitrusEndpointConfig.java#L15
