package edu.lab.hospital;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class RegistrationWorker {
    @JobWorker(type = "validate-registration")
    public void validate(final JobClient client, final ActivatedJob job) {
        Map<String, Object> v = job.getVariablesAsMap();
        String ref = String.valueOf(v.getOrDefault("patientReference", ""));
        String preference = String.valueOf(v.getOrDefault("appointmentPreference", ""));
        String symptoms = String.valueOf(v.getOrDefault("symptomsSummary", ""));
        boolean valid = !ref.isBlank() && !preference.isBlank() && !symptoms.isBlank();
        client.newCompleteCommand(job.getKey())
            .variables(Map.of("registrationValid", valid, "registrationMessage",
                valid ? "Registration fields present" : "Required registration field missing"))
            .send().join();
    }
}
