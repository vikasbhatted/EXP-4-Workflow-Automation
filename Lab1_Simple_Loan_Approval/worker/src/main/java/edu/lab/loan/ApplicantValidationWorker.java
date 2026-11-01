package edu.lab.loan;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.HashMap;
@Component
public class ApplicantValidationWorker {
 @JobWorker(type="validate-applicant")
 public Map<String,Object> validate(ActivatedJob job) {
  Map<String,Object> v=job.getVariablesAsMap();
  String name=str(v.get("applicantName")), id=str(v.get("applicantId")), email=str(v.get("email"));
  Number age=num(v.get("age")), income=num(v.get("monthlyIncome")), amount=num(v.get("requestedAmount"));
  Number debt=num(v.get("existingMonthlyDebt")), score=num(v.get("declaredCreditScore"));
  boolean valid=!name.isBlank()&&!id.isBlank()&&email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")
   &&age!=null&&age.intValue()>=18&&age.intValue()<=70
   &&income!=null&&income.doubleValue()>0&&amount!=null&&amount.doubleValue()>0
   &&debt!=null&&debt.doubleValue()>=0&&score!=null&&score.intValue()>=300&&score.intValue()<=900;
  double inc=income==null?0:income.doubleValue(), amt=amount==null?0:amount.doubleValue(), dbt=debt==null?0:debt.doubleValue();
  Map<String,Object> out=new HashMap<>();
  out.put("applicantValid",valid);
  out.put("validationMessage",valid?"Applicant details are valid":"Check required fields, age, email, income, debt and credit score");
  out.put("loanToIncomeMultiple",inc>0?amt/inc:0);
  out.put("debtToIncomeRatio",inc>0?dbt/inc:1);
  return out;
 }
 private String str(Object x){return x==null?"":x.toString().trim();}
 private Number num(Object x){return x instanceof Number?(Number)x:null;}
}