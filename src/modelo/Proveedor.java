/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Sistemas
 */
public class Proveedor extends Persona{
    
    public Proveedor(){
        
    }
    
    public Proveedor(int codigo, String nombre, int documento, String correo, String telefono){
        super(codigo, nombre, documento, correo, telefono);
    }
   public Proveedor(String nombre, int documento, String correo, String telefono){
       super(nombre, documento, correo, telefono);
   }

}
