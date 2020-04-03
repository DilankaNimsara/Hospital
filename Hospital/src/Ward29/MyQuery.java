/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ward29;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dilanka Nimsara
 */
class MyQuery {
    
    String date1;
    void dates(String date1){
        this.date1=date1;
    }

    public ArrayList<Product2> BindTable1() {

        ArrayList<Product2> list = new ArrayList<Product2>();
        java.sql.Connection con = Connection.getConnection();
        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery("select img_title,img_data,date from barcode ORDER BY date DESC");

            Product2 p;
            while (rs.next()) {
                p = new Product2(
                        rs.getString("img_title"),
                        rs.getBytes("img_data"),
                        rs.getString("date")
                );
                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<Product2> BindTable() {

        ArrayList<Product2> list = new ArrayList<Product2>();
        java.sql.Connection con = Connection.getConnection();
        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery("select img_title,img_data,date from barcode where date = '" + date1 + "' ORDER BY date DESC");

            Product2 p;
            while (rs.next()) {
                p = new Product2(
                        rs.getString("img_title"),
                        rs.getBytes("img_data"),
                        rs.getString("date")
                );
                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}

class Product2 {

    private String name;
    private String date;
    private byte[] Image;

    public Product2() {
    }

    public Product2(String Name, byte[] image, String date) {

        this.name = Name;
        this.Image = image;
        this.date = date;

    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public void setDate(String Date) {
        this.date = Date;
    }

    public byte[] getMyImage() {
        return Image;
    }
}
