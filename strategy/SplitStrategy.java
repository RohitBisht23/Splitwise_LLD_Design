package strategy;

import java.util.*;
import Entities.Split;
import Entities.User;
public interface SplitStrategy {
    public List<Split> splits(List<User> members, double amout, User paidBy, Map<User, Double> meta);
}
