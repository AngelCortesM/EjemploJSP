
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Css/bootstrap.css">
        <link rel="stylesheet" href="Css/style.css">
        <title>¡Login de Usuario!</title>
    </head>
    <body>
           <%@include file="../Menu/header.jsp" %>
        <div class="container">
             <br><br>
             <h1>¡Login de Usuario!</h1>
             <form action="UsuarioControlador" method="POST">
              
                 <div class="row">
                     <div class="col-md-6">
                         <label>Nombre de Usuario:</label>  
                         <input type="text" name="nombreusuario" id="nombreusuario" class="form-control" required>
                     </div>
                     <div class="col-md-6">
                         <label>Contraseña:</label>  
                         <input type="password" name="contrasena" id="contrasena" class="form-control" required>
                     </div>
                     
                     
                 </div>
                 
                 <br><br>  <input type="hidden" name="accion" value="login">
                 <div class="alinear">
                 <input type="submit" value="Ingresar"  class="btn btn-success">
                 </div>
                 
             </form>
             
             
             
        </div>
     <%@include file="../Menu/footer.jsp" %>
    </body>
</html>

