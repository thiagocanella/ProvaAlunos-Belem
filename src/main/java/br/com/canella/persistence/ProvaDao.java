package br.com.canella.persistence;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.canella.interfaces.IDao;
import br.com.canella.model.Prova;
import br.com.canella.model.Questao;

public class ProvaDao extends Dao implements IDao{

	public void createProva(Prova prova, List<Questao> questoes) throws Exception {	
		open();
		con.setAutoCommit(false);
		stmt = con.prepareStatement("insert into prova values(null, ?, NOW(), ?)" , Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, prova.getNomeProva());
		stmt.setString(2, prova.getUuid());
		stmt.execute();


		ResultSet generatedRturn = stmt.getGeneratedKeys();
		generatedRturn.next();
		int idProva = generatedRturn.getInt(1);

		for(Questao questao : questoes) {
			stmt = con.prepareStatement("insert into questaoprova values (?,?)");
			stmt.setInt(1,idProva);
			stmt.setInt(2, questao.getIdQuestao());
			stmt.execute();
		}


	
		con.commit();
		con.setAutoCommit(true);

		close();
	}

	public Prova lerProva(Prova prova) throws Exception {

		open();
		Prova resultado = new Prova();
		
		String query = "select * from prova where idProva = "+ prova.getIdProva().toString();
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		while(rs.next()) {
			resultado.setIdProva(rs.getInt("idProva"));
			resultado.setCriado(rs.getDate("criado"));
			resultado.setNomeProva(rs.getString("nomeProva"));
			resultado.setUuid(rs.getString("uuid"));
		}
		close();
		
		if(resultado != null  && resultado.getIdProva() != 0) {
		resultado.setQuestoes(lerTodasQuestoesDaProvaPorId(resultado));
		}

		return resultado;

	}

	public List<Questao> lerTodasQuestoesDaProvaPorId(Prova prova) throws Exception {

		List<Questao> listaResultado = new ArrayList<Questao>();
		open();
		
		String query = "SELECT a.* FROM questao as A INNER JOIN questaoprova as B  on a.idQuestao = b.idQuestao where b.idProva ="	+ prova.getIdProva().toString();
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		
		
		while(rs.next()) {
			listaResultado.add(new Questao(
					rs.getInt("idQuestao"),
					rs.getString("pergunta"),
					rs.getString("opcao1"),
					rs.getString("opcao2"),
					rs.getString("opcao3"),	
					rs.getString("opcao4"),
					rs.getInt("opcaocorreta")					
					));
		}
		close();
		return listaResultado;

	}

	public void deletarProva(Prova prova) throws Exception{
		open();
		stmt.executeUpdate("delete from prova where idProva = " + prova.getIdProva().toString());
		stmt.executeUpdate("delete from questaoprova where idProva = "+ prova.getIdProva().toString());
		close();
	}
	
	
	public void atualizarProva(Prova prova) throws Exception{
		open();
		stmt = con.prepareStatement(" update prova set nomeProva = ? , criado = ? where idProva = ?" );
		stmt.setString(1, prova.getNomeProva());
		stmt.setDate(2, prova.getCriado());
		stmt.setInt(3, prova.getIdProva());
		stmt.execute();		
		close();
	}

	
	public List<Prova> lerTodasProvas() throws Exception {

		open();
		List<Prova> resultado = new ArrayList<Prova>();
		
		String query = "select * from prova";
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		while(rs.next()) {
			Prova result = new Prova();
			result.setIdProva(rs.getInt("idProva"));
			result.setCriado(rs.getDate("criado"));
			result.setNomeProva(rs.getString("nomeProva"));
			result.setUuid(rs.getString("uuid"));
			resultado.add(result);
		}
		close();
		return resultado;

	}
	
	
	public Prova lerProvaPorNome(Prova prova) throws Exception {

		open();
		Prova resultado = new Prova();
		
		String query = "select * from prova where nomeProva = '"+ prova.getNomeProva().toString() + "'";
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		while(rs.next()) {
			resultado.setIdProva(rs.getInt("idProva"));
			resultado.setCriado(rs.getDate("criado"));
			resultado.setNomeProva(rs.getString("nomeProva"));
			resultado.setUuid(rs.getString("uuid"));
		}
		close();
	return resultado;

	}


}
