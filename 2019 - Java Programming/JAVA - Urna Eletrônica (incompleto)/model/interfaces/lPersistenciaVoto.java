package interfaces;

import DTO.Voto;

public interface lPersistenciaVoto {
	
	public void inserir(Voto voto);
	public void atualizar(Voto voto);
	public void deletar(Voto voto);
	public void procurar(Voto voto);

}
