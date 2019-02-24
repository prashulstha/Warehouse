import java.util.*;
import java.io.*;
public class Manufacturer implements Serializable {
	private static final long serialVersionUID = 1L;
	private List offerList = new LinkedList<Offer>();
	private String name;
	private int id;
	public Manufacturer (String name) {
		this.name = name;
		id = (ManufacturerIdServer.instance()).getId();
	}
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public String toString() {
		String string = "Manufacturer name " + name + " id " + id;
		return string;
	}
	
	public boolean addOffer(Offer offer) {
        offerList.add(offer);
        return true;
    }
	
	public void deleteOffer(Offer o) {
        offerList.remove(o);
    }
	
	public Iterator getOffers() {
		return offerList.iterator();
	}
}
	