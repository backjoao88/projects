package jpb.exercicio4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Pessoa implements Service {

	private String senha = null;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public byte[] encrypt() {
		try {
			MessageDigest md = null;
			md = MessageDigest.getInstance("SHA-1");
			byte[] bytes = md.digest(senha.getBytes());
			return bytes;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

}
