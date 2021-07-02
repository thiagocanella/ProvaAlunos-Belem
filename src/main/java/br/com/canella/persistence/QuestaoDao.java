package br.com.canella.persistence;

import br.com.canella.interfaces.IDao;
import br.com.canella.model.Questao;

public class QuestaoDao extends Dao implements IDao {



	public void criarQuestao(Questao questao) throws Exception {	
		open();
		stmt = con.prepareStatement("  insert into questao values (null, ?, ? , ? , ? , ? ,? )");
		stmt.setString(1, questao.getOpcao1());
		stmt.setString(2, questao.getOpcao2());
		stmt.setString(3, questao.getOpcao3());
		stmt.setString(4, questao.getOpcao4());
		stmt.setInt(5, questao.getOpcaocorreta());
		stmt.setString(6, questao.getPergunta());
		stmt.execute();
		close();		
	}

	public Questao lerQuestaoPorId(Questao questao) throws Exception {

		open();
		Questao resultado = new Questao();

		String query = "select * from questao where idQuestao = "+ questao.getIdQuestao().toString();
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		while(rs.next()) {
			resultado.setIdQuestao(rs.getInt("idQuestao"));
			resultado.setPergunta(rs.getString("pergunta"));
			resultado.setOpcao1(rs.getString("opcao1"));
			resultado.setOpcao2(rs.getString("opcao2"));
			resultado.setOpcao3(rs.getString("opcao3"));;
			resultado.setOpcao4(rs.getString("opcao4"));
			resultado.setOpcaocorreta(rs.getInt("opcaocorreta"));
		}
		close();
		return  resultado;
	}

	public void deletarQuestao(Questao questao) throws Exception{
		open();
		stmt = con.prepareStatement("delete from questao where idQuestao = ?");
		stmt.setInt(1, questao.getIdQuestao());
		stmt.execute();		
		close();
	}

	public void atualizarQuestao(Questao questao) throws Exception{
		open();
		stmt = con.prepareStatement("update questao set pergunta = ? , opcao1 = ?, opcao2 = ?, opcao3 = ? , opcao4 = ?, opcaocorreta = ? where idQuestao = ?" );
		stmt.setString(1, questao.getPergunta());
		stmt.setString(2, questao.getOpcao1());
		stmt.setString(3, questao.getOpcao2());
		stmt.setString(4, questao.getOpcao3());
		stmt.setString(5, questao.getOpcao4());
		stmt.setInt(6, questao.getOpcaocorreta());
		stmt.setInt(7, questao.getIdQuestao());
		stmt.execute();		
		close();


	}


}
