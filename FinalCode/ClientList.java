import java.io.Serializable;
import java.util.*;

public class ClientList implements Serializable {

	//the warehouse only has one client list, therefore static
	private static List clients = new LinkedList<Client>();
	private static ClientList ClientList;

	public static boolean addClient(Client c) {
		return clients.add(c);
	}
	public static boolean addClient(int id, float balance, String name) {
		return clients.add(new Client(id, balance, name));
	}
	public static ClientList instance() {
		if (ClientList == null) {
			return (ClientList = new ClientList());
		} else {
			return ClientList;
		}
	}
	public Iterator getClients() {
		return clients.iterator();
	}
}
