/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms;
import java.sql.DriverManager;
import java.sql.Connection;

/**
 *
 * @author Indra
 */
public class DBConnection {
    static Connection con = null;
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/lms","root","");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
