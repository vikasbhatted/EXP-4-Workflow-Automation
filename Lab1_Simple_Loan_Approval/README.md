# Lab 1 – End-to-End Loan Approval Automation

## 1. Objective

To develop an end-to-end loan approval workflow using Camunda 8. The workflow combines BPMN orchestration, DMN-based decision-making, Java Spring Boot external job workers, REST API integration, process variables and human review.

## 2. Workflow Description

The workflow follows these steps:

1. Applicant submits loan application details.
2. Java worker validates applicant information.
3. The workflow checks whether the application is valid.
4. A mock credit assessment API retrieves synthetic credit information.
5. A DMN decision table evaluates the application.
6. An exclusive gateway routes the application based on the decision.
7. Approved applications proceed to approval.
8. Rejected applications are sent to the rejection end event.
9. Applications requiring additional verification are sent to a manual review task in Tasklist.

## 3. Technologies Used

- Camunda 8
- BPMN 2.0
- DMN
- Java
- Spring Boot
- Maven
- REST API
- Python
- Camunda Tasklist and Operate

## 4. Project Structure

```text
Lab-1-Loan-Approval/
│
├── README.md
├── bpmn/
│   └── loan-approval.bpmn
├── dmn/
│   └── loan-decision.dmn
├── forms/
│   ├── loan-application.form
│   └── manual-review.form
├── worker/
│   ├── pom.xml
│   └── src/
│       └── main/
│           ├── java/
│           └── resources/
│               └── application.yaml
├── mock-api/
│   └── mock_credit_api.py
├── docs/
│   ├── rest-connector-setup.md
│   ├── process-variables.md
│   ├── test-cases.csv
│   └── implementation-report.md
└── screenshots/
```

## 5. DMN Decision Rules

The DMN decision table classifies loan applications into three outcomes:

- Approved
- Rejected
- Manual Review

The educational rules use monthly income, loan-to-income multiple, credit score and debt-to-income ratio.

## 6. External Job Workers

Java Spring Boot workers are used to:

- Validate applicant information.
- Calculate relevant financial ratios.
- Record the loan decision outcome.

## 7. REST API Integration

A mock credit assessment API is used to retrieve synthetic credit information.

The mock API supports successful responses and simulated service failures for testing.

## 8. Test Scenarios

| Test | Scenario | Expected Result |
|---|---|---|
| T1 | Applicant meets approval criteria | Approved |
| T2 | Applicant fails eligibility criteria | Rejected |
| T3 | Applicant requires additional verification | Manual Review |
| T4 | Credit API failure | Incident / recovery |
| T5 | Worker failure | Incident / recovery |

Actual results will be updated after execution.

## 9. Screenshots

Implementation screenshots are stored in the `screenshots/` folder.

They include:

- BPMN process diagram
- DMN decision table
- Application forms
- Deployment evidence
- Workflow execution
- Tasklist manual review
- Operate monitoring
- Incident recovery

## 10. Limitations

- Credit assessment uses synthetic data.
- The decision rules are educational examples and are not intended for real loan approval.
- The credit API is a mock service.
- Actual test results depend on the Camunda 8 runtime and worker execution.

## 11. Conclusion

This project demonstrates how Camunda 8 can automate a loan approval process by combining BPMN workflows, DMN decisions, Java workers, REST integration and human intervention.
