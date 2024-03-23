<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.Iterator" %>
<%@page import="Modelos.TipoRequerimiento" %>
<%@page import="ModelosDAO.TipoRequerimientoDAO" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" href="Css/bootstrap.css">
        <link rel="stylesheet" href="Css/style.css">
        <title>Listado Tipo de Requerimiento</title>
    </head>
    <body>
        <%@include file="../Menu/header.jsp" %>
        <div class="container">
        <h1>Listado Tipo de Requerimiento</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>Nombre Tipo de Requerimiento</th>
                    <th>Decripcion</th>
                    <th>Funcionario Responsable</th>
                    <th>Acciones</th>
                </tr> 
            </thead>

            <tbody>
            <% 
                TipoRequerimientoDAO tpDAO = new TipoRequerimientoDAO();
                List<TipoRequerimiento>lista=tpDAO.listartiporequerimiento();
                Iterator<TipoRequerimiento>iterrequerimiento=lista.iterator();
                TipoRequerimiento tp=null;
                while(iterrequerimiento.hasNext()){
                    tp=iterrequerimiento.next();
            %>
               <tr>
                  <td><%= tp.getNombre() %></td>
                 <td><%= tp.getDescripcion() %></td>
                 <td><%= tp.getNombreFuncionario() %></td>
                <td>
                    <a href="TipoRequerimientoControlador?accion=actualizar&id=<%= tp.getId() %>" class="btn btn-info">Actualizar</a>
                    <button class="btn btn-danger" onclick="borrar(<%= tp.getId() %>)">Eliminar</button>    
                </td>
                </tr>
            <%  }  %>
            </tbody>
                       
        </table>
        </div>
            <script>
                function borrar(id){
             var verificar = confirm("Desea borrar el registro numero: " + id);
              if(verificar){
                  location.href = "TipoRequerimientoControlador?accion=borrar&id=" + id;
              }
                          }
            </script> 
            
        <%@include file="../Menu/footer.jsp" %>
    </body>
</html>