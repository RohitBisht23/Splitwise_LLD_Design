package Entities;
import java.util.*;

public class BalanceSheet {
    Map<User, Balance> balance;
    double totalPayment;
    double totalYourExpense;
    double totalOwes;
    double totalGetBack;

    public BalanceSheet() {
        this.balance = new HashMap<>();
        this.totalPayment = 0;
        this.totalYourExpense = 0;
        this.totalOwes = 0;
        this.totalGetBack = 0;
    }


    public Map<User, Balance> getBalance() {
        return balance;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public double getTotalYourExpense() {
        return totalYourExpense;
    }

    public double getTotalOwes() {
        return totalOwes;
    }

    public double getTotalGetBack() {
        return totalGetBack;
    }

    public void setYourExpense(double amount) {
        this.totalYourExpense = amount;
    }

    public void setTotalPayment(double amount) {
        this.totalPayment = amount;
    }

    public void setTotalOwes(double amount) {
        this.totalOwes = amount;
    }

    public void setTotalGetBack(double amount) {
        this.totalGetBack = amount;
    }
}
