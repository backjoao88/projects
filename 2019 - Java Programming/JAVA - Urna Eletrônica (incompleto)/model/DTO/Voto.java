package DTO;

import java.util.Date;

public class Voto {
	
	private Integer codigo = 0;
	private Date data = null;
	private Integer candidato_codigo = 0;
	private Integer eleicao_codigo = 0;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Integer getCandidato_codigo() {
		return candidato_codigo;
	}
	public void setCandidato_codigo(Integer candidato_codigo) {
		this.candidato_codigo = candidato_codigo;
	}
	public Integer getEleicao_codigo() {
		return eleicao_codigo;
	}
	public void setEleicao_codigo(Integer eleicao_codigo) {
		this.eleicao_codigo = eleicao_codigo;
	}
	
}
