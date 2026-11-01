# REST Connector setup

The BPMN contains a placeholder service integration task conceptually named **Request appointment availability**. For this educational package, the Java worker currently performs the HTTP request to the mock API so the workflow can run without relying on a particular connector template version.

If your instructor specifically requires the Camunda REST Connector:
1. Replace the `check-appointment-availability` service task implementation with the REST Connector template supported by your installed Modeler/runtime.
2. Method: `POST`
3. URL: `http://host.docker.internal:8083/availability` when the engine runs in a container and the mock API runs on Windows; if both run on the same host, use `http://localhost:8083/availability`.
4. Header: `Content-Type: application/json`
5. Body example:
```json
{
  "patientReference": "PAT-1001",
  "appointmentPreference": "weekday morning",
  "simulateNoSlots": false,
  "simulateFailure": false
}
```
6. Store response in process variables (root-level mapping): `slotAvailable`, `availableSlots`, `bookingStatus`.

Example successful response:
```json
{"slotAvailable":true,"availableSlots":["2026-11-05 10:00","2026-11-06 14:30"],"bookingStatus":"SLOT_FOUND"}
```
No-slot response:
```json
{"slotAvailable":false,"availableSlots":[],"bookingStatus":"PENDING_STAFF_REVIEW"}
```
Failure test: set `simulateFailure` to true. The API responds HTTP 503. The worker/connector should create an incident; inspect it in Operate, restore the API, then retry the failed job where supported.

Do not run the Java worker and a second REST Connector call for the same availability step simultaneously. Choose one implementation path. Exact connector template fields vary by installed connector version.
