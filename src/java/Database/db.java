/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author AsCE
 */
public class db {
    public String  url;
    public String  user;
    public String  pass;
    public String  driver;
    public Connection conexion;
    public ResultSet rs=null;

    public db() {
        this.url = "jdbc:mysql://localhost:3306/prueba";
        this.user = "root";
        this.pass = "  ";
        this.driver = "com.mysql.jdbc.Driver";
    }
    
    public boolean conectar() {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, pass);
            if (conexion != null) {
                System.out.println("Conexion Exitosa A Esquema Base");
                return true;
            }else{
                System.out.println("Conexion Fallida");
                return false;
            }
        } catch (Exception e) {
//            return false;
        }
        return false;
    }
    public ResultSet Consultar(String sql) {
        try {
            if (conectar()) {
                Statement st = conexion.createStatement();
                rs = st.executeQuery(sql);   
            }
            return rs;
        } catch (SQLException a) {
            return null;
        }
    }
    public int Login(String sql) {
        System.out.println(sql);
        int s = 0;
        try {
            if (conectar()) {
                Statement st = conexion.createStatement();
                rs = st.executeQuery(sql);  
                while (rs.next()) {
                    s = rs.getInt("nivel");
                }System.out.println(s+"9999999");
            }
            return s;
        } catch (SQLException a) {
            return s;
        }
    }
}
