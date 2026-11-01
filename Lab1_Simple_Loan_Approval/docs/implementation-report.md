# Lab 1 — Implementation Report

## Objective
Create an end-to-end Camunda 8 loan approval process using BPMN, DMN, a Java/Spring Boot worker, a mock REST credit service, process variables, a Tasklist human task, and Operate monitoring.

## Architecture
The applicant submits a form. The `validate-applicant` Java worker checks the form and calculates loan-to-income and debt-to-income ratios. An exclusive gateway ends invalid applications. Valid applications call a mock credit-assessment REST API. The DMN classifies the application as Approved, Rejected or Manual Review. Approved and rejected outcomes are recorded by the `record-loan-outcome` worker. Manual-review applications are assigned to `loan.reviewer` in Tasklist; the reviewer chooses Approved or Rejected.

## Execution flow
Applicant form → validation worker → validity gateway → mock credit REST API → DMN decision → decision gateway → approved / rejected / manual review → outcome recording → end.

## Test results
Complete `test-cases.csv` after running the five test scenarios. Enter actual outcomes and Pass/Fail based on Camunda execution.

## Evidence to capture
- BPMN model open in Camunda Modeler.
- DMN decision table and sample evaluations.
- Deployed BPMN and DMN.
- Tasklist manual-review task and completed task.
- Operate process instance with variables and activity states.
- Operate incident details and successful retry for REST failure.
- Operate incident details and successful retry for worker failure.

## Assumptions and limitations
All data is synthetic. The credit API is a local mock and does not connect to a credit bureau. The thresholds are educational examples only. Deployment, connector configuration, actual results and screenshots must be verified in the user's Camunda 8 environment. The REST Connector must be installed and enabled.
