# workflow-feature-generator
==============

The sample uses a JSON request to generate/setup a workflow which in turn generates a Cucumber feature file and immediately invoke ```mvn verify``` to run the same. The tests combine BDD feature stories with the famous 
Gherkin syntax and Citrus integration test capabilities. 
 
Run
---------
```mvn spring:boot run```

Swagger url
----------
http://localhost:8080/swagger-ui.html

Get started
---------
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
      "httpStatusCode": 400,
      "requestBody": "",
      "requestHeaders": {},
      "responseBody": "string",
      "schemaLocation": "string",
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
      "httpMethod": "GET",
      "httpStatusCode": 200,
      "requestBody": "",
      "requestHeaders": {},
      "responseBody": "string",
      "schemaLocation": "string",
      "stepType": "VALIDATION"
    }
  ]
}
```


Further information
---------

For more information on Citrus see [www.citrusframework.org][2], including
a complete [reference manual][3].

 [1]: https://www.citrusframework.org/img/brand-logo.png "Citrus"
 [2]: https://www.citrusframework.org
 [3]: https://www.citrusframework.org/reference/html/
 [4]: https://www.citrusframework.org/reference/html#cucumber
