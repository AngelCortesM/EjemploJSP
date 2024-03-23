
package Controladores;


import Modelos.Pqrs;
import ModelosDAO.PqrsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PqrsControlador extends HttpServlet {
        String listado = "Vistas/Pqrs/listar.jsp";
        String insertar = "Vistas/Pqrs/insertar.jsp";
        Pqrs pqrs = new Pqrs();
        PqrsDAO pqrsDAO = new PqrsDAO();
        int id;
 /*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PqrsControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PqrsControlador at " + request.getContextPath() + "</h1>");
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
            case "insertar" -> acceso = insertar;
              case "actualizar" -> {
                  request.setAttribute("id", request.getParameter("id"));
                  acceso = "Vistas/Pqrs/actualizar.jsp";
              }
              case "borrar" -> {
                 id = Integer.parseInt(request.getParameter("id"));
                  pqrs.setId(id);
           //       PqrsDAO.borrar(id);
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
               String fecha = request.getParameter("fecha");
                String descripcion = request.getParameter("descripcion");
                int requerimiento_id = Integer.parseInt(request.getParameter("requerimiento_id"));
                String estado = "En proceso";
                pqrs.setFecha(fecha);
                pqrs.setDescripcion(descripcion);
                pqrs.settiporequerimiento_id(requerimiento_id);
                pqrs.setEstado(estado);
                pqrs.setusuarios_id(id);
            //    pqrsDAO.
               response.sendRedirect("FuncionarioControlador?accion=listado&id=" + id);
                
            }
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
