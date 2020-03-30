/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ward29;

import java.sql.DriverManager;

/**
 *
 * @author Dilanka Nimsara
 */
public class Connection {
    public static java.sql.Connection getConnection(){
        java.sql.Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
            return con;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
