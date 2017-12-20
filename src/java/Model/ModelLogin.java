/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.db;
import java.sql.ResultSet;

/**
 *
 * @author AsCE
 */
public class ModelLogin {

    private String name, password;
    db bd= new db();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int validate() {
        String sql="SELECT nivel from usuario where user='"+getName()+"' and pass='"+getPassword()+"'";
        System.out.println(bd.Login(sql)+"8888");
        return bd.Login(sql);
    }
}
