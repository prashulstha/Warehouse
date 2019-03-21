import java.util.*;
import java.text.*;
import java.io.*;

public class Offer extends Thing {

    double Price;
    int productID;
    int manufacturerID;
	int quantity;
	private LinkedList<Order> waitList = new LinkedList<Order>();

    public Offer(double price, int pID, int mID) {
        Price = price;
        productID = pID;
        manufacturerID = mID;
		quantity = 0;
    }
	
	public int updateQuantity(int quant) {
		quantity = quantity + quant;
		return quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}

    public double getPrice() {
        return Price;
    }

    public int getProductID() {
        return productID;
    }

    public int getManuID() {
        return manufacturerID;
    }

    public String toString() {
        return "Offer Price: " + Price + "\nOffer Product ID: " + productID + "\nOffer Manufacturer ID: " + manufacturerID;
    }
	
	public boolean addWaitlist(Order o) {
		waitList.add(o);
		return true;
	}
	
	public boolean deleteWaitlist(Order o) {
		waitList.remove(o);
		return true;
	}
	
	public Iterator<Order> getWaitlist() {
		return waitList.iterator();
	}
}