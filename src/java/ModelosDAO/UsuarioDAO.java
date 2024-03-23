
package ModelosDAO;

import Modelos.Usuario;
import Interfaces.usuarioCRUD;
import Configuracion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class UsuarioDAO implements usuarioCRUD {
    
  Conexion cn = new Conexion();
  Connection con; 
  PreparedStatement ps;
  ResultSet rs; 
  Usuario u = new Usuario();

  
  @Override
  public List listarfuncionario() {
    ArrayList<Usuario>listausuario= new ArrayList<>(); 
    String sql = "SELECT * FROM usuarios";
    try {
      con = cn.getConnection(); 
      ps = con.prepareStatement(sql); 
      rs = ps.executeQuery(); 
      while (rs.next()) { 
        Usuario usu = new Usuario();
    
        usu.setId(rs.getInt("Id")); 
        usu.setNombreCompleto(rs.getString("NombreCompleto"));
        usu.setNombreUsuario(rs.getString("NombreUsuario"));
        usu.setEmail(rs.getString("Email"));
        usu.setCelular(rs.getString("Celular"));
        listausuario.add(usu); //AGREGAMOS A LA LISTA LOS VALORES ENCONTRADOS
      }
    } catch (SQLException e) { //SI PRESENTA FALLA ME IMPREME ERROR EN CONSOLA
      System.err.println("Error de consulta SQL ->" + e);
    }
    return listausuario; //RETORNAMOS LA LISTA DE FUNCIONARIO
  }

  @Override
  public boolean agregar(Usuario u) {
    String sql =
      "Insert into usuarios(NombreCompleto,NombreUsuario,Contrasena,Email,Celular) Values ('" +u.getNombreCompleto()+"','" +u.getNombreUsuario()+"','" +u.getContrasena()+"','" +u.getEmail()+"','" +u.getCelular()+"')";
    try {
      con = cn.getConnection();
      ps = con.prepareStatement(sql);
      ps.executeUpdate();
    } catch (SQLException e) {
      System.err.println("Error de consulta SQL ->" + e);
    }
    return false;
  }
  
  @Override
  public Usuario listarunusuario(int id){
      String sql= "Select * from usuarios where Id=" + id;
      try{
          con =cn.getConnection();
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          while(rs.next()){
              u.setId(rs.getInt("Id"));
              u.setNombreCompleto(rs.getString("NombreCompleto"));
              u.setNombreUsuario(rs.getString("NombreUsuario"));
                u.setEmail(rs.getString("Email"));
              u.setCelular(rs.getString("Celular"));
          }          
      }
      catch(SQLException e){
           System.err.println("Error de consulta SQL ->" + e);
      }
      return u;
  }
  
  @Override
public boolean actualizar(Usuario u){
  String sql = "UPDATE usuarios SET NombreCompleto='"+ u.getNombreCompleto()+"', NombreUsuario='"+ u.getNombreUsuario()+"', Contrasena='"+ u.getContrasena()+"', Email='"+ u.getEmail()+"', Celular='"+ u.getCelular() +"' WHERE Id=" + u.getId();

    try{
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.executeUpdate();
    }catch(SQLException e){
        System.err.println("Error de consulta SQL ->" + e);
    }
    return false;
}

  

  
  @Override
  public boolean borrar(int id){
      String sql = "Delete from usuarios where Id="+ id;
      try {
          con = cn.getConnection();
          ps = con.prepareStatement(sql);
          ps.executeUpdate();
      }catch(SQLException e){
      
  }
  
  return false;
}
  @Override
  public Usuario buscarusuariologin(String nombreusuario){
      String sql= "Select * from usuarios where NombreUsuario=" + nombreusuario ;
      try{
          con =cn.getConnection();
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          while(rs.next()){
              u.setId(rs.getInt("Id"));
              u.setNombreCompleto(rs.getString("NombreCompleto"));
              u.setNombreUsuario(rs.getString("NombreUsuario"));
                u.setEmail(rs.getString("Email"));
              u.setCelular(rs.getString("Celular"));
          }          
      }
      catch(SQLException e){
           System.err.println("Error de consulta SQL ->" + e);
      }
      return u;
  }
  
}
