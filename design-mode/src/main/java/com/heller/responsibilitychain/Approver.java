package com.heller.responsibilitychain;

/**
 * ----职责链模式
 * 通常每个接收者都包含对另一个接收者的引用。
 */
public abstract class Approver {
    Approver approver;
    String name;

    public Approver(String name) {
        this.name = name;
    }
    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    public abstract void processRequest(PurchaseRequest purchaseRequest);
}
