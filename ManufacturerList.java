import java.util.*;
import java.lang.*;
import java.io.*;

public class ManufacturerList implements Serializable {

    private static final long serialVersionUID = 1L;
    private LinkedList<Manufacturer> manufacturers = new LinkedList<Manufacturer>();
    private static ManufacturerList manufacturerList;

    private ManufacturerList() {

    }

    public static ManufacturerList instance() {
        if (manufacturerList == null) {
            return (manufacturerList = new ManufacturerList());
        } else
            return manufacturerList;
    }

    public boolean addManufacturer(Manufacturer manufacturer) {
        manufacturers.add(manufacturer);
        return true;
    }

    public Iterator getManufacturerList() {
        return manufacturers.iterator();
    }

    public String toString() {
        return manufacturers.toString();
    }
}