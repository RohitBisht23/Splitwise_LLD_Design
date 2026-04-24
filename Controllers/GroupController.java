package Controllers;

import java.util.*;
import Services.GroupService;
import Entities.User;
import javax.swing.GroupLayout.Group;
import Enums.SplitType;

public class GroupController {
    private GroupService groupService;


    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    public void createGroup(String groupId, String groupName, List<User> members) {
        groupService.createGroup(groupId, groupName, members);
    }

    public void addExpenseToGroup(String groupId,String expenseId, User paidBy, List<User> members, double amount, SplitType splitType, Map<User, Double> meta, String description) {
        groupService.AddExpenseToGroup(groupId, expenseId, paidBy, members, amount, splitType, meta, description);
    } 
    
    
    public void splifyDebts(String groupId) {
        groupService.splifyDebts(groupId);
    }

}
