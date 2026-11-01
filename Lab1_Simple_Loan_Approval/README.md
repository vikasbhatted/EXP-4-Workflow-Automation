# Lab 1 — End-to-End Loan Approval Automation

A small educational Camunda 8 implementation matching the Lab 1 assignment.

## Files
- `bpmn/loan-approval.bpmn` — process model
- `dmn/loan-decision.dmn` — Approved / Rejected / Manual Review decision
- `forms/loan-application.form` — applicant form
- `forms/manual-review.form` — reviewer form
- `worker/` — Java Spring Boot external job workers
- `mock-api/` — synthetic credit-assessment API
- `docs/` — variable list, rules, tests, report and run instructions

## Simple educational rules
1. Monthly income below INR 15,000 → Rejected.
2. Requested amount / monthly income above 60 → Rejected.
3. Credit score below 650 OR debt-to-income ratio above 0.40 → Manual Review.
4. Otherwise → Approved.

These rules are for coursework only, not real lending advice.

## Important setup notes
This project targets a local Camunda 8 self-managed environment with Zeebe gRPC at `localhost:26500`. Change the connection settings for your actual environment. The REST Connector must be installed and enabled. Its connector template and header configuration can differ by release; use `docs/rest-connector-setup.md` to configure it in Modeler.

The BPMN and DMN files include diagram interchange layout so they can be opened visually in Camunda Modeler. Validate them in your installed Modeler version before deployment.

## Run order
1. Start Camunda 8 locally.
2. Start the mock API: `python mock-api/mock_credit_api.py`.
3. Start the worker from `worker/`: `mvn spring-boot:run`.
4. In Camunda Modeler, open and deploy the DMN and BPMN (deploy the forms with them).
5. Start a process instance using the applicant form.
6. Use Tasklist for manual-review cases and Operate for monitoring and incident recovery.
7. Complete actual results and screenshots in `docs/` after running tests.

Do not submit placeholder screenshots. Capture evidence from your own Camunda environment.
