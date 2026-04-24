package Controllers;

import java.util.*;
import Entities.User;
import Enums.SplitType;

public class ExpenseController {
    
    private Services.ExpenseService ExpenseService;

    public ExpenseController(Services.ExpenseService expenseService) {
        this.ExpenseService = expenseService;
    }

    public void createExpense(String expenseId, List<User> members, double amount, User paidBy, SplitType splitType, Map<User, Double> meta, String description) {
        ExpenseService.createExpense(expenseId, members, amount, paidBy, splitType, meta, description);
    }


}
