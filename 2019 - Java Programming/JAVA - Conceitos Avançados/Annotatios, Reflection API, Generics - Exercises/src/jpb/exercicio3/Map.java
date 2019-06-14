package jpb.exercicio3;
import java.util.ArrayList;

public class Map<K, V> {

	private ArrayList<K> keys;
	private ArrayList<V> values;

	public Map() {
		this.keys = new ArrayList<K>();
		this.values = new ArrayList<V>();
	}

	public ArrayList<V> getValues() {
		return values;
	}

	public void setValues(ArrayList<V> values) {
		this.values = values;
	}

	public ArrayList<K> getKeys() {
		return keys;
	}

	public void setKeys(ArrayList<K> keys) {
		this.keys = keys;
	}

	public int isRepeatedOnArray(K key) {
		int index;
		for (K k : keys) {
			if (k.equals(key)) {
				index = keys.indexOf(k);
				return index;
			}
		}
		return -1;
	}

	public boolean put(K key, V value) {
		if (key != null && value != null) {
			int index = isRepeatedOnArray(key);
			if (index == -1) {
				getKeys().add(key);
				getValues().add(value);
			} else {
				getValues().remove(index);
				getValues().add(index, value);
			}
			return true;
		}
		return false;
	}

	public V get(K key) {
		int index = getKeys().indexOf(key);
		return (index != -1 && getValues().get(index) != null) ? getValues().get(index) : null;
	}

	public void clear() {
		this.keys = null;
		this.values = null;
	}

	public void show() {
		values.forEach(o -> System.out.println(o));
	}

}
