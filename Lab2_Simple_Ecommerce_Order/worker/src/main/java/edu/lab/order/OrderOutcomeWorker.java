package edu.lab.order;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.HashMap;
@Component
public class OrderOutcomeWorker {
 @JobWorker(type="record-order-outcome")
 public Map<String,Object> record(ActivatedJob job) {
  Map<String,Object> out=new HashMap<>();
  out.put("outcomeRecorded",true);
  return out;
 }
}