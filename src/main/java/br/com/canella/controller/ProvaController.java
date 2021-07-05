package br.com.canella.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.canella.entity.dto.AlunoDto;
import br.com.canella.model.Aluno;
import br.com.canella.model.Prova;
import br.com.canella.model.Questao;
import br.com.canella.persistence.AlunoDao;
import br.com.canella.persistence.ProvaDao;



@WebServlet("/ProvaController")
public class ProvaController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Aluno aluno;
	private Prova prova;
	private Double nota;
	private AlunoDao aDao;
	private ProvaDao pDao;
	private Integer acertos;
	
	public ProvaController() {
		aDao = new  AlunoDao();
		pDao = new ProvaDao();
	}
	
	
	
	@Override
	public String toString() {
		return "ProvaController [aluno=" + aluno + ", prova=" + prova + ", nota=" + nota + ", acertos=" + acertos + "]";
	}


	
	public void init() {
		    
	}
	
	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
	 

	  
	}
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);

		List<Questao> questoes = (List<Questao>)session.getAttribute("questoes");
		
		
		Integer i = 1;
		Integer acertos = 0;
		for(Questao questao : questoes)
		{
			String perg = "pergunta"+i.toString();
			Integer quest = Integer.parseInt( request.getParameter(perg).toString());
			if(questao.getOpcaocorreta() == quest) {
				System.out.println("resposta certa " + perg);
				acertos++;
			}
			i++;
		}
		this.setAcertos(acertos);
		calcularNota(i -1);
		System.out.println("A nota é " + this.getNota().toString());
		setarFimDaProva(request, getNota());
		request.getRequestDispatcher("resultado.jsp").forward(request, response);
		
	
		
		
	}



	

	public Aluno getAluno() {
		return aluno;
	}



	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}



	public Prova getProva() {
		return prova;
	}



	public void setProva(Prova prova) {
		this.prova = prova;
	}



	public Double getNota() {
		return nota;
	}



	public void setNota(Double nota) {
		this.nota = nota;
	}



	public Integer getAcertos() {
		return acertos;
	}



	public void setAcertos(Integer acertos) {
		this.acertos = acertos;
	}


	
	
	

	public void calcularNota(Integer qntPerguntas) {
		
		Double total = 10d;
		this.nota = (double)((total / qntPerguntas) * acertos);
	}
	
	

	
	
	public static Prova listarProva(int id) {
		
		ProvaDao pDao = new ProvaDao();
		Prova p = new Prova();
		p.setIdProva(id);
		
		try {
			p = pDao.lerProva(p);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return p;
	}
	
	public static void setarDataInicioDaProva(HttpServletRequest request)
	{
		HttpSession session = request.getSession(true);
		AlunoDto a = (AlunoDto)session.getAttribute("alunoAtual");

		AlunoDao aDao = new AlunoDao();
		try {
			aDao.atualizarInicioProvaAluno(a);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setarFimDaProva(HttpServletRequest request , Double nota)
	{
		HttpSession session = request.getSession(true);
		AlunoDto a = (AlunoDto)session.getAttribute("alunoAtual");
		a.setNota(nota);
		AlunoDao aDao = new AlunoDao();
		try {
			aDao.atualizarFimProvaAlunoComNota(a);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
