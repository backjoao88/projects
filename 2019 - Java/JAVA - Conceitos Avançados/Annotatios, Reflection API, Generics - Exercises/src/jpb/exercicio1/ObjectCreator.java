package jpb.exercicio1;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectCreator {

	/**
	 * 
	 * Recebe uma classe de um tipo genérico, instancia a classe recebida e invoca
	 * todos seus métodos. 
	 * Ao final retorna uma instancia da classe.
	 * Método estático.
	 * 
	 * @param clazz Classe a ser instanciada e ter seus métodos invocados.
	 * @return Instancia da classe
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */

	public static <T> T create(Class<T> clazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		T elemento = clazz.newInstance();
		
		Method[] methods = clazz.getDeclaredMethods();
		
		for (Method m : methods) {
			Init ann = m.getAnnotation(Init.class);
			if(ann.runOnInstantiation()) {
				m.invoke(elemento, 2, 2);
			}
		}
		
		return elemento;

	}

}
