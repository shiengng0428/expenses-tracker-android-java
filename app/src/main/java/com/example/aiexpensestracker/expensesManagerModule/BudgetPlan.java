package com.example.aiexpensestracker.expensesManagerModule;

public class BudgetPlan {
    public String budgetPlanNumber;
    public String category;
    public double budgetLimit;

    public BudgetPlan() {
        // Default constructor required for calls to DataSnapshot.getValue(BudgetPlan.class)
    }

    public BudgetPlan(String budgetPlanNumber, String category, double budgetLimit) {
        this.budgetPlanNumber = budgetPlanNumber;
        this.category = category;
        this.budgetLimit = budgetLimit;
    }

    // getters and setters

    public String getBudgetPlanNumber() {
        return budgetPlanNumber;
    }

    public void setBudgetPlanNumber(String budgetPlanNumber) {
        this.budgetPlanNumber = budgetPlanNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getBudgetLimit() {
        return budgetLimit;
    }

    public void setBudgetLimit(double budgetLimit) {
        this.budgetLimit = budgetLimit;
    }
}


