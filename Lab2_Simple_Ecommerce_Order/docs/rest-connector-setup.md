# Mock payment REST Connector setup

The BPMN payment service task is intended to use Camunda's HTTP JSON REST Connector.

- Method: POST
- URL: `http://localhost:8082/api/payment`
- Content-Type: `application/json`
- Request body: `customerReference`, `orderTotal`, `paymentToken`
- Store response in: `paymentResponse`

Example request:
```json
{"customerReference":"CUST-001","orderTotal":12000,"paymentToken":"TEST-OK"}
```
Successful response:
```json
{"paymentStatus":"SUCCESS","transactionReference":"PAY-SIM-001"}
```
Declined response:
```json
{"paymentStatus":"DECLINED","transactionReference":"PAY-SIM-001"}
```
Failure response (HTTP 503):
```json
{"paymentStatus":"ERROR","message":"Simulated payment service failure"}
```

Start the mock API from the project root with `python mock-api/mock_payment_api.py`. Configure the task using the REST Connector template installed in your Camunda environment. Header conventions differ by connector version, so confirm the template fields in Modeler. The connector response is stored in `paymentResponse`; the BPMN gateway reads `paymentResponse.paymentStatus`.
