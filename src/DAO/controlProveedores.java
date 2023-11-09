/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.conexion;
import modelo.Proveedor;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Sistemas
 */
public class controlProveedores extends conexion{
    public void insertarPersona(Proveedor pro) throws Exception{
        try {
            this.conectar();
            String sql="insert into proveedor (codigo, nombre, documento, correo, telefono)"
                    + " values(?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, pro.getCodigo());
            pre.setString(2, pro.getNombre());
            pre.setInt(3, pro.getDocumento());
            pre.setString(4, pro.getCorreo());
            pre.setInt(5,pro.getTelefono());
            pre.executeUpdate();
             
        } catch (Exception e) {
            throw e;
        }
    }
}
