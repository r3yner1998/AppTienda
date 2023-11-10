/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.conexion;
import Modelo.Proveedor;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Sistemas
 */
public class ProveedorDAO extends conexion {

    public void addProveedor(Proveedor pro) {
        try {
            this.conectar();
            String sql = "insert into proveedor (nombre, documento, correo, telefono)"
                        + " values(?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, pro.getNombre());
            pre.setInt(2, pro.getDocumento());
            pre.setString(3, pro.getCorreo());
            pre.setString(4, pro.getTelefono());
            pre.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateProveedor(Proveedor pro) {
        try {
            this.conectar();
            String sql = "Update proveedor set nombre = ?, documento = ?, correo = ?, telefono = ? where codigo = ?";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setString(1, pro.getNombre());
            pre.setInt(2, pro.getDocumento());
            pre.setString(3, pro.getCorreo());
            pre.setString(4, pro.getTelefono());
            pre.setInt(5, pro.getCodigo());
            pre.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void deleteProveedor(int cod){
        try {
            this.conectar();
            String sql = "delete from proveedor where codigo = ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(0, cod);
            pre.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public ArrayList<Proveedor> listaProvedores(){
        ArrayList<Proveedor> lista = new ArrayList();
        try {
            this.conectar();
            String sql = "select * from proveedor";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Proveedor p = new Proveedor();
                p.setCodigo(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setDocumento(rs.getInt(3));
                p.setCorreo(rs.getString(4));
                p.setTelefono(rs.getString(5));
                lista.add(p);
            }
        } catch (Exception e) {
        }
        return lista;
    }
}
