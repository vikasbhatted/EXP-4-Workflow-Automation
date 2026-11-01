# Lab 2 – End-to-End E-Commerce Order Processing and Fulfilment

## 1. Objective

To develop an automated e-commerce order-processing workflow using Camunda 8. The workflow validates customer orders, checks inventory, determines order priority using DMN, processes simulated payments and routes orders to fulfilment or manual verification.

## 2. Workflow Description

The workflow follows these steps:

1. Customer submits an order with customer reference, product ID, quantity, delivery preference and payment token.
2. Java worker validates the order and calculates the total amount.
3. The workflow checks whether the order details are valid.
4. Inventory availability is checked using a Java external job worker.
5. An exclusive gateway checks whether sufficient stock is available.
6. A DMN decision table determines the delivery priority.
7. High-value orders are routed for manual verification through Tasklist.
8. The mock payment API processes the payment request.
9. An exclusive gateway checks the payment result.
10. Successful payments proceed to fulfilment.
11. Orders with insufficient stock or declined payments cannot proceed to fulfilment.

## 3. Technologies Used

- Camunda 8
- BPMN 2.0
- DMN
- Java
- Spring Boot
- Maven
- REST API
- Python
- Camunda Tasklist
- Camunda Operate

## 4. Project Structure

```text
Lab-2-Ecommerce-Order/
│
├── README.md
├── bpmn/
│   └── order-processing.bpmn
├── dmn/
│   └── order-priority.dmn
├── forms/
│   ├── order-submission.form
│   └── manual-verification.form
├── worker/
│   ├── pom.xml
│   └── src/
│       └── main/
│           ├── java/
│           └── resources/
│               └── application.yaml
├── mock-api/
│   └── mock_payment_api.py
├── docs/
│   ├── rest-connector-setup.md
│   ├── process-variables.md
│   ├── dmn-rules.md
│   ├── test-cases.csv
│   └── implementation-report.md
└── screenshots/
```

## 5. DMN Decision Rules

The DMN decision table determines delivery priority using:

- Order total
- Customer category
- Delivery preference

The possible outputs are:

- High
- Standard

The decision table uses the FIRST hit policy.

## 6. External Job Workers

Java Spring Boot workers perform the following operations:

- Validate order details.
- Calculate the order total.
- Check simulated inventory availability.
- Record the final fulfilment outcome.

## 7. REST API Integration

A mock payment API is used to simulate payment processing.

Test payment tokens:

| Token | Expected response |
|---|---|
| TEST-OK | SUCCESS |
| TEST-DECLINED | DECLINED |

The mock API also supports simulated HTTP 503 failures for incident-recovery testing.

No real payment credentials are used.

## 8. Test Scenarios

| Test | Scenario | Expected Result |
|---|---|---|
| T1 | Stock available and payment successful | Order proceeds to fulfilment |
| T2 | Insufficient stock | Order cannot proceed to fulfilment |
| T3 | Payment declined | Order payment is rejected |
| T4 | High-value order | Manual verification through Tasklist |
| T5 | Payment API failure | Incident and recovery |

Actual results will be updated after execution.

## 9. Screenshots

Implementation screenshots are stored in the `screenshots/` folder.

They include:

- BPMN process diagram
- DMN priority decision table
- Order submission form
- Manual verification form
- Deployment evidence
- Successful order execution
- Insufficient stock scenario
- Payment declined scenario
- Tasklist manual verification
- Operate monitoring
- Incident recovery

## 10. Limitations

- Inventory information is simulated.
- Payment processing uses a mock API.
- No real customer payment information is used.
- Delivery priority rules are educational examples.
- Actual test results depend on successful deployment and execution in Camunda 8.

## 11. Conclusion

This project demonstrates how Camunda 8 can automate an e-commerce order-processing workflow using BPMN, DMN, Java Spring Boot workers, REST API integration, exclusive gateways and human verification.
