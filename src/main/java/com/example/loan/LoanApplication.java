package com.example.loan;

import com.example.loan.activities.LoanActivitiesImpl;
import com.example.loan.workflows.LoanApplicationWorkflowImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.example.loan")
public class LoanApplication {

  public static void main(String[] args) {
    SpringApplication.run(LoanApplication.class, args);
  }
}
