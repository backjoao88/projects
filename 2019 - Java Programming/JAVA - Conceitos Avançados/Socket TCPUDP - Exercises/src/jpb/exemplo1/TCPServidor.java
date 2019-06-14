package jpb.exemplo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServidor {

	public static void main(String[] args) throws Exception {

		ServerSocket serverSocket = new ServerSocket(3000);
		Socket clientSocket = serverSocket.accept();

		InputStream is = clientSocket.getInputStream();
		OutputStream os = clientSocket.getOutputStream();

		DataInputStream dis = new DataInputStream(is);
		DataOutputStream dos = new DataOutputStream(os);

		Integer value = dis.readInt();
		value *= 2;
		dos.writeInt(value);

		serverSocket.close();
		clientSocket.close();

	}

}