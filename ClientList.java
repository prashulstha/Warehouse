import java.util.*;

public class ClientList extends ParentList {

    private static final long serialVersionUID = 1L;
    private static ClientList clientList;

    private ClientList() {
    }

    public static ClientList instance() {
        if (clientList == null) {
            return (clientList = new ClientList());
        } else
            return clientList;
    }

    public Client searchClient(int clientID) {

        Iterator allClients = clientList.getList();

        while (allClients.hasNext()) {
            Client newClient = (Client) allClients.next();
            int checkID = newClient.getClientID();

            if (checkID == clientID)
                return newClient;
        }
        return null;

    }
}