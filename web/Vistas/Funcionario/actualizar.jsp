<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelos.Funcionario" %>
<%@page import="ModelosDAO.FuncionarioDAO" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="Css/bootstrap.css">
    <link rel="stylesheet" href="Css/style.css">
    <title>Formulario Actualizar Funcionario</title>
</head>

<body>
    <%@include file="../Menu/header.jsp" %>
    <%
             FuncionarioDAO funDAO = new FuncionarioDAO();
             int id = Integer.parseInt(request.getParameter("id"));                      
             Funcionario fun = (Funcionario)funDAO.listarfuncionario(id);
            %>
    <div class="container">
        <h1>Formulario Actualizar Funcionario</h1>
        <form action="FuncionarioControlador" method="POST">
            <div class="row">
                
                <input type="hidden" name="id"  id="id" value="<%= fun.getId() %>">

                <div class="col-md-4">
                    <label>Nombre:</label>
                    <input type="text" name="nombre" id="nombre" class="form-control" value="<%= fun.getNombre() %>"
                        required>
                </div>
                <div class="col-md-4">
                    <label>Email:</label>
                    <input type="email" name="email" id="email" class="form-control" value="<%= fun.getEmail() %>"
                        required>
                </div>
                <div class="col-md-4">
                    <label>Celular:</label>
                    <input type="number" name="celular" id="celular" class="form-control" value="<%= fun.getCelular() %>" required>
                </div>

            </div><br><br>
            <div class="alinear">
                <input type="submit" value="Actualizar" name="accion" class="btn btn-success">
            </div>
        </form>



    </div>
      <%@include file="../Menu/footer.jsp" %>
</body>

</html>