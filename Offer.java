import java.util.*;
import java.text.*;
import java.io.*;

public class Offer extends Thing {

    double Price;
    int productID;
    int manufacturerID;

    public Offer(double price, int pID, int mID) {
        Price = price;
        productID = pID;
        manufacturerID = mID;

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
        return "Offer Price: " + Price + "\nOffer Product ID: " + productID + "\nOffer Manufacturer ID: "
                + manufacturerID;
    }
}