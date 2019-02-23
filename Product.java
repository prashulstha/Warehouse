import java.util.*;
import java.lang.*;
import java.io.*;

public class Product {

    private String ProductName;
    private int ProductID;

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

    public String toString() {
        return "Product Name: " + ProductName + "\nProduct ID: " + ProductID;
    }
}