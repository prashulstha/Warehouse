import java.util.*;
import java.text.*;
import java.io.*;

class WaitlistedOrder{

    private int orderID;
    private int clientID;
    private int ProductID;
    private int manufacturerID;
    private int waitlistQuantity;


    private WaitlistedOrder(int oId, int cID, int pId, int mID, int q){

        orderID = oId;
        clientID = cID;
        ProductID = pId;
        manufacturerID = mID;
        waitlistQuantity = q;

    }
    public int getWiatlistQuanitity(){
        return waitlistQuantity;
    }

    public String toString(){
        return "Wailisted Order ID: " + orderID + "Waitlist Quanitity: " + waitlistQuantity;
    }
}