package edu.lab.hospital;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import java.util.Map;

@Component
public class AvailabilityWorker {
    @Value("${hospital.scheduling-api}") private String api;
    @JobWorker(type = "check-appointment-availability")
    public void check(final JobClient client, final ActivatedJob job) {
        Map<String, Object> v = job.getVariablesAsMap();
        Map<String, Object> request = Map.of(
            "patientReference", String.valueOf(v.getOrDefault("patientReference", "")),
            "appointmentPreference", String.valueOf(v.getOrDefault("appointmentPreference", "")),
            "simulateNoSlots", Boolean.TRUE.equals(v.get("simulateNoSlots")),
            "simulateFailure", Boolean.TRUE.equals(v.get("simulateFailure"))
        );
        Map response = RestClient.create().post().uri(api + "/availability")
            .body(request).retrieve().body(Map.class);
        client.newCompleteCommand(job.getKey()).variables(response).send().join();
    }
}
