import java.util.*;
import java.text.*;
import java.io.*;

class WaitlistedOrder extends Thing {

    private static final long serialVersionUID = -9154368520297126430L;
    private int orderID;
    private int clientID;
    private int ProductID;
    private int manufacturerID;
    private int waitlistQuantity;

    private WaitlistedOrder(int oId, int cID, int pId, int mID, int q) {

        orderID = oId;
        clientID = cID;
        ProductID = pId;
        manufacturerID = mID;
        waitlistQuantity = q;

    }

    public int getWaitlistQuanitity() {
        return waitlistQuantity;
    }

    public String toString() {
        return "Wailisted Order ID: " + orderID + "Waitlist Quanitity: " + waitlistQuantity;
    }
}