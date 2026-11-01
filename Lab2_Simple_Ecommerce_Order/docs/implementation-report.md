# Lab 2 — Implementation Report

## Objective
Build an end-to-end Camunda 8 e-commerce order workflow that validates an order, checks stock, determines delivery priority using DMN, processes a simulated payment, and routes exceptions for human review.

## Architecture
The customer submits the order form. The Java `validate-order` worker checks required fields and calculates the order total. The `check-inventory` worker checks synthetic stock. A DMN decision determines delivery priority from order value, customer category and delivery preference. The mock payment REST API returns SUCCESS or DECLINED. A Tasklist user task handles high-value/manual verification. Operate is used to inspect process instances and incidents.

## Execution flow
Order form → validate order → stock check → priority DMN → manual verification if high-value → mock payment REST API → payment gateway → fulfilment or non-fulfilment end.

## Test results
Complete `test-cases.csv` after running all five scenarios. Record actual outcomes and Pass/Fail only after checking Operate and Tasklist.

## Evidence to capture from your own environment
1. BPMN diagram in Camunda Modeler.
2. DMN priority table and sample evaluations.
3. Deployed BPMN and DMN definitions.
4. Tasklist high-value manual-verification task and completion.
5. Operate process instances and variables.
6. Operate payment-service incident and successful retry.

## Assumptions and limitations
All customer, order and payment data is synthetic. The payment service is a local mock and does not process real payments. Inventory is simulated in the Java worker: product IDs ending in `-LOW` have one unit; other products have 100 units. Delivery-priority and manual-review thresholds are educational assumptions. Connector configuration and actual execution must be verified in the user's Camunda 8 environment.
