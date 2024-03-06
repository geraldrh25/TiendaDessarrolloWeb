/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.*;
public class conexion {
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    public conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","pass123");
            System.out.println("Conectado BD");
                
            } catch (Exception e) {
                System.out.println("Error al conectar BD");
            }
    }
            
    public int Reusuario(String nombres, String usuario, String clave, String correo){
        int res=0;
        try {
            ps=cn.prepareStatement(" insert into usuarios(nombres,usuario,clave,correo)values(?,?,?,?)");
            ps.setString(1, nombres);
            ps.setString(2, usuario);
            ps.setString(3, clave);
            ps.setString(4, correo);
            res=ps.executeUpdate();
            System.out.println("Usuario registrado correctamente!");
        } catch (Exception e) {
            System.out.println("Error al registrar usuario");
            }
        return res;
    }
    
    
    public int Acusuario(String nombres, String usuario, String clave, String correo, String id){
        int res=0;
        try {
            ps=cn.prepareStatement("update usuario set nombres=?, usuario=?, clave=?, correo=? where id_usuario=?");
            ps.setString(1, nombres);
            ps.setString(2, usuario);
            ps.setString(3, clave);
            ps.setString(4, correo);
            ps.setString(5, id);
            res=ps.executeUpdate();
            System.out.println("Datos modificados correctamente");
        } catch (Exception e) {
            
            System.out.println("error al modificar datos");
        }
        return res;
    }
    
    
    
   public int Elusuario(String id){
       int res=0;
       try {
           ps=cn.prepareStatement("delete from usuarios where id_usuario=?");
           ps.setString(1, id);
           res=ps.executeUpdate();
           System.out.println("Usuario eliminado");
       } catch (Exception e) {
           System.out.println("Error al eliminar usuario");
       }
       return res;
   }
}


