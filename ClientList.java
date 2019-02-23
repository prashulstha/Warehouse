import java.util.*;
import java.lang.*;
import java.io.*;

public class ClientList implements Serializable {

    private static final long serialVersionUID = 1L;
    private List clients = new LinkedList();
    private static ClientList clientList;

    private ClientList() {

    }

    public static ClientList instance() {
        if (clientList == null) {
            return (clientList = new ClientList());
        } else
            return clientList;
    }

    public boolean addClient(Client client) {
        clients.add(client);
        return true;
    }

    public Iterator getClientList() {
        return clients.iterator();
    }

    public Client searchClient(int clientID) {

        Iterator allClients = clientList.getClientList();

        while (allClients.hasNext()) {
            Client newClient = (Client) allClients.next();
            int checkID = newClient.getClientID();

            if (checkID == clientID)
                return newClient;

        }
        return null;

    }

    public String toString() {
        return clients.toString();
    }
}