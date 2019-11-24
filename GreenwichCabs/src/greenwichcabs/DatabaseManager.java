/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwichcabs;

import java.sql.*;

/**
 *
 * @author user
 */
public class DatabaseManager {   
    private final String connectionString = "jdbc:derby://localhost:1527/greenwichcabsDB";
    private final String userName = "anika";
    private final String password = "asif";
    
    private ResultSet rows = null;
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionString, userName, password);
    }
    
    public ResultSet executeQuery(Connection conn, String sqlQuery) throws SQLException {
        Statement sqlStatement = conn.createStatement();
        // Statement objects executes a SQL query
        // createStatement returns a Statement object
        rows = sqlStatement.executeQuery(sqlQuery);
        return rows;
    }
    
    // for insert, update, delete operations
    public int executeUpdate(Connection conn, String sqlQuery) throws SQLException {
    Statement sqlStatement = conn.createStatement();
    // Statement objects executes a SQL query
    // createStatement returns a Statement object
    // executeUpdate method executes insert, update, delete operation. if the return value is 0, the operation
    // failed. if greater than 0, it succeded
    return sqlStatement.executeUpdate(sqlQuery);
    }    
}
