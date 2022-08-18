/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.o7services.loginregister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author o7solutions
 */
public class JdbcConnection {
    
    private static JdbcConnection instance = null;
    public Connection connection;
    
    private JdbcConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginRegister", "root", "");
            String statement = "CREATE TABLE IF NOT EXISTS user(email varchar(255), password varchar(255), name varchar(255))";
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    
    public static JdbcConnection getInstance(){
        if(instance == null){
            instance = new JdbcConnection();
        }
        return instance;
    }
    
}
