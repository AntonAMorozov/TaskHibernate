package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import org.hibernate.SessionFactory;

import static jm.task.core.jdbc.util.Util.getSessionFactory;


public class Main {
    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();//1
        userService.saveUser("Rakel", "Fauke", (byte) 37); //2
        userService.saveUser("Harry", "Hole", (byte) 44); //2
        userService.saveUser("Jo", "Nesbo", (byte) 55); //2
        userService.saveUser("Kaja", "Solness", (byte) 30); //2
        System.out.println(userService.getAllUsers());//3
        userService.cleanUsersTable();//4
        userService.dropUsersTable();//5



    }


}
