package exercicio1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Config {

	private Properties properties = null;
	private InputStream propertiesInput = null;
	private OutputStream propertiesOutput = null;

	public Config(File file) {
		properties = new Properties();
		try {
			propertiesInput = new FileInputStream(file);
			propertiesOutput = new FileOutputStream(file);
			if (file.exists()) {
				properties.load(propertiesInput);
			}
		} catch (FileNotFoundException e) {
			try {
				file.createNewFile();
				file.setWritable(true);
				file.setReadable(true);
				propertiesInput = new FileInputStream(file);
				propertiesOutput = new FileOutputStream(file);
				setProperty("nome", "config");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getPropertyAsString(String key) {
		return properties.containsKey(key) ? properties.getProperty(key) : null;
	}

	public Integer getPropertyAsInteger(String key) {
		return properties.containsKey(key) ? Integer.parseInt(properties.getProperty(key)) : null;
	}

	public Boolean getPropertyAsBoolean(String key) {
		return properties.containsKey(key) ? Boolean.parseBoolean(properties.getProperty(key)) : null;
	}

	public void setProperty(String name, String value) {
		properties.setProperty(name, value);
		try {
			properties.store(propertiesOutput, "arquivo config");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setProperty(String name, Integer value) {
		setProperty(name, value.toString());
	}

	public void setProperty(String name, Double value) {
		setProperty(name, value.toString());
	}

	public void setProperty(String name, Boolean value) {
		setProperty(name, value.toString());
	}

}
