package br.com.canella.model;

import java.sql.Date;
import java.util.List;
import java.util.UUID;


public class Prova {
	private Integer idProva;
	private String nomeProva;
	private Date criado;
	private String uuid;
	private List<Questao> questoes;

	public Prova() {
	}



	public Prova(Integer idProva, String nomeProva, Date criado, String uuid, List<Questao> questoes) {
		super();
		this.idProva = idProva;
		this.nomeProva = nomeProva;
		this.criado = criado;
		if(uuid != null) {
		this.uuid = uuid;
		}
		else 
		{
			UUID uuidstr = UUID.randomUUID();
			this.uuid = uuidstr.toString();
		}
		this.questoes = questoes;
	}



	@Override
	public String toString() {
		return "Prova [idProva=" + idProva + ", nomeProva=" + nomeProva + ", criado=" + criado + ", uuid=" + uuid + "]";
	}

	public Integer getIdProva() {
		return idProva;
	}

	public void setIdProva(Integer idProva) {
		this.idProva = idProva;
	}

	public String getNomeProva() {
		return nomeProva;
	}

	public void setNomeProva(String nomeProva) {
		this.nomeProva = nomeProva;
	}

	public Date getCriado() {
		return criado;
	}

	public void setCriado(Date criado) {
		this.criado = criado;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}



	public List<Questao> getQuestoes() {
		return questoes;
	}



	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	

}
