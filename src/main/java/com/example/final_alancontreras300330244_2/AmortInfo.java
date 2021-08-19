package com.example.final_alancontreras300330244_2;

public class AmortInfo {
    private int month;
    private double startingAmount;
    private double interest;
    private double monthlyPayment;
    private double endingBalance;

    public AmortInfo(int month, double startingAmount, double interest, double monthlyPayment, double endingBalance) {
        this.month = month;
        this.startingAmount = startingAmount;
        this.interest = interest;
        this.monthlyPayment = monthlyPayment;
        this.endingBalance = endingBalance;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getStartingAmount() {
        return startingAmount;
    }

    public void setStartingAmount(double startingAmount) {
        this.startingAmount = startingAmount;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getEndingBalance() {
        return endingBalance;
    }

    public void setEndingBalance(double endingBalance) {
        this.endingBalance = endingBalance;
    }
}
