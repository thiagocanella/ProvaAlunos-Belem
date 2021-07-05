<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.Date"%>

<%@page import="br.com.canella.model.Questao"%>
<%@page import="java.util.List"%>
<%@page import="br.com.canella.controller.ProvaController"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.canella.model.Prova"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html ;charset=UTF-8">
<title>Prova</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link rel="stylesheet" href="styleProva.css">
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-center">
			<div class="card">


				<div class="card-header">
					<h3 style="color: black">Boa prova</h3>
					<h6 style="color: black">Prova iniciada : <% out.println(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime())); %></h6>
				</div>

				<div class="card-body">

					<form method="post" action="ProvaController" class="form">

						<div>

							<%  
					  			Prova prova = new Prova();
					  			int id = Integer.parseInt(session.getAttribute("provaAtual").toString());
								prova = ProvaController.listarProva(id);
								List<Questao> questoes = prova.getQuestoes();
      							
								for (Questao questao : questoes) {
      								int i = 1;
      						 		out.println("<h4>" + questao.getPergunta().toString() + " </h4><br> " +
      											 "<ol> <li> " + questao.getOpcao1().toString() + " </li> <br>" +
      											" <li> " + questao.getOpcao2().toString() + " </li> <br> " +
      											" <li> " + questao.getOpcao3().toString() + " </li> <br> " +
      											" <li> " + questao.getOpcao4().toString() + " </li> </ol> <br> " +
      											"Selecione uma opção"  +
      											" <select  name=\"pergunta" + i + "\"> " + 
      											"<option> 1 </option> <option> 2 </option> <option> 3 </option> <option> 4 </option> </select>"+
      											" <br> <hr><br> <br>"
      								 );	  
      						 		 i++;
     						 
      								
   								}
      					
						    %>

						<% %>



						</div>
						<div class="form-group">
							<input type="submit" value="Finalizar"
								class="btn float-right login_btn">
						</div>

					</form>

				</div>


				<div class="card-footer">
					<div class="d-flex justify-content-center links">
						<font style="color: black">Verifique as questões antes de terminar.</font>
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