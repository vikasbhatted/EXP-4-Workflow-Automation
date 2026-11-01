# Lab 3 – End-to-End Hospital Appointment and Patient Triage Management

## 1. Objective

To develop a hospital appointment workflow using Camunda 8. The workflow registers a synthetic patient, applies predefined educational triage rules, checks appointment availability, routes cases for staff review and supports monitoring and incident recovery.

## 2. Workflow Description

The workflow follows these steps:

1. Patient submits registration details, appointment preference, symptoms summary and urgency indicators.
2. Java worker validates the patient registration.
3. The workflow checks whether the registration is valid.
4. A DMN decision table classifies the request into Routine, Priority Review or Urgent Assessment.
5. Urgent Assessment requests are routed to an immediate staff assessment task.
6. Priority Review requests are routed to a priority staff review task.
7. Routine requests proceed to appointment availability checking.
8. The mock hospital scheduling API returns available appointment slots.
9. An exclusive gateway checks whether a suitable appointment slot is available.
10. If a slot is available, the workflow records the appointment booking.
11. If no suitable slot is available, the request is routed to staff review.

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
Lab-3-Hospital-Triage/
│
├── README.md
├── bpmn/
│   └── hospital-appointment.bpmn
├── dmn/
│   └── patient-triage.dmn
├── forms/
│   ├── patient-registration.form
│   └── staff-triage-review.form
├── worker/
│   ├── pom.xml
│   └── src/
│       └── main/
│           ├── java/
│           └── resources/
│               └── application.yaml
├── mock-api/
│   └── mock_scheduling_api.py
├── docs/
│   ├── rest-connector-setup.md
│   ├── process-variables.md
│   ├── dmn-rules.md
│   ├── test-cases.csv
│   └── implementation-report.md
└── screenshots/
```

## 5. DMN Decision Rules

The DMN decision table classifies patient requests into three categories:

- Routine
- Priority Review
- Urgent Assessment

The decision uses two predefined educational indicators:

- urgentIndicator
- priorityIndicator

The decision table uses the FIRST hit policy.

These rules are simplified for educational workflow demonstration and are not clinical triage guidelines.

## 6. External Job Workers

Java Spring Boot workers perform the following operations:

- Validate patient registration details.
- Request appointment availability from the mock scheduling API.
- Record the appointment booking outcome.

## 7. REST API Integration

A mock hospital scheduling API is used to retrieve synthetic appointment slots.

The API supports:

- Successful appointment availability response.
- No available appointment slots.
- Simulated HTTP 503 service failure.

No real hospital or patient information is used.

## 8. Test Scenarios

| Test | Scenario | Expected Result |
|---|---|---|
| T1 | Routine request with an available slot | Appointment booked |
| T2 | Priority indicator enabled | Priority staff review |
| T3 | Urgent indicator enabled | Immediate staff assessment |
| T4 | No appointment slots available | Staff review |
| T5 | Scheduling API failure | Incident and recovery |

Actual results will be updated after execution.

## 9. Screenshots

Implementation screenshots are stored in the `screenshots/` folder.

They include:

- BPMN process diagram
- DMN triage decision table
- Patient registration form
- Staff review form

## 10. Limitations

- All patient information is synthetic.
- Triage rules are simplified educational examples and are not intended for real medical decisions.
- Appointment availability is simulated using a mock API.
- The appointment slots are not connected to a real hospital scheduling system.
- Actual results depend on successful deployment and execution in Camunda 8.

## 11. Conclusion

This project demonstrates how Camunda 8 can automate a hospital appointment workflow using BPMN, DMN, Java Spring Boot workers, REST API integration, process variables, gateways and human staff intervention.
