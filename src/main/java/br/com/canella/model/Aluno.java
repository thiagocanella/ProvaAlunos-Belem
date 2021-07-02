package br.com.canella.model;

import java.sql.Date;

public class Aluno {
	
	
	private Integer idAluno;
	private String nomeAluno;
	private Date  comecouAprova;
	private Date terminouAprova;
	private Double nota;
	private Integer idProva;
	private Prova prova;
	
	public Aluno() {
	}



	public Aluno(Integer idAluno, String nomeAluno, Date comecouAprova, Date terminouAprova, Double nota,
			Integer idProva, Prova prova) {
		super();
		this.idAluno = idAluno;
		this.nomeAluno = nomeAluno;
		this.comecouAprova = comecouAprova;
		this.terminouAprova = terminouAprova;
		this.nota = nota;
		this.idProva = idProva;
		this.prova = prova;
	}

	


	@Override
	public String toString() {
		return "Aluno [idAluno=" + idAluno + ", nomeAluno=" + nomeAluno + ", comecouAprova=" + comecouAprova
				+ ", terminouAprova=" + terminouAprova + ", nota=" + nota + ", idProva=" + idProva + "]";
	}



	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public Date getComecouAprova() {
		return comecouAprova;
	}

	public void setComecouAprova(Date comecouAprova) {
		this.comecouAprova = comecouAprova;
	}

	public Date getTerminouAprova() {
		return terminouAprova;
	}

	public void setTerminouAprova(Date terminouAprova) {
		this.terminouAprova = terminouAprova;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Integer getIdProva() {
		return idProva;
	}

	public void setIdProva(Integer idProva) {
		this.idProva = idProva;
	}



	public Prova getProva() {
		return prova;
	}



	public void setProva(Prova prova) {
		this.prova = prova;
	}
	
	

}
