# Educational DMN rules

Decision: `Decision_PatientTriage`  
Hit policy: `FIRST`

| Rule order | urgentIndicator | priorityIndicator | urgencyCategory |
|---|---|---|---|
| 1 | true | - | Urgent Assessment |
| 2 | false | true | Priority Review |
| 3 | - | - | Routine |

These are deliberately simplified rules for a classroom workflow demonstration only. They are not medical advice, clinical guidelines, or a validated triage protocol. Urgent cases go to a human assessment task; the software does not diagnose or recommend treatment.
