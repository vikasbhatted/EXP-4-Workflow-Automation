# REST Connector setup

The BPMN REST service task is intended to use the Camunda HTTP JSON REST Connector.

- Method: POST
- URL: `http://localhost:8081/api/credit-assessment`
- Header: `Content-Type: application/json`
- Request body fields: `applicantId`, `declaredCreditScore`
- Store response in process variable: `creditAssessment`

Start the mock API from the project root:
```bash
python mock-api/mock_credit_api.py
```

Example request:
```json
{"applicantId":"SYNTH-001","declaredCreditScore":720}
```
Example response:
```json
{"status":"SUCCESS","applicantId":"SYNTH-001","creditScore":720}
```

In Camunda Modeler, use the installed REST Connector template to configure the task. Connector versions can use different task-header keys. Map the response field `creditAssessment.creditScore` to the process variable `creditScore` before the DMN task. If the connector template uses a different response variable, update the DMN input expression accordingly. For failure testing, send `simulateFailure: true` in the request body; the mock API returns HTTP 503.
