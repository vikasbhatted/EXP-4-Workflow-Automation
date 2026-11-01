# Lab 2 — End-to-End E-Commerce Order Processing and Fulfilment

Simple educational Camunda 8 implementation based on Lab 2 in the supplied PBJ-2 assignment.

## Included
- `bpmn/order-processing.bpmn` — order-processing workflow
- `dmn/order-priority.dmn` — priority decision table
- `forms/order-submission.form` — customer order form
- `forms/manual-verification.form` — manual review form
- `worker/` — Java/Spring Boot workers for validation, inventory and outcome recording
- `mock-api/` — synthetic payment service
- `docs/` — variable dictionary, DMN rules, REST example, test cases and implementation report

## Simple educational rules
Order priority uses order value, customer category and delivery preference:
- Premium customer + Express → High
- Order value at least INR 50,000 → High
- Express delivery → High
- Otherwise → Standard

High-priority orders that meet the high-value/exception condition are routed to Tasklist for manual verification. These are coursework rules, not commercial payment or fulfilment policies.

## Run order
1. Start your local Camunda 8 runtime (C8Run).
2. Start the mock payment API: `python mock-api/mock_payment_api.py`.
3. Configure Camunda connection in `worker/src/main/resources/application.yaml`.
4. From `worker/`, run `mvn spring-boot:run`.
5. Open BPMN and DMN in Camunda Modeler and deploy them with the forms.
6. Run the five scenarios in `docs/test-cases.csv`.
7. Inspect instances and incidents in Operate; complete manual verification in Tasklist.

The REST Connector must be installed/enabled in your Camunda 8 environment. Connector template headers can vary by release; use `docs/rest-connector-setup.md` to configure it in Modeler. Capture genuine screenshots from your own environment; no placeholder evidence is included.
