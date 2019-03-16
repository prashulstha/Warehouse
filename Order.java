import java.util.*;
import java.text.*;
import java.io.*;

class Order{

    private int orderID;
    private int clientID;
    private int productID;
    private int manufacturerID;
    private int  Quantity;
    private int transactionID;
    private OrderIdServer orderIDServer;


   private Order(int oId, int cId, int pId, int mId, int qu, int tras) {

       this.orderID =  (OrderIdServer.instance().getId());
       this.clientID = cId;
       this.productID = pId;
       this.manufacturerID = mId;
       this.Quantity = qu;
       this.transactionID = tras;
       
   }

   int getOrderID(){
       return orderID;
   }
   
   int getClientID(){
       return clientID;
   }

   int getTransactionID(){
       return transactionID;
   }

   public String toString(){
    return "Order ID: " + orderID + "\nClient ID: " + clientID + "\nProduct ID: " + productID + "\nManufacturer ID: " + manufacturerID + "Quantity: " + Quantity + "Transaction ID: " + transactionID;

   }
}