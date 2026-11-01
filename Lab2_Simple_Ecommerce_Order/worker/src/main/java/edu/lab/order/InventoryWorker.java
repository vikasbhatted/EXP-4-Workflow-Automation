package edu.lab.order;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.HashMap;
@Component
public class InventoryWorker {
 @JobWorker(type="check-inventory")
 public Map<String,Object> check(ActivatedJob job) {
  Map<String,Object> v=job.getVariablesAsMap();
  String product=String.valueOf(v.getOrDefault("productId",""));
  int quantity=((Number)v.getOrDefault("quantity",0)).intValue();
  // Synthetic inventory: product IDs ending in "-LOW" have only 1 unit; others have 100.
  int available=product.endsWith("-LOW")?1:100;
  Map<String,Object> out=new HashMap<>();
  out.put("availableQuantity",available);
  out.put("stockAvailable",quantity<=available);
  return out;
 }
}