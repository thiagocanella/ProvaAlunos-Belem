package br.com.canella.test;

import br.com.canella.model.Questao;
import br.com.canella.persistence.QuestaoDao;

public class QuestaoTest {

	
	
	public static void criarQuestaoTest() {
		QuestaoDao qDao = new QuestaoDao();
		Questao quest = new Questao();
		quest.setPergunta("Quato é 4^3?");
		quest.setOpcao1("98");
		quest.setOpcao2("24");
		quest.setOpcao3("64");
		quest.setOpcao4("72");
		quest.setOpcaocorreta(3);
		
		
		try {
		qDao.criarQuestao(quest);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}


public static void lerQuestTest() {
	QuestaoDao qDao = new QuestaoDao();

	Questao quest = new Questao();
	quest.setIdQuestao(2);
	
	Questao result = new Questao();
	
	try {
	result = qDao.lerQuestaoPorId(quest);
	}
	catch(Exception ex) {
		ex.printStackTrace();
	}
	
	System.out.println(result);
}


public static void atualizarQUestaoTest() {
	QuestaoDao qDao = new QuestaoDao();

	Questao quest = new Questao();
	quest.setIdQuestao(2);
	quest.setPergunta("Quato é 2^3?");
	quest.setOpcao1("8");
	quest.setOpcao2("12");
	quest.setOpcao3("16");
	quest.setOpcao4("4");
	quest.setOpcaocorreta(1);
	
	try {
		qDao.atualizarQuestao(quest);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
}

public static void deletarQuestaoTest() {
	QuestaoDao qDao = new QuestaoDao();

	Questao quest = new Questao();
	quest.setIdQuestao(3);
	
	try {
		qDao.deletarQuestao(quest);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
}

	public static void main(String[] args) {
		
		criarQuestaoTest();

	}

}
