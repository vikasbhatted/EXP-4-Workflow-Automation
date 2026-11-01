package edu.lab.hospital;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class BookingWorker {
    @JobWorker(type = "record-appointment-booking")
    public void record(final JobClient client, final ActivatedJob job) {
        Map<String, Object> v = job.getVariablesAsMap();
        client.newCompleteCommand(job.getKey())
            .variables(Map.of("bookingStatus", "BOOKED",
                "bookedSlot", String.valueOf(v.getOrDefault("availableSlots", "Synthetic slot"))))
            .send().join();
    }
}
