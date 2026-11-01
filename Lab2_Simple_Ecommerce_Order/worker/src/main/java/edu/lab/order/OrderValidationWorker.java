package edu.lab.order;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.HashMap;
@Component
public class OrderValidationWorker {
 @JobWorker(type="validate-order")
 public Map<String,Object> validate(ActivatedJob job) {
  Map<String,Object> v=job.getVariablesAsMap();
  String customer=str(v.get("customerReference")), product=str(v.get("productId")), token=str(v.get("paymentToken"));
  Number qty=num(v.get("quantity")), price=num(v.get("unitPrice"));
  boolean valid=!customer.isBlank()&&!product.isBlank()&&!token.isBlank()
    &&qty!=null&&qty.intValue()>0&&price!=null&&price.doubleValue()>0;
  double total=(qty==null||price==null)?0:qty.doubleValue()*price.doubleValue();
  Map<String,Object> out=new HashMap<>();
  out.put("orderValid",valid); out.put("orderTotal",total);
  out.put("validationMessage",valid?"Order details valid":"Missing or invalid order details");
  return out;
 }
 private String str(Object x){return x==null?"":x.toString().trim();}
 private Number num(Object x){return x instanceof Number?(Number)x:null;}
}