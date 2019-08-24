


import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Registery {

	public static void main(String[] args) throws RemoteException, MalformedURLException {

		Database database = new DatabaseImpl();
		Registry reg = LocateRegistry.createRegistry(3099);
		Database stub = (Database) UnicastRemoteObject.exportObject(database, 3099);
		reg.rebind("database", stub);
		System.out.println("Aguardando requisições...");

	}

}
