import java.util.*;
import java.io.*;

public class Warehouse implements Serializable {
    private static final long serialVersionUID = 1L;
    private ProductList productList;
    private ManufacturerList manufacturerList;
    private ClientList clientList;
    private OfferList offerList;
    private static Warehouse warehouse;

    private Warehouse() {
        productList = ProductList.instance();
        manufacturerList = ManufacturerList.instance();
        offerList = OfferList.instance();
        clientList = ClientList.instance();
    }

    public static Warehouse instance() {
        if (warehouse == null) {
        //   MemberIdServer.instance(); // instantiate all singletons
          return (warehouse = new Warehouse());
        } else {
          return warehouse;
        }
      }

    public Product addProduct(String name, int id) {
        Product product = new Product(name, id);
        if (productList.addProduct(product)) {
            return (product);
        }
        return null;
    }

    public Manufacturer addMannufacturer(String name, int id) {
        Manufacturer manufacturer = new Manufacturer(name, id);
        if (manufacturerList.addManufacturer(manufacturer)) {
            return (manufacturer);
        }
        return null;
    }

    public Client addClient(String name, int id) {
        Client client = new Client(name, id);
        if (clientList.addClient(client)) {
          return (client);
        }
        return null;
      }

      public Offer addOffer(double price, int pID, int mId) {
        Offer offer = new Offer(price, pID, mId);
        if (offerList.addOffers(offer)) {
          return (offer);
        }
        return null;
      }

    public Iterator getProducts() {
        return productList.getProductList();
    }

    public Iterator getManufacterers() {
        return manufacturerList.getManufacturerList();
    }

    
    public Iterator getClients() {
        return clientList.getClientList();
    }

    public Iterator getOffers() {
        return offerList.getOfferList();
    }
  

    public Product searchProduct(int pID) {
        Iterator allProducts = productList.getProductList();

        while (allProducts.hasNext()) {
            Product newProduct = (Product)( allProducts.next());
            int checkID = newProduct.getID();

            if (pID == checkID){
                return newProduct;
            }
              
           
        }
        
        return null;
    }

    public Manufacturer searchManufacturer(int manufacturerID) {

        Iterator allManufacturer = manufacturerList.getManufacturerList();

        while (allManufacturer.hasNext()) {
            Manufacturer newManufacturer = (Manufacturer) allManufacturer.next();
            int checkID = newManufacturer.getManufacturerID();

            if (checkID == manufacturerID)
                return newManufacturer;

        }
        return null;
    }

    public String toString() {
        return productList + "\n" + manufacturerList + "\n" + clientList;
      }
}