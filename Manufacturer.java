import java.util.*;
import java.lang.*;
import java.io.*;

public class Manufacturer extends Thing {

    private static final long serialVersionUID = 1L;

    String ManufacturerName;
    int ManufacturerID;
    private List offerList = new LinkedList<Offer>();

    public Manufacturer(String name) {
        ManufacturerName = name;
        ManufacturerID = (ManufacturerIdServer.instance()).getId();
    }

    String getManufacturerName() {
        return ManufacturerName;
    }

    int getManufacturerID() {
        return ManufacturerID;
    }

    public String toString() {
        return "Manufacturer Name: " + ManufacturerName + "\nManufacturer ID: " + ManufacturerID;
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