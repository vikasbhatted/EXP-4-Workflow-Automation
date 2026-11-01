# DMN — Order Priority

Decision ID: `Decision_OrderPriority`; output: `deliveryPriority` (string); hit policy: `FIRST`.

| Rule | Conditions | Output |
|---|---|---|
| 1 | Premium customer AND Express delivery | High |
| 2 | Order total at least INR 50,000 | High |
| 3 | Express delivery | High |
| 4 | Otherwise (Standard delivery below INR 50,000) | Standard |

Sample evaluations:
- INR 60,000, Regular, Standard → High
- INR 20,000, Premium, Express → High
- INR 10,000, Regular, Standard → Standard

These are simple educational priority rules.
