package com.example.loan.workflows;


import io.temporal.workflow.Workflow;
import com.example.loan.activities.LoanActivities;

import java.util.ArrayList;
import java.util.List;

import java.util.List;
/**
 * @author jaskeeratsingh
 */
public class LoanApplicationWorkflowImpl implements LoanApplicationWorkflow{

    private String status = "Pending";
    private List<String> documents = new ArrayList<>();
    private boolean isCanceled = false;
    private final LoanActivities activities = Workflow.newActivityStub(LoanActivities.class);




    @Override
    public void startApplication(String applicantName) {
        System.out.println("Starting loan application for: " + applicantName);
        Workflow.await(() -> isCanceled || !documents.isEmpty());

        if (isCanceled) {
            System.out.println("Loan application canceled.");
            return;
        }

        System.out.println("Documents submitted: " + documents);
        System.out.println("Application status: " + status);

        activities.processLoanApplication(applicantName, documents, status);
    }

    @Override
    public void updateApplicationStatus(String status) {
        System.out.println("Received signal to update status: " + status);
        this.status = status;
    }

    @Override
    public void addDocument(String documentName) {
        System.out.println("Received signal to add document: " + documentName);
        documents.add(documentName);
    }

    @Override
    public void cancelApplication() {
        System.out.println("Received signal to cancel application.");
        isCanceled = true;
    }

}
