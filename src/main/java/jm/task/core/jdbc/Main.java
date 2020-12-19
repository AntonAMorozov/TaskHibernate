package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();//1
        userService.saveUser("Bill", "Brown", (byte) 21); //2
        userService.saveUser("Anton", "Morozov", (byte) 31); //2
        userService.saveUser("John", "Smith", (byte) 18); //2
        userService.saveUser("Alice", "Cooper", (byte) 55); //2
        List<User> listOfUsers = userService.getAllUsers();//3
        System.out.println(listOfUsers);//3
        userService.cleanUsersTable();//4
        userService.dropUsersTable();//5


    }
}
