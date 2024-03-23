package ModelosDAO;

import Configuracion.Conexion;
import Interfaces.funcionarioCRUD;
import Modelos.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO implements funcionarioCRUD {

  //PARAMETROS CORRESPONDIENTES DE ESTE DAO
  //DECIMOS Q EN CONEXION INSTANCIE LA LIBRERIA CONEXION
  Conexion cn = new Conexion(); //INSTANCIA DE CONEXION
  Connection con; //CREAMOS UNA VARIABLE CON CONEXION PARA GUARDAR INFORMACION

  //DOS COSAS EN PARTICULAR, UN RESULT SET <- RESULTADO DE UNA CONSULTA SQL
  //Y UN PREPAREDSTATEMENT Q ES LA CONSULTA SQL EN DB
  PreparedStatement ps;
  ResultSet rs;
  //LLAMAMOS EL METODO PARA GUARDAR LA INFORMACION (¡¡FUNCIONARIO!!)
  Funcionario f = new Funcionario();

  @Override
  //CREAMOS METODO Q PERMITE REALIZAR CONSULTA
  public List listarfuncionario() {
    ArrayList<Funcionario> listafuncionario = new ArrayList<>(); //CREAMOS UN ARRAY LIST PARA GUARDAR LA INFORMACION
    String sql = "SELECT * FROM funcionario";
    try {
      con = cn.getConnection(); //INTENTA CONECTAR DB
      ps = con.prepareStatement(sql); //ME TRAE LA INFORMACION
      rs = ps.executeQuery(); //
      while (rs.next()) { //REALIZA EL RECORRIDO BUSCANDO LA INFORMACION YA Q LLEGA COMO UN OBJETO
        Funcionario fun = new Funcionario();
        //VALORES Q VAN A LLEGAR DE LA TABLA
        fun.setId(rs.getInt("Id"));
        fun.setNombre(rs.getString("Nombre"));
        fun.setEmail(rs.getString("Email"));
        fun.setCelular(rs.getString("Celular"));
        listafuncionario.add(fun); //AGREGAMOS A LA LISTA LOS VALORES ENCONTRADOS
      }
    } catch (SQLException e) { //SI PRESENTA FALLA ME IMPREME ERROR EN CONSOLA
      System.err.println("Error de consulta SQL ->" + e);
    }
    return listafuncionario; //RETORNAMOS LA LISTA DE FUNCIONARIO
  }

  @Override
  public boolean agregar(Funcionario f) {
    String sql =
      "Insert into funcionario(Nombre,Email,Celular) Values ('" +
      f.getNombre() +
      "','" +
      f.getEmail() +
      "','" +
      f.getCelular() +
      "')";
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
  public Funcionario listarfuncionario(int id){
      String sql= "Select * from funcionario where Id=" + id;
      try{
          con =cn.getConnection();
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          while(rs.next()){
              f.setId(rs.getInt("Id"));
              f.setNombre(rs.getString("Nombre"));
              f.setEmail(rs.getString("Email"));
              f.setCelular(rs.getString("Celular"));
          }          
      }
      catch(SQLException e){
           System.err.println("Error de consulta SQL ->" + e);
      }
      return f;
  }
  
  @Override
public boolean actualizar(Funcionario f){
    String sql = "UPDATE funcionario SET Nombre='"+ f.getNombre() +"', Email='"+ f.getEmail() +"', Celular='"+ f.getCelular() +"' WHERE Id=" + f.getId();
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
      String sql = "Delete from funcionario where Id="+ id;
      try {
          con = cn.getConnection();
          ps = con.prepareStatement(sql);
          ps.executeUpdate();
      }catch(SQLException e){
      
  }
  
  return false;
}
}
