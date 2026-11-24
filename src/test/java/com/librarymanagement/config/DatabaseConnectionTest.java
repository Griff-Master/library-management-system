package com.librarymanagement.config;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DatabaseConnectionTest {
     @Test
    void shouldEstablishDatabaseConnection()throws SQLException{
         try(Connection connection = DatabaseConnection.getConnection()){
             assertNotNull(connection);
             assertTrue(connection.isValid(2));
         }
     }
}
