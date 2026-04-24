
package Entities;
import Entities.BalanceSheet;

public class User {
    String userId;
    String userName;  
    BalanceSheet balanceSheet;  

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.balanceSheet = new BalanceSheet();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return userName;
    }

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }
}
