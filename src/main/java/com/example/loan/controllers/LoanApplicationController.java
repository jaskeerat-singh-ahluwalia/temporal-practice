package com.example.loan.controllers;

import com.example.loan.services.LoanApplicationService;
import com.example.loan.workflows.LoanApplicationWorkflow;
import org.springframework.web.bind.annotation.*;
/**
 * @author jaskeeratsingh
 */
@RestController
@RequestMapping("/loan")
public class LoanApplicationController {

    private final LoanApplicationService service;

    public LoanApplicationController(LoanApplicationService service) {
        this.service = service;
    }

    @PostMapping("/start")
    public String startLoanApplication(@RequestParam String applicantName) {
        service.startLoanApplication(applicantName);
        return "Loan application started for: " + applicantName;
    }

    @PostMapping("/status")
    public String updateStatus(@RequestParam String workflowId, @RequestParam String status) {
        LoanApplicationWorkflow workflow = service.getWorkflowStub(workflowId);
        workflow.updateApplicationStatus(status);
        return "Status updated to: " + status;
    }

    @PostMapping("/document")
    public String addDocument(@RequestParam String workflowId, @RequestParam String documentName) {
        LoanApplicationWorkflow workflow = service.getWorkflowStub(workflowId);
        workflow.addDocument(documentName);
        return "Document added: " + documentName;
    }

    @PostMapping("/cancel")
    public String cancelApplication(@RequestParam String workflowId) {
        LoanApplicationWorkflow workflow = service.getWorkflowStub(workflowId);
        workflow.cancelApplication();
        return "Loan application canceled.";
    }
}
