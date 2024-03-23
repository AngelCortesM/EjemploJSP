
package Interfaces;

import Modelos.TipoRequerimiento;
import java.util.List;

public interface tiporequerimientoCRUD {
        public List listartiporequerimiento(); 
    public boolean agregar(TipoRequerimiento tp);
    public TipoRequerimiento listaruntiporequerimiento(int id);
    public boolean actualizar(TipoRequerimiento tp);
    public boolean borrar(int id);
}
