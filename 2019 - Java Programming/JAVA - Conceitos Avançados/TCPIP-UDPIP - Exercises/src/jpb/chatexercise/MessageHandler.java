package jpb.chatexercise;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MessageHandler implements Runnable {

	Socket client = null;

	static List<Socket> clientSockets = new ArrayList<Socket>();

	BufferedReader inServer = null;
	PrintStream outServer = null;

	public MessageHandler(Socket client) {
		this.client = client;
		try {
			inServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
			outServer = new PrintStream(client.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public synchronized void addClient(Socket client) {
		clientSockets.add(client);
	}

	@Override
	public void run() {

		sendAll("Client " + client + " join the chat.");

		addClient(client);

		while (true) {

			String message = null;
			try {
				message = inServer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (message.equals("quit")) {
				sendAll("Um cliente saiu do chat!");
				removeClient(client);
				break;
			}

			sendAll("Um cliente disse: " + message);

		}

	}

	private synchronized void removeClient(Socket client) {
		clientSockets.remove(client);
	}

	private void sendAll(String message) {

		clientSockets.forEach(client -> {
			try {
				PrintStream outClient = new PrintStream(client.getOutputStream());
				outClient.println(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

	}

}
