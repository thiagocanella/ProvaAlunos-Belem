package br.com.canella.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import br.com.canella.entity.dto.AlunoDto;
import br.com.canella.model.Aluno;
import br.com.canella.persistence.AlunoDao;

public class AlunoTest {


	public static void criarAlunoTest() {
		AlunoDao aDao = new AlunoDao();
		Aluno a = new Aluno();
		a.setNomeAluno("Ayrton Senna");
		try {
			aDao.criarAluno(a);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void lerAlunoTestPorId() {
		AlunoDao aDao = new AlunoDao();
		Aluno a = new Aluno();
		a.setIdAluno(2);
		AlunoDto res = new AlunoDto();
		try {
			res = aDao.lerAlunoPorId(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Aluno result = new Aluno(
				res.getIdAluno(),
				res.getNomeAluno(),
				res.getComecouAprova(),
				res.getTerminouAprova(),
				res.getNota(),
				res.getIdProva(),
				null				
				);

		System.out.println(result);
	}


	public static void lerAlunoTestPorNome() {
		AlunoDao aDao = new AlunoDao();
		Aluno a = new Aluno();
		a.setNomeAluno("Adriana Bordignon");
		AlunoDto res = new AlunoDto();
		try {
			res = aDao.lerAlunoPorNome(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Aluno result = new Aluno(
				res.getIdAluno(),
				res.getNomeAluno(),
				res.getComecouAprova(),
				res.getTerminouAprova(),
				res.getNota(),
				res.getIdProva(),
				null				
				);

		System.out.println(result);
	}

	public static void lerTodosAlunosTest() {
		AlunoDao aDao = new AlunoDao();
		
		List<Aluno> todos = new ArrayList<Aluno>();
		
		try {
			todos = aDao.lerTodosAlunos();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(todos);
	}

	@SuppressWarnings("deprecation")
	public static void atualizarAlunoTest() {
		AlunoDao aDao = new AlunoDao();
		Aluno a = new Aluno();
		a.setIdAluno(2);
		a.setNomeAluno("Adriana Bordignon Canella");
		a.setTerminouAprova(new Date(2021, 07, 02));
		a.setComecouAprova(new Date(2021,07,01));
		a.setNota(7.8);
		a.setIdProva(1);
		try {
		aDao.atualizarAluno(a);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public static void apagarAlunoTest() {
		AlunoDao aDao = new AlunoDao();
		Aluno a = new Aluno();
		a.setIdAluno(2);
		try {
			aDao.deletarAluno(a);
		}catch (Exception e) {
			
		}
	}


	public static void main(String[] args) {
		criarAlunoTest();
	}

}
