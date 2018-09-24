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
<title>Lista de Livros</title>
</head>
<body>

	<c:import url="cabecalho.jsp"></c:import>

	<div class="box table-box">

		<h1 class="title is-3">Livros no Acervo:</h1>

		<table class="table is-bordered is-striped is-narrow is-hoverable">

			<tr>

				<th>Id</th>
				<th>Nome</th>
				<th>Autor</th>
				<th>Editora</th>
				<th>Ano</th>
				<th>Edição</th>
				<th>Empréstimo</th>

			</tr>

			<c:forEach var="l" items="${livros}">

				<tr>

					<td>${l.id}</td>
					<td>${l.nome}</td>
					<td>${l.autor}</td>
					<td>${l.editora}</td>
					<td>${l.ano}</td>
					<td>${l.edicao}</td>

					<td>
						<form class="emprestimo" action="mvc?">
							<input type="hidden" name="logica" value="FazerEmprestimoLogic">
							<input type="hidden" name="idLivro" value="${l.id}"> <input
								name="matriculaAluno" placeholder="Matricula do Aluno"
								class="input is-half"></input>

							<button class="button is-info button-emprestimo" type="submit">
								Emprestar livro
							</button>

						</form>
					</td>
				</tr>

			</c:forEach>

		</table>
	</div>

</body>
</html>