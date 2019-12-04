package ru.kpfu.db;

import ru.kpfu.repositories.CrudRoleRepositoryImpl;
import ru.kpfu.repositories.CrudUserRepositoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
    private String DB_URL = "jdbc:postgresql://localhost:5432/barzastava?characterEncoding=UTF-8";
    private CrudUserRepositoryImpl crudUserRepository;
    private CrudRoleRepositoryImpl crudRoleRepository;
    private static DbConnection instance;


    public void setConnection() {
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","SRr729038");
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(DB_URL, props);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        crudUserRepository = new CrudUserRepositoryImpl(conn);
        crudRoleRepository = new CrudRoleRepositoryImpl(conn);
    }

    public CrudUserRepositoryImpl getUserRepository() {
        return crudUserRepository;
    }

    public CrudRoleRepositoryImpl getCrudRoleRepository() {
        return crudRoleRepository;
    }

    public static DbConnection getInstance() {
        if (instance == null) {
            instance = new DbConnection();
        }
        return instance;
    }

}
