<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/styles.css">
<title>Professor</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp"></jsp:include>
	</div>
	<br>
	<div align="center" class="container">
		<form action="professor" method="post">
		<p class="title">
			<b>Professor</b>
		</p>
		<table>
			<tr>
				<td colspan="3">
					<input class="id_input_data" type="number" min="0" step="1" id="codigo" 
					name="codigo" placeholder="Codigo" value='<c:out value="${professor.codigo }"></c:out>'>
				</td>
				<td>
					<input type="submit" id="botao" name="botao" value="Buscar">
				</td>
			</tr>
			<tr>
				<td colspan="4">
					 <input class="input_data" type="text" id="nome" name="nome" placeholder="Nome" 
					 value='<c:out value="${professor.nome }"></c:out>'>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					 <input class="input_data" type="text" id="titulacao" name="titulacao"
					 placeholder="Titulacao" value='<c:out value="${professor.titulacao }"></c:out>'>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" id="botao" name="botao" value="Cadastrar">
				</td>
				<td>
					<input type="submit" id="botao" name="botao" value="Alterar">
				</td>
				<td>
					<input type="submit" id="botao" name="botao" value="Excluir">
				</td>
				<td>
					<input type="submit" id="botao" name="botao" value="Listar">
				</td>
			</tr>
		</table>
		</form> 
	</div>
	<div align="center">
		<c:if test="${not empty erro }">
			<h2> <b> <c:out value="${erro }"/></b></h2>
		</c:if>
	</div>
	<div align="center">
		<c:if test="${not empty saida }">
			<h3> <b> <c:out value="${saida }"/></b></h3>
		</c:if>
	</div>
	<br />
	<div align="center">
		<c:if test="${not empty professores }">
			<table class="table_round">
				<thead>
					<tr>
						<th>Codigo</th>
						<th>Nome</th>
						<th>Titulacao</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${professores }">
						<tr>
							<td><c:out value="${p.codigo }" /></td>
							<td><c:out value="${p.nome }" /></td>
							<td><c:out value="${p.titulacao }" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>