package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Properties;


public class Main {
    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();//1
        //        userService.saveUser("Bill", "Brown", (byte) 21); //2
        //List<User> listOfUsers = userService.getAllUsers();//3
//        System.out.println(listOfUsers);//3
//       userService.cleanUsersTable();//4
//       userService.dropUsersTable();//5

        Properties prop = new Properties();

        prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/jmpptest?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false");
        //You can use any database you want, I had it configured for Postgres
        prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");

        prop.setProperty("hibernate.connection.username", "root");
        prop.setProperty("hibernate.connection.password", "rss232");
        prop.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        prop.setProperty("show_sql", "true"); //If you wish to see the generated sql query

        SessionFactory factory = new Configuration().addProperties(prop).addAnnotatedClass(User.class).buildSessionFactory();
        //  Session session = sessionFactory.openSession();

        Session session = factory.openSession();
        User usr1 = new User("Anton", "Andreevich", (byte) 31);
        User usr2 = new User("Sofia", "Usmanova", (byte) 21);
        session.beginTransaction();
        session.save(usr2);
        session.getTransaction().commit();


    }
}
