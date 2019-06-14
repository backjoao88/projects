package jpb.exercise2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Scanner scan = new Scanner(System.in);

		Socket socketClient = new Socket("localhost", 3000);

		PrintStream outClient = new PrintStream(socketClient.getOutputStream());
		BufferedReader inClient = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

		System.out.print("Type your nickname: ");

		String name = scan.nextLine();

		outClient.println(name);

		inClient.readLine();

		while (true) {

			String cmdServer = inClient.readLine();

			if (cmdServer.equalsIgnoreCase("play")) {
				System.out.print("Choose a row: ");
				int row = scan.nextInt();
				System.out.print("Choose a column: ");
				int column = scan.nextInt();

				outClient.println(row);
				outClient.println(column);
			} else {
				if (cmdServer.equalsIgnoreCase("end")) {
					break;
				} else {
					if (cmdServer.equalsIgnoreCase("draw")) {
						break;
					}
				}
			}

		}

	}

}
