package Modelos;

public class Usuario {
    int Id;
    String NombreCompleto;
    String NombreUsuario;
    String Contrasena;
    String Email;
    String Celular;
    
    public void setId(int id){
       this.Id = id;
    }
    public int getId(){
       return this.Id;
    }
    
    public void setNombreCompleto(String nombrecompleto){
        this.NombreCompleto = nombrecompleto;
    }
    public String getNombreCompleto(){
        return this.NombreCompleto;
    }
    
    public void setNombreUsuario(String nombreusuario){
        this.NombreUsuario = nombreusuario;
    }
    public String getNombreUsuario(){
        return this.NombreUsuario;
    }
    
    public void setContrasena(String contrasena){
        this.Contrasena = contrasena;
    }
    public String getContrasena(){
        return this.Contrasena;
    }
    
    public void setEmail(String email){
        this.Email = email;
    }
    public String getEmail(){
        return this.Email;
    }
    
    public void setCelular(String celular){
        this.Celular = celular;
    }
    public String getCelular(){
        return this.Celular;
    }
    
}
