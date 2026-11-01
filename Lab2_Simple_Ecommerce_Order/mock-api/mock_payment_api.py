from http.server import BaseHTTPRequestHandler, HTTPServer
import json
class Handler(BaseHTTPRequestHandler):
 def do_POST(self):
  size=int(self.headers.get("Content-Length","0"))
  body=json.loads(self.rfile.read(size) or b"{}")
  token=body.get("paymentToken","")
  if body.get("simulateFailure"):
   self.send_response(503); self.send_header("Content-Type","application/json"); self.end_headers()
   self.wfile.write(json.dumps({"paymentStatus":"ERROR","message":"Simulated payment service failure"}).encode()); return
  status="DECLINED" if token=="TEST-DECLINED" else "SUCCESS"
  response={"paymentStatus":status,"transactionReference":"PAY-SIM-001"}
  self.send_response(200); self.send_header("Content-Type","application/json"); self.end_headers()
  self.wfile.write(json.dumps(response).encode())
 def log_message(self,fmt,*args): print(fmt%args)
if __name__=="__main__":
 print("Mock payment API running at http://localhost:8082")
 HTTPServer(("0.0.0.0",8082),Handler).serve_forever()
