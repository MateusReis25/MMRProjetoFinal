<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<link href="formulario.css" rel="stylesheet">
<title>Formulário</title>
</head>
<body>
	<div class="menu">
        <div class="col-2">
            <h3>Raia Drogasil</h3>
        </div>
       <h6>Formulário</h6> 
    </div>
    <div class="formLogin">
        <h3>Adicionar Usuário</h3>
        <form action="MMRProjetoFinal" method="post">
			<c:choose>
				<c:when test="${ user == null}">
					<div class="inputs">
						<label>Nome:</label><br>
						<input type="text" name="name" required/> <br>
						<label>Email:</label><br>
						<input type="text" name="email"/><br>
						<label>País:</label><br>
						<input type="text" name="pais"/><br><br>
									
						<button type="submit" name="option" value="insert"><strong>Salvar</strong></button>
					</div>	
				</c:when>
				<c:otherwise>
					<div class="inputs">
						<input type="hidden" name="id" value="${user.id}"/>
						<label>Nome:</label><input type="text" name="name" value="${user.name}" required/>
						<label>Email:</label><input type="text" name="email" value="${user.email}"/>
						<label>País:</label><input type="text" name="pais" value="${user.pais}"/>
					
						<button type="submit" name="option" value="update">Atualizar</button>
					</div>
				</c:otherwise>
			</c:choose>
		</form>
    </div>
</body>
</html>