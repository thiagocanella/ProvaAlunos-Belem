package br.com.canella.controller;

import java.util.ArrayList;
import java.util.List;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import br.com.canella.model.Aluno;
import br.com.canella.model.Prova;
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
	private List<Boolean> acertos = new ArrayList<Boolean>();
	
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
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
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



	public List<Boolean> getAcertos() {
		return acertos;
	}



	public void setAcertos(List<Boolean> acertos) {
		this.acertos = acertos;
	}


	
	
	

	public void calcularNota() {
		Integer numeroAcertos = 0;
		for(int x =0; x < acertos.size(); x++) {
			if(acertos.get(x) == true) {
				numeroAcertos =+ 1;
			}
			else {
				numeroAcertos =+ 0;	
			}
					
		}
		
		this.nota = (double) (numeroAcertos / acertos.size());
	}
	
	
	public void computarAcerto() {
		acertos.add(true);
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
	

}
