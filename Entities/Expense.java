package Entities;
import java.util.*;
import Enums.SplitType;

public class Expense {
    String expenseId;
    String description;
    double amount;
    User paidBy;
    List<Split> splitList;
    SplitType type;

    public Expense(String expenseId, String description, double amount, User paidBy, List<Split> splitList, SplitType type) {
        this.expenseId = expenseId;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitList = splitList;
        this.type = type;
    }
}