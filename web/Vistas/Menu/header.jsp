       <nav class="navbar bg-dark navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
            <div class="container-fluid">
    <a class="navbar-brand" href="#">Protecyo PQRS</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
       
       
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Usuario
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="UsuarioControlador?accion=insertar">Regristar un Usuario</a></li>
            <li><a class="dropdown-item" href="UsuarioControlador?accion=listado">Listado de Usuarios</a></li>
          </ul>
        </li>
     
         <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Funcionario
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="FuncionarioControlador?accion=insertar">Regristar un Funcionario</a></li>
            <li><a class="dropdown-item" href="FuncionarioControlador?accion=listado">Listado de Funcionarios</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Tipo de Requerimiento
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="TipoRequerimientoControlador?accion=insertar">Regristar Tipo</a></li>
            <li><a class="dropdown-item" href="TipoRequerimientoControlador?accion=listado">Listado de Tipo</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            PQRS
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="PqrsControlador?accion=insertar">Radicar PQRS</a></li>
            <li><a class="dropdown-item" href="PqrsControlador?accion=listado">Mis PQRS</a></li>
          </ul>
        </li>
      </ul>
      <form class="d-flex" role="search">
          <div style="padding-left: 10px">
        <a class="btn btn-outline-success" href="UsuarioControlador?accion=login" >Login</a>
        <a class="btn btn-outline-success" href="UsuarioControlador?accion=logout"  >logout</a>
        </div>
      </form>
    </div>
  </div>
        </nav>