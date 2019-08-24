package jpb.exercicio2;

import java.lang.reflect.Field;

/**
 * Classe que auxilia no retorno e atribuição de campos.
 * Todos seus métodos são estáticos.
 * 
 * @author João Paulo Back
 *
 */

public class Property {
	
	/**
	 * Seta um atributo da instancia do objeto.
	 * 
	 * @param obj       Instancia do objeto
	 * @param attribute Atributo requerido
	 * @param clazz     Instancia da classe do atributo a ser setado.
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */

	public static <T, K> void set(K obj, String attribute, T value)
			throws 
			NoSuchFieldException, 
			SecurityException,
			IllegalArgumentException,
			IllegalAccessException 
	{

		Class<?> objClass = obj.getClass();

		Field field = objClass.getDeclaredField(attribute);
		field.setAccessible(true);

		Class<?> attClass = field.getType();

		if (attClass.isAssignableFrom(value.getClass())) {
			field.set(obj, value);
		}

	}

	/**
	 * 
	 * Retorna um atributo da instancia do objeto.
	 * 
	 * @param obj       Instancia do objeto
	 * @param attribute Atributo requerido
	 * @param clazz     Instancia da classe do atributo a ser retornado.
	 * @return Valor do atributo
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */



	@SuppressWarnings("unchecked")
	public static <T, K> T get(K obj, String attribute, Class<T> clazz)
			throws NoSuchFieldException,
			SecurityException, 
			IllegalArgumentException,
			IllegalAccessException 
	
	{

		
		/*
		 * Carro carro = new Carro(); Property.get(carro, "cor", String.class);
		 * 
		 */
		
		T value = null;

		// T = classe do atributo
		Class<?> objClass = obj.getClass(); // classe do atributo

		Field field = objClass.getDeclaredField(attribute);
		field.setAccessible(true);

		Class<?> attClass = field.getType();

		if (clazz.isAssignableFrom(attClass)) {
			value = (T) field.get(obj);
		}
		return value;

	}

}
