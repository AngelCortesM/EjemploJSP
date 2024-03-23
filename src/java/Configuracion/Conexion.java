
package Configuracion;
//IMPORTAMOS TODAS LAS LIBRERIAS DE SQL
import java.sql.*;

public class Conexion {
    //PROPIEDAD GUARDADA EN VARIABLE CON
    Connection con;
    
    //METODO CONSTRUCTOR PARA EL INICIO DE LA CONEXION
    public Conexion(){
        //REALIZAMOS UN TRY-CATCH PARA Q ME INFORME SI LA CONEXION FALLA
        try {
            Class.forName("com.mysql.jdbc.Driver");//INTENTA CONECTAR CON LIBRERIA MYSQL CONECCION
            //AL PARAMETRO CON DAMOS LOS PARAMETROS PARA Q SE CONECTE -->
            con=DriverManager.getConnection("jdbc:mysql://localhost:3307/proyectopqrs","root","");
        } catch (ClassNotFoundException | SQLException e){// SI NO CONECTA CAPTURA EL ERROR EN VARIABLE -->E
            System.err.println("Error en Conexion"+e);//MUESTRA UNA IMPRESION EN CONSOLA DEL ERROR        
        }
    }
    //CREAMOS EL METODO PARA PODER CAPTURAR O OPTENER LA INFORMACION
    public Connection getConnection(){
        return con;
    }
    
}
