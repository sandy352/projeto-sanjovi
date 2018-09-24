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
<link rel="stylesheet" type="text/css"
	href="node_modules/fontawesome-free/css/all.css">

</head>
<body>

<c:import url="/WEB-INF/jsp/cabecalho.jsp"></c:import>

	<form action="mvc?" class="box is-info">
		<h1 class="title is-3">Adicionar Livro</h1>
		<input type="hidden" name="logica" value="AdicionaLivroLogic">
		<div>
			<label class="label">Nome: </label> <input type="text"
				placeholder="Eu, Robô" name="nome" class="input is-half">
		</div>
		<div>
			<label class="label">Autor: </label> <input type="text" name="autor"
				placeholder="Isaac Asimov" class="input is-half">
		</div>
		<div>
			<label class="label">Editora: </label> <input type="text"
				name="editora" placeholder="Abril" class="input is-half">
		</div>
		<div>
			<label class="label">Ano: </label> <input type="text" name="ano"
				placeholder="1950" class="input is-half">
		</div>
		<div>
			<label class="label">Edição: </label> <input type="text"
				name="edicao" placeholder="Segunda ou 2º" class="input is-half">
		</div>


		<div>
			<button type="submit" class="button is-primary">
				<i class="fas fa-plus" style="padding-right: 0.2em;"></i>Adicionar
			</button>
		</div>
	</form>
</body>
</html>
