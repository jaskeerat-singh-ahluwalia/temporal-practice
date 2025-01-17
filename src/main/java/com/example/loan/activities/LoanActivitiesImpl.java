package com.example.loan.activities;

import java.util.List;
/**
 * @author jaskeeratsingh
 */
public class LoanActivitiesImpl implements LoanActivities {

    @Override
    public void processLoanApplication(String applicantName, List<String> documents, String status) {
        System.out.println("Processing loan application for: " + applicantName);
        System.out.println("Status: " + status);
        System.out.println("Documents: " + documents);
    }
}
