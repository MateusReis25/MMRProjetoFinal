<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<link href="usuario.css" rel="stylesheet">
<title>Usuário</title>
</head>
<body>
	 <div class="menu">
        <div class="col-2">
            <h3>Raia Drogasil</h3>
        </div>
       <h6>Usuário</h6> 
    </div>
    
    <div class="lista">
        <strong>Lista de Usuários</strong>
    </div><hr>
    <div class="btnUsuario">
        <a href="formulario.jsp"><button type="button" class="btn btn-primary">Adicionar Usuário</button></a>
    </div>
    
    <div class="tabela">
        <table class=" table table table-bordered">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Email</th>
					<th>País</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${listUser}">
					<tr>
						<form action="MMRProjetoFinal" method="post"> 
							<td>
								<c:out value="${usuario.id}"/>
								<input type="hidden" name="id" value="${usuario.id}"/>
							</td>
							<td><c:out value="${usuario.name}"/></td>
							<td><c:out value="${usuario.email}"/></td>
							<td><c:out value="${usuario.pais}"/></td>
							<td class="btnAcoes">
								<button type="submit" name="option" value="delete">Deletar</button>
								<button type="submit" name="option" value="updateForm">Atualizar</button>
							</td>
						</form>	

					</tr>
				</c:forEach>
			</tbody>
		</table>
    </div>
</body>
</html>