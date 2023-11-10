/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.conexion;
import Modelo.Cliente;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Axel
 */
public class ClienteDAO extends conexion{
    
    public void addCliente(Cliente cli) {
        try {
            this.conectar();
            String sql = "insert into cliente (nombre, documento, correo, telefono)"
                        + " values(?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, cli.getNombre());
            pre.setInt(2, cli.getDocumento());
            pre.setString(3, cli.getCorreo());
            pre.setString(4, cli.getTelefono());
            pre.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<Cliente> listaClientes(){
        ArrayList<Cliente> lista = new ArrayList();
        try {
            this.conectar();
            String sql = "select * from cliente";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente();
                c.setCodigo(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setDocumento(rs.getInt(3));
                c.setCorreo(rs.getString(4));
                c.setTelefono(rs.getString(5));
                lista.add(c);
            }
        } catch (Exception e) {
        }
        return lista;
    }
}
