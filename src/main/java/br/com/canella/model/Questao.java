package br.com.canella.model;

public class Questao {

	private Integer  idQuestao;
	private String pergunta;
	private String opcao1;
	private String opcao2;
	private String opcao3;
	private String opcao4;
	private Integer opcaocorreta;

	public Questao() {
	}

	public Questao(Integer idQuestao, String pergunta, String opcao1, String opcao2, String opcao3, String opcao4,
			Integer opcaocorreta) {
		super();
		this.idQuestao = idQuestao;
		this.pergunta = pergunta;
		this.opcao1 = opcao1;
		this.opcao2 = opcao2;
		this.opcao3 = opcao3;
		this.opcao4 = opcao4;
		this.opcaocorreta = opcaocorreta;
	}

	@Override
	public String toString() {
		return "Questao [idQuestao=" + idQuestao + ", pergunta=" + pergunta + ", opcao1=" + opcao1 + ", opcao2="
				+ opcao2 + ", opcao3=" + opcao3 + ", opcao4=" + opcao4 + ", opcaocorreta=" + opcaocorreta + "]";
	}

	public Integer getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(Integer idQuestao) {
		this.idQuestao = idQuestao;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getOpcao1() {
		return opcao1;
	}

	public void setOpcao1(String opcao1) {
		this.opcao1 = opcao1;
	}

	public String getOpcao2() {
		return opcao2;
	}

	public void setOpcao2(String opcao2) {
		this.opcao2 = opcao2;
	}

	public String getOpcao3() {
		return opcao3;
	}

	public void setOpcao3(String opcao3) {
		this.opcao3 = opcao3;
	}

	public String getOpcao4() {
		return opcao4;
	}

	public void setOpcao4(String opcao4) {
		this.opcao4 = opcao4;
	}

	public Integer getOpcaocorreta() {
		return opcaocorreta;
	}

	public void setOpcaocorreta(Integer opcaocorreta) {
		this.opcaocorreta = opcaocorreta;
	}










}
