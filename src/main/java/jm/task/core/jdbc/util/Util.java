package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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

    private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;

    static {
        // Creating StandardServiceRegistryBuilder
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

        // Hibernate settings which is equivalent to hibernate.cfg.xml's properties
        Map<String, String> dbSettings = new HashMap<>();
        dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3306/jmpptest?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false");
        dbSettings.put(Environment.USER, "root");
        dbSettings.put(Environment.PASS, "rss232");
        dbSettings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        dbSettings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        dbSettings.put(Environment.SHOW_SQL, "true");

        // Apply database settings
        registryBuilder.applySettings(dbSettings);
        // Creating registry
        standardServiceRegistry = registryBuilder.build();
        // Creating MetadataSources
        MetadataSources sources = new MetadataSources(standardServiceRegistry);
        // Creating Metadata
        Metadata metadata = sources.getMetadataBuilder().build();
        // Creating SessionFactory
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    //Utility method to return SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
