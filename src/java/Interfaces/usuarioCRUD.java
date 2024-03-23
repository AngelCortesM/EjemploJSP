
package Interfaces;

import Modelos.Usuario;
import java.util.List;


public interface usuarioCRUD {
    
    
    public List listarfuncionario(); 
    public boolean agregar(Usuario u);
    public Usuario listarunusuario(int id);
    public boolean actualizar(Usuario u);
    public boolean borrar(int id);
    public Usuario buscarusuariologin(String nombreusuario);
}
