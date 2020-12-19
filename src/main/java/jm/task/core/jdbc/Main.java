package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();//1
             userService.saveUser("Bill", "Brown", (byte) 21); //2
//        List<User> listOfUsers = userService.getAllUsers();//3
//        System.out.println(listOfUsers);//3
//       userService.cleanUsersTable();//4
//       userService.dropUsersTable();//5


    }
}
