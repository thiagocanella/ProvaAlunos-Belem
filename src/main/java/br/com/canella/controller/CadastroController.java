package br.com.canella.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.canella.model.Aluno;
import br.com.canella.model.Prova;
import br.com.canella.persistence.AlunoDao;
import br.com.canella.persistence.ProvaDao;

@WebServlet("/CadastroController")
public class CadastroController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CadastroController() {
	}
	
	

	public void init() {
		    
	}
	
	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
	}
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String prova = request.getParameter("select");
		ProvaDao pDao = new ProvaDao();
		Prova result = new Prova();
		result.setNomeProva(prova);

		try {
			result = pDao.lerProvaPorNome(result);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
			
			if(!nome.isBlank() && !nome.isEmpty() && nome != null) {
				AlunoDao aDao = new AlunoDao();
				Aluno a = new Aluno();
				a.setNomeAluno(nome);
				a.setIdProva(result.getIdProva());
				try {
					aDao.criarAluno(a);
				} catch (Exception e) {
					e.printStackTrace();
				}
				request.getRequestDispatcher("index.jsp").forward(request, response);

			}



	}





	public static List<String> nomeDasProvas(){
		ProvaDao pDao = new ProvaDao();
		List<String> saida = new ArrayList<String>();
		List<Prova> result = new ArrayList<Prova>();
		try {
			 result = pDao.lerTodasProvas();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		for (Prova r : result) 
		{ 
			saida.add(r.getNomeProva());
		}
			
		return saida;
	}
	

}
