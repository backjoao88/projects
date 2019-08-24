package jpb.exercise2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Player {

	private int id = 0;
	private char symbol = 0;
	private String nickname = null;
	private Socket clientSocket = null;
	private BufferedReader inPlayer = null;
	private PrintStream outPlayer = null;

	public Player(int id, char symbol, String nickname, Socket clientSocket) {
		this.id = id;
		this.nickname = nickname;
		this.clientSocket = clientSocket;
		this.symbol = symbol;
		try {
			this.outPlayer = new PrintStream(clientSocket.getOutputStream());
			this.inPlayer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public BufferedReader getInPlayer() {
		return inPlayer;
	}

	public void setInPlayer(BufferedReader inPlayer) {
		this.inPlayer = inPlayer;
	}

	public PrintStream getOutPlayer() {
		return outPlayer;
	}

	public void setOutPlayer(PrintStream outPlayer) {
		this.outPlayer = outPlayer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player [id=");
		builder.append(id);
		builder.append(", nickname=");
		builder.append(nickname);
		builder.append(", clientSocket=");
		builder.append(clientSocket);
		builder.append("]");
		return builder.toString();
	}

}
