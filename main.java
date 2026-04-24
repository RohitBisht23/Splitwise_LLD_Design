import Entities.User;
import Entities.BalanceSheet;
import Services.BalanceSheetService;
import Services.ExpenseService;
import Services.GroupService;
import strategy.SplitStrategy;
import Controllers.BalanceSheetController;
import Controllers.ExpenseController;
import Controllers.GroupController;
import Services.*;
import java.util.*;
import Enums.SplitType;
import Factory.FactoryStrategy;
class main {
    public static void main(String args[]) {
        User user1 = new User("1", "Alice");
        User user2 = new User("2", "Bob");  
        User user3 = new User("3", "Charlie");
        BalanceSheetService balanceSheetService = new BalanceSheetService();
        BalanceSheetController balanceSheetController = new BalanceSheetController(balanceSheetService);

        balanceSheetController.showBalanceSheet(user1);
        balanceSheetController.showBalanceSheet(user2); 
        balanceSheetController.showBalanceSheet(user3);
        
        //Create Expenses and update balance sheets accordingly
        ExpenseService expenseService = new ExpenseService(balanceSheetService);
        ExpenseController expenseController = new ExpenseController(expenseService);

        expenseController.createExpense("1",List.of(user1, user2), 150, user1, Enums.SplitType.EQUAL, null, "Dinner");
        expenseController.createExpense("2",List.of(user1, user3), 300, user3, Enums.SplitType.EQUAL, null, "Movie");

        balanceSheetController.showBalanceSheet(user1);
        balanceSheetController.showBalanceSheet(user2);
        balanceSheetController.showBalanceSheet(user3);


        //Create group
        DebtSimplificationService ds = new DebtSimplificationService();
        GroupService groupService = new GroupService(expenseService, ds);
        GroupController groupController = new GroupController(groupService);
        groupController.createGroup("g1", "Goa-Trip", List.of(user1, user2, user3));
        groupController.addExpenseToGroup("g1", "3", user2, List.of(user1, user2, user3), 600, Enums.SplitType.EQUAL, null, "Hotel");

        balanceSheetController.showBalanceSheet(user1);
        balanceSheetController.showBalanceSheet(user2); 
        balanceSheetController.showBalanceSheet(user3);


        groupController.splifyDebts("g1");
        System.out.println("---------------After Debt Simplification:-----------------");
        balanceSheetController.showBalanceSheet(user1);
        balanceSheetController.showBalanceSheet(user2);
        balanceSheetController.showBalanceSheet(user3);
    }
}