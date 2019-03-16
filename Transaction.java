import java.util.*;
import java.lang.*;
import java.io.*;

public class Transaction {
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

	public void setBalance(double amount) {
		this.balance = amount;
	}

	public Transaction instance() {
		return this;
	}
}