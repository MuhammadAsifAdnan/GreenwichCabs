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
    private Connection conn = null; // A connection object is used to provide access to a database
    private ResultSet rows = null;
    
    private String connectionString = "jdbc:derby://localhost:1527/greenwichcabs";
    private String userName = "asif";
    private String password = "Wonder4U";
    
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
//    
//        private static void databaseConnection() {
//        
//        try{
//            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/greenwichcabs", "asif", "Wonder4U");
//            // Statement objects executes a SQL query
//            // createStatement returns a Statement object
//            Statement sqlStatement = conn.createStatement();
//            String selectStuff = "Select * from Drivers";
//            ResultSet rows = sqlStatement.executeQuery(selectStuff);
//            
//            while(rows.next()){
//                System.out.println(rows.getString("ID"));
//                System.out.println(rows.getString("FIRSTNAME") + " " + rows.getString("LASTNAME"));
//                System.out.println(rows.getString("ssn"));
//            }
//            
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//    }
    
}
