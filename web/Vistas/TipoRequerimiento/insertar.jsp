   

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
        <title>Formulario Insertar Nuevo Tipo de Requerimineto</title>
    </head>
    <body>
       <%@include file="../Menu/header.jsp" %>
        <div class="container">
             <h1>Formulario Tipo de Requerimiento</h1>
             <form action="TipoRequerimientoControlador" method="POST">
                 <div class="row">
                     <div class="col-md-4">
                         <label>Nombre:</label>  
                         <input type="text" name="nombre" id="nombre" class="form-control" required>
                     </div>
                          <div class="col-md-4">
                         <label>Descripcion:</label>  
                         <input type="text" name="descripcion" id="descripcion" class="form-control" required>
                     </div>
                     <div class="col-md-4">
                         <label>Funcionario:</label>  
                         <select name="funcionario_id" id="funcionario_id" class="form-control">
                            
                                  <% 
                FuncionarioDAO fundao = new FuncionarioDAO();
                List<Funcionario>lista=fundao.listarfuncionario();
                Iterator<Funcionario>iterfuncionario=lista.iterator();
                Funcionario fun=null;
                while(iterfuncionario.hasNext()){
                    fun=iterfuncionario.next();
                                   %>
                                   <option value="<%= fun.getId() %>"> <%= fun.getNombre() %> </option>
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
