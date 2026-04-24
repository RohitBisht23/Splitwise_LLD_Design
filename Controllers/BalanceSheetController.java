package Controllers;

import Services.BalanceSheetService;
import Entities.User;
public class BalanceSheetController {
    private BalanceSheetService balanceSheetService;

    public BalanceSheetController(BalanceSheetService balanceSheetService) {
        this.balanceSheetService = balanceSheetService;
    }

    public void showBalanceSheet(User user) {
        balanceSheetService.showBalanceSheet(user);
    }
}
