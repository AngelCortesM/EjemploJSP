package ModelosDAO;

import Modelos.TipoRequerimiento;
import Interfaces.tiporequerimientoCRUD;
import Configuracion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class TipoRequerimientoDAO implements tiporequerimientoCRUD{
      Conexion cn = new Conexion();
  Connection con;
  PreparedStatement ps;
  ResultSet rs;
 
  TipoRequerimiento tp = new TipoRequerimiento();

  @Override
  public List listartiporequerimiento() {
    ArrayList<TipoRequerimiento> listatiporequerimiento = new ArrayList<>(); 
    String sql = "SELECT tp.Id,tp.Nombre,tp.Descripcion,tp.funcionario_id,funcionario.Nombre as NombreFuncionario from tiporequerimiento as tp inner join funcionario on tp.funcionario_id = funcionario.Id;";
    try {
      con = cn.getConnection(); 
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()) { 
           TipoRequerimiento itp = new TipoRequerimiento();

        //VALORES Q VAN A LLEGAR DE LA TABLA
        itp.setId(rs.getInt("Id"));
        itp.setNombre(rs.getString("Nombre"));
        itp.setDescripcion(rs.getString("Descripcion"));
        itp.setfuncionario_id(Integer.parseInt(rs.getString("funcionario_id")));
        itp.setNombreFuncionario(rs.getString("NombreFuncionario"));
        listatiporequerimiento.add(itp); 
      }
    } catch (SQLException e) { //SI PRESENTA FALLA ME IMPREME ERROR EN CONSOLA
      System.err.println("Error de consulta SQL ->" + e);
    }
    return listatiporequerimiento; //RETORNAMOS LA LISTA DE FUNCIONARIO
  }

  @Override
  public boolean agregar(TipoRequerimiento  tp) {
    String sql =
      "Insert into tiporequerimiento(Nombre,Descripcion,funcionario_id) Values ('" +tp.getNombre() +"','" + tp.getDescripcion() +"','" + tp.getfuncionario_id() + "')";
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
  public TipoRequerimiento listaruntiporequerimiento(int id){
      String sql= "Select * from tiporequerimiento where Id=" + id;
      try{
          con =cn.getConnection();
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          while(rs.next()){
              tp.setId(rs.getInt("Id"));
              tp.setNombre(rs.getString("Nombre"));
              tp.setDescripcion(rs.getString("Descripcion"));
              tp.setfuncionario_id(Integer.parseInt(rs.getString("funcionario_id")));
          }          
      }
      catch(SQLException e){
           System.err.println("Error de consulta SQL ->" + e);
      }
      return tp;
  }
  
  @Override
public boolean actualizar(TipoRequerimiento tp){
    String sql = "UPDATE tiporequerimiento SET Nombre='"+ tp.getNombre() +"', Descripcion='"+ tp.getDescripcion() +"', funcionario_id='"+ tp.getfuncionario_id() +"' WHERE Id=" + tp.getId();
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
      String sql = "Delete from tiporequerimiento where Id="+ id;
      try {
          con = cn.getConnection();
          ps = con.prepareStatement(sql);
          ps.executeUpdate();
      }catch(SQLException e){
      
  }
  
  return false;
}
}
