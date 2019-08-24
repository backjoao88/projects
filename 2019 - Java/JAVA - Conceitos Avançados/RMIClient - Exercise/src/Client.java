import java.rmi.Naming;

public class Client {

	public static void main(String[] args) throws Exception {

		Database database = (Database) Naming.lookup("rmi://localhost:3099/database");
		database.insertOrUpdate("1", "joao");
		database.insertOrUpdate("2", "matt");
		database.insertOrUpdate("3", "luiz");
		database.show();

	}

}
