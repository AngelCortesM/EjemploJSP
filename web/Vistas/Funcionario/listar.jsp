<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.Iterator" %>
<%@page import="Modelos.Funcionario" %>
<%@page import="ModelosDAO.FuncionarioDAO" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" href="Css/bootstrap.css">
        <link rel="stylesheet" href="Css/style.css">
        <title></title>
    </head>
    <body>
        <%@include file="../Menu/header.jsp" %>
        <div class="container">
        <h1>Listado de Funcionarios</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>Nombre Completo</th>
                    <th>Email</th>
                    <th>Celuar</th>
                    <th>Acciones</th>
                </tr> 
            </thead>

            <tbody>
            <% 
                FuncionarioDAO fundao = new FuncionarioDAO();
                List<Funcionario>lista=fundao.listarfuncionario();
                Iterator<Funcionario>iterfuncionario=lista.iterator();
                Funcionario fun=null;
                while(iterfuncionario.hasNext()){
                    fun=iterfuncionario.next();
            %>
               <tr>
                  <td><%= fun.getNombre() %></td>
                 <td><%= fun.getEmail() %></td>
                 <td><%= fun.getCelular() %></td>
                <td>
                    <a href="FuncionarioControlador?accion=actualizar&id=<%= fun.getId() %>" class="btn btn-info">Actualizar</a>
                    <button class="btn btn-danger" onclick="borrar(<%= fun.getId() %>)">Eliminar</button>    
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
                  location.href = "FuncionarioControlador?accion=borrar&id=" + id;
              }
                          }
            </script> 
            
        <%@include file="../Menu/footer.jsp" %>
    </body>
</html>