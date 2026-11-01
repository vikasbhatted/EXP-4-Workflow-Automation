# Process-variable dictionary

| Variable | Type | Purpose |
|---|---|---|
| customerReference | string | Customer reference |
| productId | string | Product identifier |
| quantity | number | Ordered quantity |
| deliveryPreference | string | Standard or Express |
| customerCategory | string | Regular or Premium |
| unitPrice | number | Unit price in INR |
| paymentToken | string | Synthetic mock payment token |
| orderValid | boolean | Java validation result |
| validationMessage | string | Validation explanation |
| orderTotal | number | Quantity multiplied by unit price |
| availableQuantity | number | Synthetic available stock |
| stockAvailable | boolean | Inventory check result |
| deliveryPriority | string | DMN output: High or Standard |
| paymentResponse | object | Mock payment API response |
| paymentStatus | string | SUCCESS, DECLINED or ERROR |
| verificationDecision | string | Manual reviewer decision |
| verificationComment | string | Reviewer comment |
| orderStatus | string | Final order status |
| outcomeRecorded | boolean | Worker completion flag |
