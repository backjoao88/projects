package interfaces;

import DTO.Eleitor;

public interface lPersistenciaEleitor {

	public void inserir(Eleitor eleitor);
	public void atualizar(Eleitor eleitor);
	public void deletar(Eleitor eleitor);
	public void procurar(Eleitor eleitor);

}
