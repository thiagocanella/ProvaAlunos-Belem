package br.com.canella.entity.dto;

public class QuestaoprovaDto {


		private Integer idProva;
		private Integer idQuestao;
		   
		
		public QuestaoprovaDto() {
		}


		public QuestaoprovaDto(Integer idProva, Integer idQuestao) {
			super();
			this.idProva = idProva;
			this.idQuestao = idQuestao;
		}


		@Override
		public String toString() {
			return "QuestaoprovaDto [idProva=" + idProva + ", idQuestao=" + idQuestao + "]";
		}


		public Integer getIdProva() {
			return idProva;
		}


		public void setIdProva(Integer idProva) {
			this.idProva = idProva;
		}


		public Integer getIdQuestao() {
			return idQuestao;
		}


		public void setIdQuestao(Integer idQuestao) {
			this.idQuestao = idQuestao;
		}


}
