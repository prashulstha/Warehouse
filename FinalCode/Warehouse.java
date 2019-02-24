import java.util.*;
import java.io.*;
public class Warehouse implements Serializable {
	private ManufacturerList manufacturerList;
	private ClientList clientList;
	private ProductList productList;
	private static Warehouse warehouse;

	private Warehouse() {
		manufacturerList = ManufacturerList.instance();
		clientList = ClientList.instance();
		productList = ProductList.instance();
	}

	public static Warehouse instance() {
		if (warehouse == null) {
			ManufacturerIdServer.instance();
			return (warehouse = new Warehouse());
		} else {
			return warehouse;
		}
	}

	public Manufacturer addManufacturer(String name) {
		Manufacturer manufacturer = new Manufacturer(name);
		if (manufacturerList.insertManufacturer(manufacturer)) {
			return (manufacturer);
		}
		return null;
	}

	public Client addClient(String name, int id, float balance) {
		Client client = new Client(id, balance, name);
		if (ClientList.addClient(client)) {
			return (client);
		}
		return null;
	}

	public Product addProduct(String name, int id) {
		Product product = new Product(name, id);
		if (ProductList.addProduct(product)) {
			return (product);
		}
		return null;
	}
	
	public Iterator getClients() {
		return clientList.getClients();
	}
	
	public Iterator getManufacturers() {
		return manufacturerList.getManu();
	}
	
	public Iterator getProducts() {
		return productList.getProductList();
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
			output.writeObject(MemberidServer.instance());
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

	public Product searchProductList(int id) {
		return productList.searchProduct(id);
	}

	public Manufacturer searchManuList(int id) {
		return ManufacturerList.searchManufacturer(id);
	}
	
	public Offer addOffer(Product p, Manufacturer m, double price) {
		Offer o = new Offer(p.getID(), m.getId(), price);
		if (p.addOffer(o) && m.addOffer(o))
			return o;
		return null;
	}
	
	public void removeOffer (Product product, Manufacturer manufacturer, Offer offer) {
		product.deleteOffer(offer);
		manufacturer.deleteOffer(offer);
	}
	
	public Offer searchOffer(int pid, int mid) {
		Product p = productList.searchProduct(pid);
		if (p != null) {
			Offer o = p.getOffer(mid);
			return o;
		}
		else 
			return null;
	}
	
	public Iterator getSupplies(Manufacturer manufacturer) {
		return manufacturer.getOffers();
	}
	
	public Iterator getSuppliers(Product p) {
		return p.getOffers();
	}
}