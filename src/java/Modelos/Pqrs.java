
package Modelos;


public class Pqrs {
    int Id;
    String Fecha;
   String Descripcion;
    String Estado;
    int usuarios_id;
    int tiporequerimiento_id;
    
    public int getId(){
        return Id;
              
    }
    public void setId(int id){
    Id = id;
    }
    
    public String getFecha(){
        return Fecha;
              
    }
    public void setFecha(String fecha){
    Fecha = fecha;
    }
    
    public String getDescripcion(){
        return Descripcion;
              
    }
    public void setDescripcion(String descripcion){
    Descripcion = descripcion;
    }
    
    public String getEstado(){
        return Estado;
              
    }
    public void setEstado(String estado){
    Estado = estado;
    }
    
       public int getusuarios_id(){
        return usuarios_id;
              
    }
    public void setusuarios_id(int id_usuarios){
    Id = id_usuarios;
    }
    
       public int gettiporequerimiento_id(){
        return tiporequerimiento_id;
              
    }
    public void settiporequerimiento_id(int id_tiporequerimiento){
    tiporequerimiento_id = id_tiporequerimiento;
    }
}
