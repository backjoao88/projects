package interfaces;

import DTO.Eleicao;

public interface lPersistenciaEleicao {
	
	public void inserir(Eleicao eleicao);
	public void atualizar(Eleicao eleicao);
	public void deletar(Eleicao eleicao);
	public void procurar(Eleicao eleicao);

}
