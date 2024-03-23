
package Controladores;

import Modelos.TipoRequerimiento;
import ModelosDAO.TipoRequerimientoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TipoRequerimientoControlador extends HttpServlet {
        String listado = "Vistas/TipoRequerimiento/listar.jsp";
        TipoRequerimiento tp = new TipoRequerimiento();
        TipoRequerimientoDAO tpDAO = new TipoRequerimientoDAO();
        int id;
  
   /* protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                   out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TipoRequerimientoControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TipoRequerimientoControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }*/

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                       String acceso = "";
        String accion = request.getParameter("accion");
        
        switch(accion){
            case "listado" -> acceso = listado;     
            case "insertar" -> acceso = "Vistas/TipoRequerimiento/insertar.jsp";
              case "actualizar" -> {
                  request.setAttribute("id", request.getParameter("id"));
                  acceso = "Vistas/TipoRequerimiento/actualizar.jsp";
              }
              case "borrar" -> {
                 id = Integer.parseInt(request.getParameter("id"));
                  tp.setId(id);
                 tpDAO.borrar(id);
                  acceso = listado;
                 
              }             
        }
        
        RequestDispatcher cargarvista = request.getRequestDispatcher(acceso);
        cargarvista.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
  
           String accion = request.getParameter("accion");
        
        switch(accion){
            case "Guardar" -> {
                String nombre = request.getParameter("nombre");
                String descripcion = request.getParameter("descripcion");
                int funcionario_id = Integer.parseInt(request.getParameter("funcionario_id")) ;
        
               tp.setNombre(nombre);
               tp.setDescripcion(descripcion);
               tp.setfuncionario_id(funcionario_id);
        
               
              tpDAO.agregar(tp);
                response.sendRedirect("TipoRequerimientoControlador?accion=listado");
            }
            
            case "Actualizar" -> {
                id = Integer.parseInt(request.getParameter("id"));
                String nombre = request.getParameter("nombre");
                String descripcion = request.getParameter("descripcion");
                int funcionario_id = Integer.parseInt(request.getParameter("funcionario_id")) ;
                System.err.println("Nombre"+nombre);
                        System.err.println("Descripcion"+descripcion);
                                System.err.println("funcionario_id"+funcionario_id);
                                        System.err.println("Id"+id);
                tp.setId(id);
               tp.setNombre(nombre);
               tp.setDescripcion(descripcion);
               tp.setfuncionario_id(funcionario_id);        
               tpDAO.actualizar(tp);
               response.sendRedirect("TipoRequerimientoControlador?accion=listado");
                
            }
        }
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
