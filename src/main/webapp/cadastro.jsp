<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"  session="true"%>

<!DOCTYPE html>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html ;charset=UTF-8">
<title>Cadastro para prova</title>
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
					<h3 style="color:black">Inscreva-se para a prova</h3>
				</div>

				<div class="card-body">

					<form method="post" action="CadastroController" class="form">
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							
							<input type="text" name="nome" placeholder="Digite seu nome" class="form-control">
		
						</div>
						<div>
						<select name="select">
					  <%  java.util.List<String> provas = new java.util.ArrayList<String>();
						provas = br.com.canella.controller.CadastroController.nomeDasProvas();
      					for (String prova : provas) {
      								
      						 out.println("<option>" + prova.toString() + "</option>");	  
      							    
     						 }
						    %>
      					</select>
      							



						</div>
						<div class="form-group">
							<input type="submit" value="Cadastrar"
								class="btn float-right login_btn">
						</div>

					</form>


				</div>


				<div class="card-footer">
					<div class="d-flex justify-content-center links">
						<font style="color:black">Tenha uma boa prova.</font>
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