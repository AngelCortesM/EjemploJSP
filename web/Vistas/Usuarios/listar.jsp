<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.Iterator" %>
<%@page import="Modelos.Usuario" %>
<%@page import="ModelosDAO.UsuarioDAO" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="Css/bootstrap.css">
    <link rel="stylesheet" href="Css/style.css">
    <title>Listado de Usuarios</title>
</head>

<body>
    <%@include file="../Menu/header.jsp" %>
    <div class="container">
        <h1>Listado de Usuarios del Sistema</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>Nombre Completo</th>
                    <th>Nombre de Usuario</th>
                    <th>Email</th>
                    <th>Celuar</th>
                    <th>Acciones</th>
                </tr>
            </thead>

            <tbody>
                <% 
                UsuarioDAO usudao = new UsuarioDAO();
                List<Usuario>lista=usudao.listarfuncionario();
                Iterator<Usuario>iterusuario=lista.iterator();
                Usuario usu=null;
                while(iterusuario.hasNext()){
                    usu=iterusuario.next();
            %>
                <tr>
                    <td><%= usu.getNombreCompleto() %></td>
                    <td><%= usu.getNombreUsuario()%></td>
                    <td><%= usu.getEmail()%></td>
                    <td><%= usu.getCelular() %></td>
                    <td>
                        <a href="UsuarioControlador?accion=actualizar&id=<%= usu.getId() %>"
                            class="btn btn-info">Actualizar</a>
                        <button class="btn btn-danger" onclick="borrar(<%= usu.getId() %>)">Eliminar</button>
                    </td>
                </tr>
                <%  }  %>
            </tbody>

        </table>
    </div>
    <script>
        function borrar(id) {
            var verificar = confirm("Desea borrar el registro numero: " + id);
            if (verificar) {
                location.href = "UsuarioControlador?accion=borrar&id=" + id;
            }
        }
    </script>

    <%@include file="../Menu/footer.jsp" %>
</body>

</html>