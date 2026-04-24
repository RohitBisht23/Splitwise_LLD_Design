package Services;


import java.util.*;
import Entities.Expense;
import Entities.User;
import Enums.SplitType;
import Entities.Split;
import strategy.SplitStrategy;
import Factory.FactoryStrategy;
public class ExpenseService {

    private BalanceSheetService balanceSheetService;

    public ExpenseService(BalanceSheetService balanceSheetService) {
        this.balanceSheetService = balanceSheetService;
    }
    
    
    public Expense createExpense(String expenseId,List<User> members, double amount, User paidBy, SplitType splitType, Map<User, Double> meta, String description) {
        SplitStrategy strategy = FactoryStrategy.getSplitStrategy(splitType);

        List<Split> splits = strategy.splits(members, amount, paidBy, meta);


        Expense newExpense = new Expense(expenseId, description, amount, paidBy, splits, splitType);

        balanceSheetService.updateBalanceSheet(paidBy, splits, amount);

        return newExpense;
    }
}
