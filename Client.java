import java.util.*;
import java.lang.*;
import java.io.*;

public class Client extends Thing {

    String ClientName;
    int ClientID;
    double Balance;
	private List orderList = new LinkedList<Order>();
	private List waitList = new LinkedList<WaitlistedOrder>();
	private List transList = new LinkedList<Transaction>();

    Client(String name, int ID, float bal) {
        ClientName = name;
        ClientID = ID;
        Balance = bal;
    }

    String getClientName() {
        return ClientName;
    }

    public int getClientID() {
        return ClientID;
    }

    public double getBalance() {
        return Balance;
    }
	
	public boolean updateBalance(double payment) {
		Balance = Balance - payment;
		return true;
	}
	
	public boolean addOrder(Order order) {
		Balance = Balance - (order.getPrice() * order.getQuant());
        orderList.add(order);
        return true;
    }
	
	public boolean addWaitlist(Order order) {
		waitList.add(order);
		return true;
	}

	
	public boolean addTransaction(Transaction transaction) { 
		transList.add(transaction);
		return true;
	}
		
	
	public Iterator getWaitlist() {
        return waitList.iterator();
    }
	
	public Iterator getOrders() {
        return orderList.iterator();
    }

    public String toString() {
        return "Client Name: " + ClientName + "\nClient ID: " + ClientID + "\nClient Balance: " + Balance;
    }
}