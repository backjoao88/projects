package jpb.chatexercise;
import java.io.BufferedReader;
import java.io.IOException;

public class ListenerClient implements Runnable {

	private BufferedReader buff = null;
	private boolean clientStop = false;

	public BufferedReader getBuff() {
		return buff;
	}

	public void setBuff(BufferedReader buff) {
		this.buff = buff;
	}

	public ListenerClient(BufferedReader buff) {
		this.buff = buff;
	}

	public boolean isClientStop() {
		return clientStop;
	}

	public void setClientStop(boolean clientStop) {
		this.clientStop = clientStop;
	}

	@Override
	public void run() {
		while (!clientStop) {
			listen();
		}
	}

	public void listen() {
		try {
			if (buff.ready()) {
				String message = buff.readLine();
				System.out.println(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}