package br.com.canella.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.canella.entity.dto.AlunoDto;
import br.com.canella.model.Aluno;
import br.com.canella.persistence.AlunoDao;

@WebServlet("/IndexController")
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public IndexController() {

	}
	
	
	
	
	public void init() {
		    
	}
	
	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
	 

	  
	}
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		
		
		try {
			
	
				HttpSession session = request.getSession(true);
				System.out.println("Inicionou Check de LogIn");
				AlunoDto aluno = new AlunoDto();
				aluno.setNomeAluno(request.getParameter("nome"));
				AlunoDao aDao = new AlunoDao();
				Aluno a = new Aluno(null, aluno.getNomeAluno(), null, null, null, null,null);
				aluno = aDao.lerAlunoPorNome(a);

				if(aluno.getIdAluno() != null && aluno.getIdAluno() != 0)
				{
					System.out.println("Aluno Existe");

					if(aluno.getIdProva() != null && aluno.getIdProva() !=0) {
						
						System.out.println(" E tem prova");
						
						
						session.setAttribute("provaAtual",aluno.getIdProva());
						session.setAttribute("alunoAtual",aluno);
						
						if(aluno.getTerminouAprova() == null) {
							request.getRequestDispatcher("prova.jsp").forward(request, response);
						}
						else {
							request.getRequestDispatcher("resultado.jsp").forward(request, response);
						}
						
					}
					else {
						System.out.println(" E não tem prova");
						
						request.setAttribute("alunoParaCadastrar",aluno);
						}


				}else {
					System.out.println("Aluno não existe");
					session.setAttribute("alunoParaCadastrar",aluno);
					response.sendRedirect("cadastro.jsp");
				}
			
				
		}
		catch(Exception e) {
			
			e.printStackTrace();
			System.out.println("Problema no método");
		}
	}
	
	
	
	public void destroy() {
	
	}

}
