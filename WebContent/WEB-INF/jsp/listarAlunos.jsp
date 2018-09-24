<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="node_modules/bulma/css/bulma.css">
<link rel="stylesheet" type="text/css" href="css/estilo.css">
<link rel="stylesheet" type="text/css"
	href="node_modules/fontawesome-free/css/all.css">
<meta charset="UTF-8">
<title>Lista de Alunos</title>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>

	<div class="box table-box">

		<h1 class="title is-3">Alunos Cadastrados:</h1>
		

		<table class="table is-bordered is-striped is-narrow is-hoverable">

			<tr>

				<th>Id</th>
				<th>Nome</th>
				<th>Matricula</th>
				<th>Endereço</th>
				<th>Data de Nascimento</th>
				<th>Situação no Sistema</th>

			</tr>

			<c:forEach var="a" items="${alunos}">

				<tr>

					<td>${a.id}</td>
					<td>${a.nome}</td>
					<td>${a.matricula}</td>
					<td>${a.endereco}</td>
					<td>${a.dataNascimento.time}</td>
					<td>Possui ${a.livrosAtrasados.size()} Livro(s) atrasado(s).</td>
				</tr>

			</c:forEach>

		</table>
	</div>

</body>
</html>