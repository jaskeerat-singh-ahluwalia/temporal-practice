package com.example.loan.workflows;

import io.temporal.workflow.SignalMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

/**
 * @author jaskeeratsingh
 */
@WorkflowInterface
public interface LoanApplicationWorkflow {

    @WorkflowMethod
    void startApplication(String applicantName);

    @SignalMethod
    void updateApplicationStatus(String status);

    @SignalMethod
    void addDocument(String documentName);

    @SignalMethod
    void cancelApplication();
}
