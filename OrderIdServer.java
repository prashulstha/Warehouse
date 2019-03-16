import java.io.*;

class OrderIdServer implements Serializable{

    private int idCounter;
    private static OrderIdServer orderServer;

    private OrderIdServer(){
        idCounter = 1;
    }
    public static OrderIdServer instance(){
        if(orderServer == null){
            return (orderServer = new OrderIdServer());

        }
        else 
          return orderServer;
    }

    
	public int getId() {
		return idCounter++;
	}

	public String toString() {
		return ("IdServer" + idCounter);
    }
    
    public static void retrieve(ObjectInputStream input) {
		try {
			orderServer = (OrderIdServer) input.readObject();
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		catch(Exception cnfe) {
			cnfe.printStackTrace();
		}
	}
	private void writeObject(java.io.ObjectOutputStream output) throws IOException {
		try {
			output.defaultWriteObject();
			output.writeObject(orderServer);
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	private void readObject(java.io.ObjectInputStream input) throws IOException, ClassNotFoundException {
		try {
			input.defaultReadObject();
			if (orderServer == null) {
				orderServer = (OrderIdServer) input.readObject();
			}
			else {
				input.readObject();
			}
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}