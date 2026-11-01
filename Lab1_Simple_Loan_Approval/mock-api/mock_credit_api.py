from http.server import BaseHTTPRequestHandler, HTTPServer
import json
class Handler(BaseHTTPRequestHandler):
 def do_POST(self):
  size=int(self.headers.get("Content-Length","0"))
  body=json.loads(self.rfile.read(size) or b"{}")
  if body.get("simulateFailure"):
   self.send_response(503); self.send_header("Content-Type","application/json"); self.end_headers()
   self.wfile.write(json.dumps({"status":"ERROR","message":"Simulated service failure"}).encode()); return
  response={"status":"SUCCESS","applicantId":body.get("applicantId","SYNTH-001"),
            "creditScore":int(body.get("declaredCreditScore",700))}
  self.send_response(200); self.send_header("Content-Type","application/json"); self.end_headers()
  self.wfile.write(json.dumps(response).encode())
 def log_message(self,fmt,*args): print(fmt%args)
if __name__=="__main__":
 print("Mock credit API running at http://localhost:8081")
 HTTPServer(("0.0.0.0",8081),Handler).serve_forever()
