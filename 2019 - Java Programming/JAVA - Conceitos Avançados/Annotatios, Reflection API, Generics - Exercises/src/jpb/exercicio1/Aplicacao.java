package jpb.exercicio1;
import java.lang.reflect.InvocationTargetException;

public class Aplicacao {

	public static void main(String[] args) {
		
		try {
			ObjectCreator.create(Operacao.class);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
