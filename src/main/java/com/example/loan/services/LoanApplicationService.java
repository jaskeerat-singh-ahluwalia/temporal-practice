package com.example.loan.services;

import com.example.loan.workflows.LoanApplicationWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
/**
 * @author jaskeeratsingh
 */
@Service
public class LoanApplicationService {

    private final WorkflowClient client;

    public LoanApplicationService(WorkflowClient client) {
        this.client = client;
    }

    public void startLoanApplication(String applicantName) {

        LoanApplicationWorkflow workflow = client.newWorkflowStub(
                LoanApplicationWorkflow.class,
                WorkflowOptions.newBuilder()
                        .setTaskQueue("LOAN_APPLICATION_TASK_QUEUE")
                        .build()
        );



//        WorkflowClient.start(workflow::startApplication, applicantName);
        String workflowId = WorkflowClient.start(workflow::startApplication, applicantName).getWorkflowId();
        System.out.println("Started workflow with ID: " + workflowId);
    }

    public LoanApplicationWorkflow getWorkflowStub(String workflowId) {
        return client.newWorkflowStub(LoanApplicationWorkflow.class, workflowId);
    }
}
