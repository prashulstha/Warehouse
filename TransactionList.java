import java.util.*;
import java.lang.*;
import java.io.*;

public class TransactionList extends ParentList {

	private static final long serialVersionUID = 1L;
	private static TransactionList trList;

	public static TransactionList instance() {
		if (trList == null)
			return (trList = new TransactionList());
		else
			return trList;
	}

	public LinkedList<Client> filterListByClient(int cID) {
		LinkedList<Client> cLL = new LinkedList<Client>();
		Iterator<Thing> iter = trList.getList();
		Client c;
		while (iter.hasNext()) {
			c = (Client) iter.next();
			if (c.ClientID == cID) {
				cLL.add(c);
			}
		}

		return cLL;
	}
}