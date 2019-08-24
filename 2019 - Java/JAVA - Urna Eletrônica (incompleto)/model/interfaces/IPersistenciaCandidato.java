package interfaces;

import DTO.Candidato;

public interface IPersistenciaCandidato {
	
	public void inserir(Candidato candidato);
	public void atualizar(Candidato candidato);
	public void deletar(Candidato candidato);
	public void procurar(Candidato candidato);

}
