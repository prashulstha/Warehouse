import java.util.*;
import java.lang.*;
import java.io.*;

public class Client {

    String ClientName;
    int ClientID;
    float Balance;
    private static LinkedList<Transaction> transactions = new LinkedList<Transaction>();

    Client(String name, int ID, float bal) {
        ClientName = name;
        ClientID = ID;
        Balance = bal;
    }

    String getClientName() {
        return ClientName;
    }

    int getClientID() {
        return ClientID;
    }

    float getBalance() {
        return Balance;
    }

    boolean addTransaction(Transaction trans) {
        transactions.add(trans);
        return true;
    }

    

    Iterator getClientTransactions() {
        return transactions.iterator();
    }

    public String toString() {
        return "Client Name: " + ClientName + "\nClient ID: " + ClientID + "\nClient Balance: " + Balance;
    }
}