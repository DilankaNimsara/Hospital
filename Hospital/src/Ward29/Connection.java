/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ward29;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dilanka Nimsara
 */
public class Connection {

    public static java.sql.Connection getConnection() {
        java.sql.Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
//            con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ASUS\\Documents\\hospital.sqlite");
//            con = DriverManager.getConnection("jdbc:sqlite:hospital.sqlite");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
