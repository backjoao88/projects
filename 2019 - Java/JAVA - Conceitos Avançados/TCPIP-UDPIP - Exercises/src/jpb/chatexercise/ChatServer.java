package jpb.chatexercise;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(3000);
		System.out.println("Server linked to the port 3000.");
		while (true) {
			System.out.println("Waiting for requests...");
			Socket client = serverSocket.accept();
			BufferedReader inServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintStream outServer = new PrintStream(client.getOutputStream());

			String clientName = inServer.readLine();
			System.out.println("Client " + clientName + " connected.");
			
			outServer.println("OK");
			MessageHandler messageHandler = new MessageHandler(client);
			new Thread(messageHandler).start();

		}

	}

}
