package br.com.canella.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.canella.entity.dto.AlunoDto;
import br.com.canella.interfaces.IDao;
import br.com.canella.model.Aluno;

public class AlunoDao extends Dao implements IDao{



	public void createUsuario(Aluno aluno) throws Exception {	
		open();
		stmt = con.prepareStatement("  insert into aluno values (null, ?, null,null,null,null )");
		stmt.setString(1, aluno.getNomeAluno());
		stmt.execute();
		close();
	}

	public AlunoDto lerUsuarioPorId(Aluno aluno) throws Exception {

		open();
		AlunoDto resultado = new AlunoDto();

		String query = "select * from aluno where idusuario = "+ aluno.getIdAluno().toString();
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		while(rs.next()) {
			resultado.setIdAluno(rs.getInt("idUsuario"));
			resultado.setNomeAluno(rs.getString("nomeAluno"));
			resultado.setComecouAprova(rs.getDate("comecouAprova"));
			resultado.setTerminouAprova(rs.getDate("terminouAprova"));
			resultado.setNota(rs.getDouble("nota"));
			resultado.setIdProva(rs.getInt("idProva"));
		}
		close();
		return  resultado;
		/*new Aluno(
				resultado.getIdAluno(),
				resultado.getNomeAluno(),
				resultado.getComecouAprova(),
				resultado.getTerminouAprova(),
				resultado.getNota(),
				resultado.getIdProva(),
				null				
				);*/

	}

	public List<AlunoDto> lerTodosAlunos() throws Exception {

		open();
		List<AlunoDto> resultado = new ArrayList<AlunoDto>();
		stmt = con.prepareStatement("select * from aluno");
		rs = stmt.executeQuery();
		while(rs.next()) {
			resultado.add(new AlunoDto(	
					rs.getInt("idUsuario"),
					rs.getString("nomeAluno"),
					rs.getDate("comecouAprova"),
					rs.getDate("terminouAprova"),
					rs.getDouble("nota"),
					rs.getInt("idProva")
					));

		}
		close();
		return resultado;

	}


	public void deletarAluno(Aluno aluno) throws Exception{
		open();
		stmt.executeUpdate("delete from cliente where idUsuario = "+ aluno.getIdAluno().toString());
		close();
	}

	public void atualizarAluno(Aluno requisicao) throws Exception{
		open();
		stmt = con.prepareStatement("update aluno set nomeAluno = ? , terminouAprova = ?, nota = ?, idProva = ? , comecouAprova = ? where idAluno = ?" );
		stmt.setString(1, requisicao.getNomeAluno());
		stmt.setDate(2, requisicao.getTerminouAprova());
		stmt.setDouble(3, requisicao.getNota());
		stmt.setInt(4, requisicao.getIdProva());
		stmt.setDate(5, requisicao.getComecouAprova());
		stmt.setInt(6, requisicao.getIdAluno());
		stmt.execute();		
		close();


	}

}
