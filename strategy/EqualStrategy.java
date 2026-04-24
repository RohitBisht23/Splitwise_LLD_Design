package strategy;
import java.util.*;
import Entities.User;
import Entities.Split;
public class EqualStrategy implements SplitStrategy{
    
    @Override
    public List<Split> splits(List<User> members, double amount, User paidBy, Map<User, Double> meta) {
        List<Split> splits = new ArrayList<>();
        int totalMembers = members.size();

        double splitAmount = amount / totalMembers;

        for(User m : members) {
            splits.add(new Split(m, splitAmount));
        }
        return splits;

    }
    
}
