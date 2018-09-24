<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
  <meta charset="UTF-8">
  <title>Início</title>
  <link rel="stylesheet" type="text/css" href="node_modules/bulma/css/bulma.css">
  <link rel="stylesheet" type="text/css" href="css/estilo.css">
  <link rel="stylesheet" type="text/css" href="node_modules/fontawesome-free/css/all.css">
</head>

<body>


  <div class="hero columns is-vcentered">
    <div class="hero-body has-text-centered">
      <div class="title is-4">Selecione a Operação:</div>
      <a class="button is-primary" href="mvc?logica=ListaLivroLogic"> <span style= "padding-right: 0.5em;" > <i class="fas fa-bars"> </i> </span>Listar Livros</a>
      <a class="button is-primary" href="mvc?logica=ListaAlunoLogic"> <span style= "padding-right: 0.5em;" > <i class="fas fa-bars"> </i> </span>Listar Alunos</a>
      <a class="button is-warning" href="mvc?logica=ListaEmprestimosLogic"> <span style= "padding-right: 0.5em;" > <i class="fas fa-bars"> </i> </span>Emprestimos</a>
      <a class="button is-info" href="formLivro.jsp"><span style= "padding-right: 0.2em;" > <i class="fas fa-plus"> </i>  Adicionar Livro</a>
      <a class="button is-info" href="formAluno.jsp"><span style= "padding-right: 0.2em;" > <i class="fas fa-plus"> </i>  Adicionar Aluno</a>
    </div>

  </div>
  
</body>

</html>
