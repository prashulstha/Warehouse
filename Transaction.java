public class Transaction extends Thing {
	private static final long serialVersionUID = 1530053204090450305L;
	private int transactionID;
	private int clientID;
	private double balance;

	public Transaction(int tID, int cID, double bal) {
		this.transactionID = tID;
		this.clientID = cID;
		this.balance = bal;
	}

	public double getBalance() {
		return balance;
	}

	public int getClientID() {
		return clientID;
	}

	public void setBalance(double amount) {
		this.balance = amount;
	}

	public int getID() {
		return transactionID;
	}

	public Transaction instance() {
		return this;
	}
}