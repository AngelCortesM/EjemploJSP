


<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelos.TipoRequerimiento" %>
<%@page import="ModelosDAO.TipoRequerimientoDAO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Css/bootstrap.css">
        <link rel="stylesheet" href="Css/style.css">
        <title>Radicar Pqrs</title>
    </head>
    <body>
       <%@include file="../Menu/header.jsp" %>
        <div class="container">
             <h1>Formulario Pqrs</h1>
             <form action="FuncionarioControlador" method="POST">
                 <div class="row">
                     <div class="col-md-4">
                         <label>Fecha:</label>  
                         <input type="date" name="fecha" id="fecha" class="form-control" required>
                     </div>
                          <div class="col-md-4">
                         <label>Descripcion:</label>  
                         
                         <textarea class="form-control" name="descripcion" id="descripcion" required></textarea>
                     </div>
                     <div class="col-md-4">
                         <label>Tipo de Requerimiento</label>  
                         <select name="requerimiento_id" id="requerimiento_id" class="form-control" required>
                             <%
                                 TipoRequerimientoDAO trDAO = new TipoRequerimientoDAO();
                                 List<TipoRequerimiento>lista= trDAO.listartiporequerimiento();
                                 Iterator<TipoRequerimiento>itertiporequerimiento =lista.iterator();
                                 TipoRequerimiento tr=null;
                                 while(itertiporequerimiento.hasNext()){
                                 tr=itertiporequerimiento.next();
                                 
                             %>
                                                          
                             <option value="<%= tr.getId() %>" ><%= tr.getNombre() %></option>
                                      <%  }  %>
                         </select>
                     </div>
                     
                 </div><br><br>
                 <div class="alinear">
                 <input type="submit" value="Guardar" name="accion" class="btn btn-success">
                 </div>
             </form>
             
             
             
        </div>
          <%@include file="../Menu/footer.jsp" %>
    </body>
</html>
