
package Entities;
public class Split {
    User user;
    double amount;

    public Split(User user, double amount) {
        this.user = user;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public User getUser() {
        return user;
    }
}