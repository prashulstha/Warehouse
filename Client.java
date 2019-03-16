import java.util.*;
import java.lang.*;
import java.io.*;

public class Client{

    String ClientName;
    int ClientID;
    float Balance;

    Client(String name, int ID, float bal){
        ClientName = name;
        ClientID = ID;
        Balance = bal;
    }

    String getClientName(){
        return ClientName;
    }

    int getClientID(){
        return ClientID;
    }

    float getBalance(){
        return Balance;
    }
    public String toString() {
        return "Client Name: " + ClientName + "\nClient ID: " + ClientID + "\nClient Balance: " + Balance;
      }
}