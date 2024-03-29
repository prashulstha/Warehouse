import java.util.*;
import java.text.*;
import java.io.*;
public class UserInterface implements Serializable {
  private static final long serialVersionUID = 1L;
  private static UserInterface userInterface;
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private static Warehouse warehouse;

  //commands
  private static final int EXIT = 0;
  private static final int ADD_CLIENT = 1;
  private static final int ADD_MANUFACTURER = 2;
  private static final int ADD_PRODUCTS = 3;
  private static final int ASSIGN_PRODUCT = 4;
  private static final int UNASSIGN_PRODUCT = 5;
  private static final int SHOW_CLIENTS = 6;
  private static final int SHOW_MANUFACTURERS = 7;
  private static final int SHOW_PRODUCTS = 8;
  private static final int SHOW_SUPPLIERS = 9;
  private static final int SHOW_SUPPLIES = 10;
  private static final int SAVE =11;
  private static final int HELP = 12;

  public UserInterface() {
	  if (yesOrNo("Look for saved data and use it?")) {
		  retrieve();
	  }
	  else {
		  warehouse = Warehouse.instance();
	  }
	  process();
  }
  public static UserInterface instance() {
    if (userInterface == null) {
      return userInterface = new UserInterface();
    } else {
      return userInterface;
    }
  }
  public String getToken(String prompt) {
    do {
      try {
        System.out.println(prompt);
        String line = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line,"\n\r\f");
        if (tokenizer.hasMoreTokens()) {
          return tokenizer.nextToken();
        }
      } catch (IOException ioe) {
        System.exit(0);
      }
    } while (true);
  }
	public int getNumber(String prompt) {
		do {
			try {
				String item = getToken(prompt);
				Integer num = Integer.valueOf(item);
				return num.intValue();
			} catch (NumberFormatException nfe) {
				System.out.println("Please input a number ");
			}
		} while (true);
	}
	public double getDouble(String prompt) {
		do {
			try {
				String item = getToken(prompt);
				Double num = Double.valueOf(item);
				return num.doubleValue();
			} catch (NumberFormatException nfe) {
				System.out.println("Please input a number ");
			}
		} while (true);
	}
  public boolean yesOrNo(String prompt) {
    String more = getToken(prompt + " (Y/N)");
	  return more.charAt(0) == 'y' || more.charAt(0) == 'Y';
  }
  public int getCommand() {
    do {
      try {
        int value = Integer.parseInt(getToken("Enter command," + HELP + " for help"));
        if (value >= EXIT && value <= HELP) {
          return value;
        }
      } catch (NumberFormatException nfe) {
        System.out.println("Please retry with a number");
      }
    } while (true);
  }
  public void help() {
	  System.out.println("Enter a number between 0 and 11:");
	  System.out.println(EXIT + " to Exit");
	  System.out.println(ADD_CLIENT + " to add a new client");
	  System.out.println(ADD_MANUFACTURER + " to add a new manufacturer");
	  System.out.println(ADD_PRODUCTS + " to add new products");
	  System.out.println(ASSIGN_PRODUCT + " to assign a product to a manufacturer");
	  System.out.println(UNASSIGN_PRODUCT + " to unassign a product to a manufacturer");
	  System.out.println(SHOW_CLIENTS + " to show a clients based on appropriate fields");
	  System.out.println(SHOW_MANUFACTURERS + " to show manufacturers based on appropriate fields");
	  System.out.println(SHOW_PRODUCTS + " to show products based on appropriate fields");
	  System.out.println(SHOW_SUPPLIERS + " to show suppliers and prices of a part");
	  System.out.println(SHOW_SUPPLIES + " to show manufacturers and all products they offer");
	  System.out.println(SAVE + " to save the warehouse");
	  System.out.println(HELP + " for help");
  }
  
  public void addClient() {
	  String name = getToken("Enter client name ");
	  int id = getNumber("Enter client ID ");
	  float balance = getNumber("Enter client balance ");
	  Client result;
	  result = warehouse.addClient(name, id, balance);
	  if (result == null) {
		System.out.println("Could not add member");
	  }
	  System.out.println(result.toString());
  }
  
  public void addManufacturer() {
	  String name = getToken("Enter manufacturer name ");
	  Manufacturer result;
	  result = warehouse.addMannufacturer(name);
	  if (result == null) {
		System.out.println("Could not add manufacturer");
	  }
	  System.out.println(result.toString());
  }
  
  public void addProducts() {
	  Product result;
	  do {
		String name = getToken("Enter product name ");
		int id =  getNumber("Enter product ID ");
		result = warehouse.addProduct(name, id);
		if (result == null) {
			System.out.println("Could not add manufacturer");
		}
		System.out.println(result.toString());
		if (!yesOrNo("Add more products?")) {
			break;
		}
	  } while (true);
  }

  public void assignProduct() {
	  int id =  getNumber("Enter product ID ");
	  Product p = warehouse.searchProduct(id);
		if (p != null) { // we found it

			id = getNumber("Enter manufacturer ID ");
			Manufacturer m = warehouse.searchManufacturer(id);
			if (m != null) {
				Offer o = warehouse.searchOffer(p.getID(), m.getManufacturerID());
				if (o == null) {
					double price = getDouble("Enter the offer's price");
					Offer offer = warehouse.addOffer(price, p.getID(), m.getManufacturerID());
					System.out.println(offer.toString());
				} else
					System.out.println("Offer for product from manufacturer already exists");
			} else
				System.out.println("Could not find the manufacturer ID");
		} else
			System.out.println("Could not find the product ID");
	}

	public void unassignProduct() {
		int id = getNumber("Enter product ID ");
		Product p = warehouse.searchProduct(id);
		if (p != null) { // we found it

			id = getNumber("Enter manufacturer ID ");
			Manufacturer m = warehouse.searchManufacturer(id);
			if (m != null) {
				Offer offer = warehouse.searchOffer(p.getID(), m.getManufacturerID());
				if (offer != null) {
					warehouse.removeOffer(p, m, offer);
					System.out.println("Offer has been unassigned");
				}
			} else
				System.out.println("Could not find the manufacturer ID");
		} else
			System.out.println("Could not find the product ID");
	}

	public void showManufacturers() {
		Iterator allMaufacturers = warehouse.getManufacterers();
		while (allMaufacturers.hasNext()) {
			Manufacturer manufacturer = (Manufacturer) (allMaufacturers.next());
			System.out.println(manufacturer.toString());
		}
	}

	public void showProducts() {
		Iterator allProducts = warehouse.getProducts();
		while (allProducts.hasNext()) {
			Product product = (Product) (allProducts.next());
			System.out.println(product.toString());
		}
	}

	public void showClients() {
		Iterator allClients = warehouse.getClients();
		while (allClients.hasNext()) {
			Client client = (Client) (allClients.next());
			System.out.println(client.toString());
		}
	}

	public void showSupplied() {
		int id;
		id = getNumber("Please enter product Id: ");
		Product p = warehouse.searchProduct(id);
		if (p != null) {
			Iterator allOffers = warehouse.getSuppliers(p);
			while (allOffers.hasNext()) {
				Offer offer = (Offer)(allOffers.next());
				System.out.println(offer.toString());
			}
		}
		else
			System.out.println("Could not find product");
	}
	
	public void showSupplies() {
		Iterator allMaufacturers = warehouse.getManufacterers();
		while (allMaufacturers.hasNext()) {
			Manufacturer manufacturer = (Manufacturer)(allMaufacturers.next());
			Iterator allOffers = manufacturer.getOffers();
			while (allOffers.hasNext()) {
				Offer offer = (Offer)(allOffers.next());
				System.out.println(offer.toString());
			}
		}
	}

	public void save() {
		if (Warehouse.save()) {
			System.out.println("Warehouse has been saved");
		}
		else {
			System.out.println("Error while saving");
		}
	}
  
	private void retrieve() {
		try {
			Warehouse tempWarehouse = Warehouse.retrieve();
			if (tempWarehouse != null) {
				System.out.println(" The warehouse has been successfully retrieved from the file WarehouseData \n" );
				warehouse = tempWarehouse;
			} 
			else {
				System.out.println("File doesnt exist; creating new warehouse" );
				warehouse = Warehouse.instance();
			}
		}
		catch(Exception cnfe) {
			cnfe.printStackTrace();
		}
	}
  
	public void process() {
		int command;
		help();
		while ((command = getCommand()) != EXIT) {
			switch (command) {
				case ADD_CLIENT:			addClient();
											break;
				case ADD_MANUFACTURER: 		addManufacturer();
											break;
				case ADD_PRODUCTS:			addProducts();
											break;
				case HELP:					help();
											break;
				case ASSIGN_PRODUCT:        assignProduct();
											break;
				case UNASSIGN_PRODUCT:      assignProduct();
											break;
				case SHOW_CLIENTS:			showClients();
											break;
				case SHOW_MANUFACTURERS:	showManufacturers();
											break;
				case SHOW_PRODUCTS:			showProducts();
											break;
				case SHOW_SUPPLIERS:		showSupplied();
											break;
				case SHOW_SUPPLIES:			showSupplies();
											break;
				case SAVE:					save();
											break;
			}
		}
	}
  
	public static void main(String[] args) {
		UserInterface.instance();
	}
}
		
		
  
