import java.util.*;
import java.io.*;
public class ManufacturerList implements Serializable {
  private static final long serialVersionUID = 1L;
  private static List manufacturers = new LinkedList();
  private static ManufacturerList manufacturerList;

  private ManufacturerList() {
  }

  public static ManufacturerList instance() {
    if (manufacturerList == null) {
      return (manufacturerList = new ManufacturerList());
    } else {
      return manufacturerList;
    }
  }

  public boolean insertManufacturer(Manufacturer manufacturer) {
    manufacturers.add(manufacturer);
    return true;
  }
  
  public Iterator getManu() {
	  return manufacturers.iterator();
  }
  
  private void writeObject(java.io.ObjectOutputStream output) {
    try {
		output.defaultWriteObject();
		output.writeObject(manufacturerList);
	}
	catch(IOException ioe) {
		ioe.printStackTrace();
    }
  }
  private void readObject(java.io.ObjectInputStream input) {
    try {
      if (manufacturerList != null) {
        return;
      } else {
        input.defaultReadObject();
        if (manufacturerList == null) {
          manufacturerList = (ManufacturerList) input.readObject();
        } else {
          input.readObject();
        }
      }
    } catch(IOException ioe) {
      ioe.printStackTrace();
    } catch(ClassNotFoundException cnfe) {
      cnfe.printStackTrace();
    }
  }
  public String toString() {
    return manufacturers.toString();
  }
	//returns null if the product id is not in the list
	public static Manufacturer searchManufacturer(int id){
		if(manufacturers.isEmpty())
			return null;
		else {
			ListIterator<Manufacturer> iter = manufacturers.listIterator();
			while(iter.hasNext()) {
				Manufacturer m = iter.next();
				if (m.getId() == id)
					return m;
			}
		}
		return null;
	}
}

