package strategy;

import java.util.*;
import Entities.*;
public class PercentageStrategy implements SplitStrategy {
    @Override
    public List<Split> splits(List<User> members, double amount, User paidBy, Map<User, Double> meta) {
        List<Split> splits = new ArrayList<>();

        double totalPercentage = meta.values().stream().mapToDouble(Double::doubleValue).sum();

        if(totalPercentage != 100) {
            throw new IllegalArgumentException("Total percentage must be 100");
        }
        
        for(User m : members) {
            double percentage = meta.get(m);
            double splitAmount = (percentage / 100) * amount;
            splits.add(new Split(m, splitAmount));
        }
        return splits;
    }
    
}
