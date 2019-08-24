package jpb.exercicio4;

public class ServiceFactory{
	
	public static <T extends Service> T newInstance(Class<T> clazz) 
			throws InstantiationException, 
			IllegalAccessException 
	{
		T instance = clazz.newInstance();
		return instance;
		
	}
	

}
