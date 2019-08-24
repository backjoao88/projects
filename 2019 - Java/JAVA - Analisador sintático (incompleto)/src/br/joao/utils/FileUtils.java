package br.joao.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileUtils {

	public static String inputFileToString(String dir) throws IOException {
		Scanner scan = new Scanner(new FileInputStream(dir));
		StringBuilder builder = new StringBuilder();
		
		while(scan.hasNextLine()) {
			builder.append(scan.nextLine());
			builder.append("\n");
		}
		scan.close();
		return builder.toString();
	}

}
