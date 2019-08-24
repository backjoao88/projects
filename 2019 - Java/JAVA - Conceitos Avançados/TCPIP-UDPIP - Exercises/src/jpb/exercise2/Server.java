package jpb.exercise2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {

	static List<Player> players = new ArrayList<Player>();
	final int NUMBER_OF_PLAYERS = 2;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		ServerSocket serverSocket = null;
		Socket client = null;
		BufferedReader inServer = null;
		Player newPlayer = null;
		PrintStream outServer = null;
		try {
			System.out.println("Server started at port 3000.");
			serverSocket = new ServerSocket(3000);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int counter = 0;
		char symbol = 'X';

		while (counter < 2) {
			try {
				client = serverSocket.accept();
				inServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
				outServer = new PrintStream(client.getOutputStream());
				String playerName = inServer.readLine();
				newPlayer = new Player(counter, symbol, playerName, client);
				System.out.println("Player " + playerName + " connected to the game.");
				addPlayer(newPlayer);
				symbol = 'O';
			} catch (IOException e) {
				System.err.println("IOException has been thrown.");
			}
			counter++;
		}

		send(".");

		System.out.println("Starting the game...");

		Table table = new Table(3);

		int indexOfPlayer = 0;
		boolean finished = false;
		Player winner = null;

		while (!finished) {

			Player player = getPlayer(indexOfPlayer);

			char value = 0;
			int row = 0;
			int column = 0;

			player.getOutPlayer().println("play");

			try {
				value = player.getSymbol();
				row = Integer.parseInt(player.getInPlayer().readLine());
				column = Integer.parseInt(player.getInPlayer().readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
			finished = table.insert(value, row, column);
			
			if(table.tableFull()) {
				send("draw");
				break;
			}

			if (finished) {
				winner = player;
				send("end");
				break;
			}
			indexOfPlayer = (indexOfPlayer + 1) % players.size();
		}

		if (winner == null) {
			send("Game finished with no winner.");
		} else {
			winner.getOutPlayer().println("You win! Congratulations!");
		}
		
		for(Player p : players) {
			try {
				p.getClientSocket().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void addPlayer(Player p) {
		players.add(p);
	}

	private static Player getPlayer(int id) {
		for (Player p : players) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	private static void send(Player player, String msg) {
		try {
			PrintStream outPlayer = new PrintStream(player.getClientSocket().getOutputStream());
			outPlayer.println(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void send(Player player, Table table) {
		try {
			ObjectOutputStream outObjectPlayer = new ObjectOutputStream(player.getClientSocket().getOutputStream());
			outObjectPlayer.writeObject(table);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void send(String message) {
		players.forEach(player -> {
			try {
				PrintStream outPlayer = new PrintStream(player.getClientSocket().getOutputStream());
				outPlayer.println(message);
			} catch (IOException e) {
				e.printStackTrace();
			}

		});
	}

	private static void send(Table table) {
		players.forEach(player -> {
			try {
				ObjectOutputStream outObjectPlayer = new ObjectOutputStream(player.getClientSocket().getOutputStream());
				outObjectPlayer.writeObject(table);
			} catch (IOException e) {
				e.printStackTrace();
			}

		});
	}

}
