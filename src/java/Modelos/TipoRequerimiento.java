package Modelos;


public class TipoRequerimiento {
     int Id;
    String Nombre;
    String Descripcion;
    int funcionario_id;
    String NombreFuncionario;
    
    //CREAMOS METODO CONSTRUCTOR
    public TipoRequerimiento(){  }//<--AQUI PUEDO CONTROLAR VALIDACIONES EN GENERAL
    
    //CONSTRUIMOS METODOS MAGICOS!!!
    public int getId(){
        return Id;
    }
    public void setId(int id){
        Id = id;
    }
    
      public String getNombreFuncionario(){
        return NombreFuncionario;
    }
    public void setNombreFuncionario(String nombrefuncionario){
        NombreFuncionario = nombrefuncionario;
    }
        
    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String nombre){
        Nombre = nombre;
    }
    
    public String getDescripcion(){
        return Descripcion;
    }
    public void setDescripcion(String descripcion){
        Descripcion = descripcion;
    }
    
    public int getfuncionario_id(){
        return funcionario_id;
    }
    public void setfuncionario_id(int id_funcionario){
        funcionario_id = id_funcionario;
    }
}
