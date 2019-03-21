class Order extends Thing {

    private static final long serialVersionUID = 7442516981767694296L;
    private int orderID;
    private int clientID;
    private int productID;
	private double price;
    private int Quantity;
    private int transactionID;

    public Order(int cId, int pId, double price, int qu, int tras) {
        this.orderID = (OrderIdServer.instance().getId());
        this.clientID = cId;
        this.productID = pId;
        this.price = price;
        this.Quantity = qu;
        this.transactionID = tras;
    }

    int getOrderID() {
        return orderID;
    }
	
	double getPrice() {
		return price;
	}
	
	int getQuant() {
		return Quantity;
	}

    int getClientID() {
        return clientID;
    }

    int getTransactionID() {
        return transactionID;
    }

    public String toString() {
        return "Order ID: " + orderID + "\nClient ID: " + clientID + "\nProduct ID: " + productID
                + "\nQuantity: " + Quantity + "\nTransaction ID: " + transactionID;

    }
}