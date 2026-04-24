package Services;

import java.util.*;

import Enums.SplitType;
import Entities.Expense;
import Entities.Group;
import Entities.User;
public class GroupService {
    List<Group> groupList;
    private ExpenseService expenseService;
    private DebtSimplificationService debtsSplificationService;

    public GroupService(ExpenseService expenseService, DebtSimplificationService debtsSplificationService) {
        this.groupList = new ArrayList<>();
        this.expenseService = expenseService;
        this.debtsSplificationService = debtsSplificationService;
    }

    // public GroupService(ExpenseService expenseService) {
    //     this.groupList = new ArrayList<>();
    //     this.expenseService = expenseService;
    // }
    
    public void createGroup(String groupId, String groupName, List<User> members) {
        Group group = new Group(groupId, groupName, members);
        groupList.add(group);
    }

    public void AddExpenseToGroup(String groupId,String expenseId, User paidBy, List<User> members, double amount, SplitType splitType, Map<User, Double> meta, String description) {
        Expense newExpense = expenseService.createExpense(expenseId, members, amount, paidBy, splitType, meta, description);
        for(Group g : groupList) {
            if(g.getGroupId().equals(groupId)) {
                g.getExpensesList().add(newExpense);
                break;
            }
        }
    }

    public void splifyDebts(String groupId) {
        for(Group g : groupList) {
            if(g.getGroupId().equals(groupId)) {
                debtsSplificationService.simplifyDebt(g);
                break;
            }
        }
    }
}
