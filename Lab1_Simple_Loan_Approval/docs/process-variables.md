# Process variables

| Name | Type | Purpose |
|---|---|---|
| applicantName | string | Applicant name |
| applicantId | string | Synthetic applicant reference |
| email | string | Applicant email |
| age | number | Applicant age |
| monthlyIncome | number | Monthly income in INR |
| requestedAmount | number | Requested loan amount in INR |
| existingMonthlyDebt | number | Existing monthly debt in INR |
| declaredCreditScore | number | Synthetic score submitted for the exercise |
| applicantValid | boolean | Java worker validation result |
| validationMessage | string | Validation explanation |
| loanToIncomeMultiple | number | Requested amount / monthly income |
| debtToIncomeRatio | number | Existing debt / monthly income |
| creditAssessment | object | Mock REST response |
| creditScore | number | Credit score passed to DMN |
| loanDecisionResult | object | DMN output containing `decision` |
| reviewOutcome | string | Human reviewer approval/rejection |
| reviewComment | string | Human reviewer comment |
| finalStatus | string | Final application status |
| outcomeRecorded | boolean | Worker completion indicator |
