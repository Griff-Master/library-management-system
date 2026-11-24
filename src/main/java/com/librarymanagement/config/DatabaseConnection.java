package com.librarymanagement.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnection {
    private static final String DEFAULT_URL =
            "jdbc:mysql://localhost:3306/library_management";
    private static final String DEFAULT_USERNAME = "root";
    private DatabaseConnection(){
        // prevent instantiation
    }
public static Connection getConnection()throws SQLException {
       String url =requiredEnvironmentVariable("DB_URL");
        String username = requiredEnvironmentVariable("DB_USERNAME");
        String password  = requiredEnvironmentVariable("DB_PASSWORD");
        return DriverManager.getConnection(url,username,password);
}
private static String requiredEnvironmentVariable(String name){
        String value = System.getenv(name);
        if(value == null|| value.isBlank()){
            throw new IllegalStateException(
                    "Missing required environment variable" + name
            );
        }
        return value;
}
}
