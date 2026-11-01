from http.server import BaseHTTPRequestHandler, HTTPServer
import json

class Handler(BaseHTTPRequestHandler):
    def do_POST(self):
        if self.path != "/availability":
            self.send_response(404); self.end_headers(); return
        length = int(self.headers.get("Content-Length", "0"))
        data = json.loads(self.rfile.read(length) or b"{}")
        if data.get("simulateFailure"):
            self.send_response(503); self.end_headers()
            self.wfile.write(b'{"error":"Simulated scheduling service unavailable"}')
            return
        if data.get("simulateNoSlots") or str(data.get("patientReference","")).endswith("-NOSLOT"):
            result = {"slotAvailable": False, "availableSlots": [], "bookingStatus": "PENDING_STAFF_REVIEW"}
        else:
            result = {"slotAvailable": True,
                      "availableSlots": ["2026-11-05 10:00", "2026-11-06 14:30"],
                      "bookingStatus": "SLOT_FOUND"}
        body = json.dumps(result).encode()
        self.send_response(200); self.send_header("Content-Type","application/json")
        self.send_header("Content-Length", str(len(body))); self.end_headers(); self.wfile.write(body)

if __name__ == "__main__":
    print("Mock scheduling API listening on http://localhost:8083")
    HTTPServer(("0.0.0.0", 8083), Handler).serve_forever()
