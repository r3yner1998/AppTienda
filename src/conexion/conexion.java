/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Sistemas
 */
public class conexion {
    private Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    public void conectar()throws Exception{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/tombodb","root","");
        } catch (Exception e) {
            throw e;
        }
    }
    public void desconectar()throws Exception{
        try {
            if (con!=null) {
                if (con.isClosed()==false) {
                    con.close();
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
