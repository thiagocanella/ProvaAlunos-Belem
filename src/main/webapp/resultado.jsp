<%@page import="br.com.canella.entity.dto.AlunoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html ;charset=UTF-8">
<title>Resultado</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link rel="stylesheet" href="style.css">
</head>
<body>

	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<div class="card">


				<div class="card-header">
					<h3 style="color:black">Sua nota:</h3>
				</div>

				<div class="card-body">

					<%
					AlunoDto a = (AlunoDto)session.getAttribute("alunoAtual");
					if(a !=null){
						out.println(" <h2> " + a.getNota().toString() + " </h2> ");
						if(a.getNota() < 6){
							request.setAttribute("Mensagem" , "Você precisa estudar mais");
						}
						else
						{
							request.setAttribute("Mensagem" , "Parabéns, você ficou acima da média");

						}
					}
					%>						
					

				</div>


				<div class="card-footer">
					<div class="d-flex justify-content-center links">
						<font style="color:black">${Mensagem} </font>
					</div>
				</div>

			</div>
		</div>

	</div>


</body>

<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</html>