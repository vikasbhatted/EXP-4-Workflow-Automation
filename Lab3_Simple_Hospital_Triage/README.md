# Lab 3 – Hospital Appointment and Patient Triage Management

A simple educational Camunda 8 implementation using synthetic patient data. It is not a clinical triage system and must not be used for real medical decisions.

## Included
- BPMN workflow and DMN triage decision table
- Start and staff-review forms
- Java/Spring Boot external job workers
- Mock hospital scheduling API (Python standard library)
- REST Connector setup, process-variable dictionary, test cases and report

## Suggested order
1. Open `bpmn/hospital-appointment.bpmn` in Camunda Modeler.
2. Open `dmn/patient-triage.dmn` and inspect the three educational outcomes.
3. Review the forms and documentation.
4. Start the mock API: `python mock-api/mock_scheduling_api.py`
5. Configure the REST Connector as described in `docs/rest-connector-setup.md`.
6. Configure the worker using `worker/src/main/resources/application.yaml`, then build with `mvn clean package`.
7. Deploy and test only after your C8Run/Camunda 8 runtime is running.

## Important
- The mock API uses fictional data and returns synthetic appointment slots.
- `PATIENT-URGENT` is an educational test reference that returns an urgent indicator; it is not a real patient.
- A simulated API failure can be triggered with `simulateFailure: true`.
- Fill the Actual Result column in `docs/test-cases.csv` only after you run each test.
- Capture your own Tasklist and Operate screenshots. No screenshots are fabricated or included.
- BPMN/DMN XML is provided with diagram layout. Deployment and execution still need to be verified in your Camunda 8 environment.
