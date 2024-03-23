<%@page import="Modelos.Usuario" %>
<%@page import="ModelosDAO.UsuarioDAO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="Css/bootstrap.css">
    <link rel="stylesheet" href="Css/style.css">
    <title>Formulario Actualizar Usuario</title>
</head>

<body>
    <%@include file="../Menu/header.jsp" %>
    <%
             UsuarioDAO usuDAO = new UsuarioDAO();
             int id = Integer.parseInt(request.getParameter("id"));                      
             Usuario usu = (Usuario)usuDAO.listarunusuario(id);
            %>
    <div class="container">
        <h1>Formulario Actualizar Funcionario</h1>
        <form action="UsuarioControlador" method="POST">
         <div class="row">
              <input type="hidden" name="id" id="id" value="<%= usu.getId() %>">
                     <div class="col-md-4">
                         <label>Nombre Completo:</label>  
                         <input type="text" name="nombrecompleto" id="nombrecompleto" class="form-control" value="<%= usu.getNombreCompleto() %>" required>
                     </div>
                          <div class="col-md-4">
                         <label>Nombre Usuario:</label>  
                         <input type="text" name="nombreusuario" id="nombreusuario" class="form-control" value="<%= usu.getNombreUsuario() %>" required>
                     </div>
                     <div class="col-md-4">
                         <label>Contraseña:</label>  
                         <input type="password" name="contrasena" id="contrasena" class="form-control" required autocomplete="current-password">

                     </div>
                     
                 </div>
                 <div class="row">
                     <div class="col-md-6">
                         <label>Email:</label>  
                         <input type="email" name="email" id="email" class="form-control" value="<%= usu.getEmail() %>" required>
                     </div>
                     <div class="col-md-6">
                         <label>Celular:</label>  
                         <input type="number" name="celular" id="celular" class="form-control" value="<%= usu.getCelular() %>" required>
                     </div>
                     
                      
                 </div>
                 <br><br>
            <div class="alinear">
                <input type="submit" value="Actualizar" name="accion" class="btn btn-success">
            </div>
        </form>



    </div>
  <%@include file="../Menu/footer.jsp" %>
</body>

</html>