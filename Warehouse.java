import java.util.*;
import java.io.*;

public class Warehouse implements Serializable {

  private static final long serialVersionUID = 1L;
  private ProductList productList;
  private ManufacturerList manufacturerList;
  private ClientList clientList;
  private OfferList offerList;
  private static Warehouse warehouse;
  private TransactionList transactionList;
  private WaitListedOrderList waitlistedOrderList;

  private Warehouse() {
    productList = ProductList.instance();
    manufacturerList = ManufacturerList.instance();
    offerList = OfferList.instance();
    clientList = ClientList.instance();
  }

  public static Warehouse instance() {
    if (warehouse == null) {
      // MemberIdServer.instance(); // instantiate all singletons
      return (warehouse = new Warehouse());
    } else {
      return warehouse;
    }
  }

  public Product addProduct(String name, int id) {
    Product product = new Product(name, id);
    if (productList.add(product)) {
      return (product);
    }
    return null;
  }

  public Manufacturer addMannufacturer(String name) {
    Manufacturer manufacturer = new Manufacturer(name);
    if (manufacturerList.add(manufacturer)) {
      return (manufacturer);
    }
    return null;
  }

  public Client addClient(String name, int id, float bal) {
    Client client = new Client(name, id, bal);
    if (clientList.add(client)) {
      return (client);
    }
    return null;
  }

  public Offer addOffer(double price, int pID, int mId) {
    Offer offer = new Offer(price, pID, mId);
    if (offerList.add(offer)) {
      return (offer);
    }
    return null;
  }

  public Iterator<Thing> getProducts() {
    return productList.getList();
  }

  public Iterator<Thing> getManufacterers() {
    return manufacturerList.getList();
  }

  public Iterator<Thing> getClients() {
    return clientList.getList();
  }

  public Iterator getOffers() {
    return offerList.getList();
  }

  public Product searchProduct(int pID) {
    Iterator allProducts = productList.getList();

    while (allProducts.hasNext()) {
      Product newProduct = (Product) (allProducts.next());
      int checkID = newProduct.getID();

      if (pID == checkID) {
        return newProduct;
      }
    }
    return null;
  }

  public Manufacturer searchManufacturer(int manufacturerID) {

    Iterator allManufacturer = manufacturerList.getList();

    while (allManufacturer.hasNext()) {
      Manufacturer newManufacturer = (Manufacturer) allManufacturer.next();
      int checkID = newManufacturer.getManufacturerID();

      if (checkID == manufacturerID)
        return newManufacturer;
    }
    return null;
  }

  public void removeOffer(Product product, Manufacturer manufacturer, Offer offer) {
    product.deleteOffer(offer);
    manufacturer.deleteOffer(offer);
  }

  public Offer searchOffer(int pid, int mid) {
    Product p = productList.searchProduct(pid);
    if (p != null) {
      Offer o = p.getOffer(mid);
      return o;
    } else
      return null;
  }

  public Iterator getSupplies(Manufacturer manufacturer) {
    return manufacturer.getOffers();
  }

  public Iterator getSuppliers(Product p) {
    return p.getOffers();
  }

  public String toString() {
    return productList + "\n" + manufacturerList + "\n" + clientList;
  }

  public static Warehouse retrieve() {
    try {
      FileInputStream file = new FileInputStream("WarehouseData");
      ObjectInputStream input = new ObjectInputStream(file);
      input.readObject();
      ManufacturerIdServer.retrieve(input);
      return warehouse;
    } catch (IOException ioe) {
      ioe.printStackTrace();
      return null;
    } catch (ClassNotFoundException cnfe) {
      cnfe.printStackTrace();
      return null;
    }
  }

  public static boolean save() {
    try {
      FileOutputStream file = new FileOutputStream("WarehouseData");
      ObjectOutputStream output = new ObjectOutputStream(file);
      output.writeObject(warehouse);
      output.writeObject(ManufacturerIdServer.instance());
      return true;
    } catch (IOException ioe) {
      ioe.printStackTrace();
      return false;
    }
  }

  private void writeObject(java.io.ObjectOutputStream output) {
    try {
      output.defaultWriteObject();
      output.writeObject(warehouse);
    } catch (IOException ioe) {
      System.out.println(ioe);
    }
  }

  private void readObject(java.io.ObjectInputStream input) {
    try {
      input.defaultReadObject();
      if (warehouse == null) {
        warehouse = (Warehouse) input.readObject();
      } else {
        input.readObject();
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}