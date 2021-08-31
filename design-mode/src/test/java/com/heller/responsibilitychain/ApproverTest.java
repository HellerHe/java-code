package com.heller.responsibilitychain;

import org.junit.jupiter.api.Test;

public class ApproverTest {
    @Test
    public void test() {
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 1, 40000);
        DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
        CollegeApprover collegeApprover = new CollegeApprover("李院长");
        SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("王校长");

        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(schoolMasterApprover);
        schoolMasterApprover.setApprover(departmentApprover);

        departmentApprover.processRequest(purchaseRequest);
        collegeApprover.processRequest(purchaseRequest);
    }
}