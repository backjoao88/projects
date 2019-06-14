package jpb.exercicio4;

public class Main {

	public static void main(String[] args)
			throws InstantiationException, 
			IllegalAccessException
	{
	
		Pessoa p = (Pessoa) ServiceFactory.newInstance(Pessoa.class);
		p.setSenha("admin");
		System.out.println(p.encrypt());

	}

}
