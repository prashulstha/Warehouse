import java.util.*;
import java.lang.*;
import java.io.*;

public class Product implements Serializable {

    private String ProductName;
    private int ProductID;
    private List offerList = new LinkedList<Offer>();

    Product(String name, int ID) {
        ProductName = name;
        ProductID = ID;
    }

    public boolean addOffer(Offer offer) {
        offerList.add(offer);
        return true;
    }

    public String getName() {
        return ProductName;
    }
	
	public Offer getOffer(int mid) {
		if(offerList.isEmpty())
            return null;
        else {
            ListIterator<Offer> iter = offerList.listIterator();
            while(iter.hasNext()) {
                Offer o = iter.next();
                if (o.getManuID() == mid)
                    return o;
            }
        }
        return null;
    }

    int getID() {
        return ProductID;
    }

    public String toString() {
        return "Product Name: " + ProductName + "\nProduct ID: " + ProductID;
    }

    public void deleteOffer(Offer o) {
        offerList.remove(o);
    }
	
	public Iterator getOffers() {
		return offerList.iterator();
	}
}