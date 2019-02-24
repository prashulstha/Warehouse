import java.util.*;
import java.text.*;
import java.io.*;

public class Offer implements Serializable {

    double Price;
    int productID;
    int manufacturerID;


    public Offer (int pID, int mID, Double price){
        Price = price;
        productID = pID;
        manufacturerID = mID;

    }

    public double getPrice(){
        return Price;
    }

    public int getProductID(){
        return productID;
    }

    public int getManuID(){
        return manufacturerID;
    }
	
	public String toString() {
		String string = "Manufacturer id: " + manufacturerID + " Product id: " + productID + " Price: " + Price;
		return string;
	}
}