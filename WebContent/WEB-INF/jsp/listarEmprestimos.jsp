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

		<h1 class="title is-3">Emprestimos Realizados:</h1>

		<table class="table is-bordered is-striped is-narrow is-hoverable">
		
		<h2 class="is-5 is-success">${mensagem}</h2>

			<tr>

				<th>Matricula do Aluno</th>
				<th>Titulo do Livro</th>
				<th>Data do Emprestimo</th>
				<th>Devolucao</th>

			</tr>

			<c:forEach var="e" items="${emprestimos}">

				<tr>

					<td>${e.aluno.matricula}</td>
					<td>${e.livro.nome}</td>
					<td>${e.dataEmprestimo.time}</td>
					<c:if test="${not empty e.dataDevolucao}">
					<td>${e.dataDevolucao.time}</td>
					</c:if>
					<c:if test="${empty e.dataDevolucao}">
					<td>
					
<!-- 					Isso aqui é como se e automaticamente digitasse na barra de navegação: -->
<!-- 					"mvc?logica=DevolverLivroLogic&idLivro=id do livro&idAluno=id do aluno" -->
						<form class="emprestimo" action="mvc?">
							<input type="hidden" name="logica" value="DevolverLivroLogic">
							<input type="hidden" name="idLivro" value="${e.livro.id}">
							<input type="hidden" name="idAluno" value="${e.aluno.id}">	
							<button class="button is-info button-emprestimo" type="submit">Devolver Livro</button>

						</form>
					</td>
					</c:if>

					
				</tr>

			</c:forEach>

		</table>
	</div>

</body>
</html>