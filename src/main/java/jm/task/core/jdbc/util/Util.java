package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    protected String dbUser = "root";
    protected String dbPass = "rss232";
    protected String dbURL = "jdbc:mysql://localhost:3306/jmpptest?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";

    public Connection getdbConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static SessionFactory getSessionFactory() {
        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/jmpptest?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false");
        prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
        prop.setProperty("hibernate.connection.username", "root");
        prop.setProperty("hibernate.connection.password", "rss232");
        prop.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        prop.setProperty("show_sql", "true");

        SessionFactory factory = new Configuration().addProperties(prop).addAnnotatedClass(User.class).buildSessionFactory();
        return factory;
    }
}
