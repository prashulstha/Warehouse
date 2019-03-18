import java.util.*;

public class TransactionList extends ParentList {

	private static final long serialVersionUID = 1L;
	private static TransactionList trList;

	public static TransactionList instance() {
		if (trList == null)
			return (trList = new TransactionList());
		else
			return trList;
	}

	/// returns a list of transactions that have the specified client ID
	public LinkedList<Transaction> filterListByClient(int cID) {
		LinkedList<Transaction> cLL = new LinkedList<Transaction>();
		Iterator<Thing> iter = trList.getList();
		Transaction t;
		while (iter.hasNext()) {
			t = (Transaction) iter.next();
			if (t.getClientID() == cID) {
				cLL.add(t);
			}
		}
		return cLL;
	}

	/// returns the transaction if found
	/// returns null if not found
	public Transaction searchTransaction(int tID) {
		Iterator<Thing> iter = trList.getList();
		Transaction t;
		while (iter.hasNext()) {
			t = (Transaction) iter.next();
			if (t.getID() == tID) {
				return t;
			}
		}
		return null;
	}
}