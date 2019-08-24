package exercicio1;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		Config config = new Config(new File("config.txt"));

		config.setProperty("version", "1");

	}

}
