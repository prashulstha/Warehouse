import java.util.*;
import java.lang.*;
import java.io.*;

public class Product extends Thing {

    private String ProductName;
    private int ProductID;
    private LinkedList<Offer> offerList = new LinkedList<Offer>();
	

    Product(String name, int ID) {
        ProductName = name;
        ProductID = ID;
    }

    String getName() {
        return ProductName;
    }

    int getID() {
        return ProductID;
    }

    public Offer getOffer(int mid) {
        if (offerList.isEmpty())
            return null;
        else {
            ListIterator<Offer> iter = offerList.listIterator();
            while (iter.hasNext()) {
                Offer o = iter.next();
                if (o.getManuID() == mid)
                    return o;
            }
        }
        return null;
    }
	
	
	public boolean addOffer(Offer o) {
		offerList.add(o);
		return true;
	}

    public void deleteOffer(Offer o) {
        offerList.remove(o);
    }

    public Iterator<Offer> getOffers() {
        return offerList.iterator();
    }

    public String toString() {
        return "Product Name: " + ProductName + "\nProduct ID: " + ProductID;
    }
}