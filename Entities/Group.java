package Entities;
import java.util.*;
public class Group {
    String groupId;
    List<User> members;
    String groupName;
    List<Expense> expensesList;

    public Group(String groupId, String groupName, List<User> members) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.members = members;
        this.expensesList = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expensesList.add(expense);
    }

    public List<Expense> getExpensesList() {
        return expensesList;
    }

    public String getGroupId() {
        return groupId;
    }

    public List<User> getMembers() {
        return members;
    }
}
