package jpb.chatexercise;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient2 {

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);

		Socket client = new Socket("localhost", 3000);

		BufferedReader inClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
		PrintStream outClient = new PrintStream(client.getOutputStream());

		System.out.println("Type your name: ");
		String nameClient = scan.nextLine();

		outClient.println(nameClient);

		String serverResponse = inClient.readLine();

		if (serverResponse.equalsIgnoreCase("OK")) {

			ListenerClient listener = new ListenerClient(inClient);
			new Thread(listener).start();

			while (true) {
				String message = scan.nextLine();
				outClient.println(message);

				if (message.equalsIgnoreCase("quit")) {
					listener.setClientStop(true);
					break;
				}
			}
		} else {
			System.err.println("Could not reach the server. Sorry.");
			client.close();
		}
		scan.close();
		client.close();
	}

}
