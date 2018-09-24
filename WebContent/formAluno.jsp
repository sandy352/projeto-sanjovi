<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar Livros</title>

<link rel="stylesheet" type="text/css"
	href="node_modules/bulma/css/bulma.css">
<link rel="stylesheet" type="text/css" href="css/estilo.css">
 <link rel="stylesheet" type="text/css" href="node_modules/fontawesome-free/css/all.css">

</head>
<body>
<c:import url="/WEB-INF/jsp/cabecalho.jsp"></c:import>

	<form action="mvc?" class="box is-info">
		<h1 class="title is-3">Adicionar Aluno</h1>
		<input type="hidden" name="logica" value="AdicionaAlunoLogic">
		<div>
			<label class="label">Nome: </label> <input type="text"
				placeholder="Fernando Soares" name="nome" class="input is-half">
		</div>
		<div>
			<label class="label">Matrícula: </label> <input type="text" name="matricula"
				placeholder="123412" class="input is-half">
		</div>
		<div>
			<label class="label">Endereço: </label> <input type="text" name="endereco"
				placeholder="Rua das Carretas, 234" class="input is-half">
		</div>
		
		<div>
			<label class="label">Data de Nascimento: </label> <input type="text" name="dataNascimento"
				placeholder="08/02/1999" class="input is-half">
		</div>
		

		<div>
			<button type="submit" class="button is-primary"> <i class="fas fa-plus" style= "padding-right: 0.2em;"></i>Adicionar</button>
		</div>
	</form>
</body>
</html>
