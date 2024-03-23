
package Controladores;
import Modelos.Funcionario;
import ModelosDAO.FuncionarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

public class FuncionarioControlador extends HttpServlet {
        String listado = "Vistas/Funcionario/listar.jsp";
        String insertar = "Vistas/Funcionario/insertar.jsp";
        Funcionario fun = new Funcionario();
        FuncionarioDAO funDAO = new FuncionarioDAO();
        int id;
       
  /*  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FuncionarioControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FuncionarioControlador at " + request.getContextPath() + "</h1>");
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
                  acceso = "Vistas/Funcionario/actualizar.jsp";
              }
              case "borrar" -> {
                 id = Integer.parseInt(request.getParameter("id"));
                  fun.setId(id);
                  funDAO.borrar(id);
                  acceso = listado;
                 
              }
        }
        
        RequestDispatcher cargarvista = request.getRequestDispatcher(acceso);
        cargarvista.forward(request, response);
      //  processRequest(request, response);
    }

        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
        String accion = request.getParameter("accion");
        
        switch(accion){
            case "Guardar" -> {
                String nombre = request.getParameter("nombre");
                String email = request.getParameter("email");
                String celular = request.getParameter("celular");
                fun.setNombre(nombre);
                fun.setEmail(email);
                fun.setCelular(celular);
                funDAO.agregar(fun);
                response.sendRedirect("FuncionarioControlador?accion=listado");
            }
            
            case "Actualizar" -> {
                id = Integer.parseInt(request.getParameter("id"));
                String nombre = request.getParameter("nombre");
                String email = request.getParameter("email");
                String celular = request.getParameter("celular");
                fun.setId(id);
                fun.setNombre(nombre);
                fun.setEmail(email);
                fun.setCelular(celular);
                funDAO.actualizar(fun);
               response.sendRedirect("FuncionarioControlador?accion=listado&id=" + id);
                
            }
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
