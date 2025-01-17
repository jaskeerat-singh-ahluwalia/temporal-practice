package com.example.loan.activities;

import io.temporal.activity.ActivityInterface;

import java.util.List;

@ActivityInterface
/**
 * @author jaskeeratsingh
 */
public interface LoanActivities {

    void processLoanApplication(String applicantName, List<String> documents, String status);
}
