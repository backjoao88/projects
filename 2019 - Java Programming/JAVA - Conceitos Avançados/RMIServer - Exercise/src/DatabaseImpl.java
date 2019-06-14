

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DatabaseImpl implements Database{

	private Map<String, String> databaseMap = new TreeMap<String, String>();

	@Override
	public void insertOrUpdate(String key, String value) {
		databaseMap.put(key, value);
	}

	@Override
	public String get(String key) {
		return databaseMap.get(key);
	}

	@Override
	public void delete(String key) {
		databaseMap.remove(key);
	}

	@Override
	public List<String> getValues() {
		return (List<String>) databaseMap.values();
	}
	
	public void show() {
		databaseMap.forEach((key, value) ->{
			System.out.println("Key --> " + key + ", Value --> " + value);
		});
	}
	
}
