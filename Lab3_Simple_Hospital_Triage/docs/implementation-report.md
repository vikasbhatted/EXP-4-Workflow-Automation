# Implementation report – Lab 3

## Objective
Build an end-to-end educational hospital appointment workflow that validates a synthetic patient request, classifies its urgency using DMN, checks appointment availability through a mock scheduling service, and routes exceptional cases to staff.

## Architecture
- Camunda 8 BPMN process: orchestration and routing.
- DMN decision: Routine, Priority Review, or Urgent Assessment.
- Spring Boot workers: registration validation, appointment availability request, booking record.
- Python mock API: returns synthetic slots, no-slot result, or simulated HTTP 503 failure.
- Tasklist: staff assessment and no-slot review.
- Operate: process-instance and incident monitoring.

## Assumptions and limitations
- All patient references and symptoms are synthetic.
- Triage rules are educational examples, not clinical guidance.
- Appointment slots are fixed mock values and are not connected to a real hospital.
- Staff decisions are simulated using Tasklist forms.
- Actual results, deployment evidence, Tasklist screenshots, and Operate incident-recovery screenshots must be added after running the workflow.
- The BPMN/DMN files include diagram layout and should be visually checked in the installed Camunda Modeler. Runtime deployment and worker compatibility have not been verified in this package.

## Results
Complete `docs/test-cases.csv` after executing each scenario. Do not mark a test as passed until the corresponding process instance has been observed in Tasklist/Operate.
