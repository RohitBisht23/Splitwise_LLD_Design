package Services;

import Entities.User;
import java.util.List;
import Entities.Split;
import Entities.BalanceSheet;
import Entities.Balance;

public class BalanceSheetService {
    
    public void updateBalanceSheet(User paidBy, List<Split> splits, double totalAmount) {
        BalanceSheet paidUserBalanceSheet = paidBy.getBalanceSheet();
        paidUserBalanceSheet.setTotalPayment(paidUserBalanceSheet.getTotalPayment() + totalAmount);

        for(Split m : splits) {
            User owedUser = m.getUser();

            BalanceSheet owedUserBalanceSheet = owedUser.getBalanceSheet();

            double amount = m.getAmount();

            if(paidBy.getUserId().equals(owedUser.getUserId())) {
                paidUserBalanceSheet.setYourExpense(paidUserBalanceSheet.getTotalYourExpense() + amount);
            } else {
                paidUserBalanceSheet.setTotalGetBack(paidUserBalanceSheet.getTotalGetBack() + amount);
                owedUserBalanceSheet.setTotalOwes(owedUserBalanceSheet.getTotalOwes() + amount);
            }
        }
    }

    public void showBalanceSheet(User user) {
        BalanceSheet balanceSheet = user.getBalanceSheet();
        System.out.println("Balance Sheet for " + user.getName() + ":");
        System.out.println("Total Payment: " + balanceSheet.getTotalPayment());
        System.out.println("Total Get Back: " + balanceSheet.getTotalGetBack());
        System.out.println("Total Owes: " + balanceSheet.getTotalOwes());
        System.out.println("Your Expense: " + balanceSheet.getTotalYourExpense());
        System.out.println("------------------------------------------------------------");
    }
}
