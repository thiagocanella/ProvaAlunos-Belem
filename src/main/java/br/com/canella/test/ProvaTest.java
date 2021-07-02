package br.com.canella.test;

import java.util.ArrayList;
import java.util.List;

import br.com.canella.model.Prova;
import br.com.canella.model.Questao;
import br.com.canella.persistence.ProvaDao;

public class ProvaTest {


	public static void criarProvaTest() {
		
		ProvaDao pDao = new ProvaDao();
		
		Prova p = new Prova();
		p.setNomeProva("Teste de Math");
		
		List<Questao> questoes = new ArrayList<Questao>();
		questoes.add(new Questao(1,null,null,null,null,null,null));
		questoes.add(new Questao(4,null,null,null,null,null,null));
		
		try {
			pDao.createProva(p, questoes);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void lerProvaTest() {
		ProvaDao pDao = new ProvaDao();
		
		Prova p = new Prova();
		p.setIdProva(2);
		
		Prova result = new Prova();
		
		try {
			result = pDao.lerProva(p);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		
	}
	
	public static void atualizarProvaTest() {
		
	}
	
	public static void deletarProvaTest() {
		
	}

	public static void main(String[] args) {
		lerProvaTest();
	}

}
