package Interfaces;

//IMPORTAMOS 
import Modelos.Funcionario;
import java.util.List;

//PRIMERO CAMBIAMOS CLASS POR INTERFACE YA Q ES UNA INTERFACE
public interface funcionarioCRUD {
    public List listarfuncionario();//CREAMOS PARAMETRO PUBLICO PARA LISTAR FUNCIONARIO 
    public boolean agregar(Funcionario f);
    public Funcionario listarfuncionario(int id);
    public boolean actualizar(Funcionario f);
    public boolean borrar(int id);
    
}
