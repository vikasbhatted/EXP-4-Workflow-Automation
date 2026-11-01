# Process-variable dictionary

| Variable | Type | Purpose |
|---|---|---|
| patientReference | String | Synthetic patient identifier |
| appointmentPreference | String | Preferred date/time or time window |
| symptomsSummary | String | Synthetic symptoms description |
| urgentIndicator | Boolean | Educational urgent rule input |
| priorityIndicator | Boolean | Educational priority rule input |
| registrationValid | Boolean | Result of Java registration validation |
| registrationMessage | String | Validation message |
| triageResult.urgencyCategory | String | DMN result: Routine / Priority Review / Urgent Assessment |
| simulateNoSlots | Boolean | Test switch for no available slots |
| simulateFailure | Boolean | Test switch for API failure |
| slotAvailable | Boolean | Whether mock API found a slot |
| availableSlots | List | Synthetic appointment slots |
| bookingStatus | String | SLOT_FOUND / PENDING_STAFF_REVIEW / BOOKED |
| staffDecision | String | Staff task decision |
| staffComment | String | Staff notes |
| bookingStatus | String | Final booking state |

## Routing
- Invalid registration → Request incomplete end.
- Urgent Assessment → immediate human assessment task.
- Priority Review or Routine → request slot availability.
- Slot available → record booking → Appointment booked.
- No slot → authorised staff review → Staff assessment / follow-up.
