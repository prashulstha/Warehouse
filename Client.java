import java.util.*;
import java.lang.*;
import java.io.*;

public class Client{

    String ClientName;
    int ClientID;

    Client(String name, int ID){
        ClientName = name;
        ClientID = ID;
    }

    String getClientName(){
        return ClientName;
    }

    int getClientID(){
        return ClientID;
    }

    public String toString() {
        return "Client Name: " + ClientName + "\nClient ID: " + ClientID;
      }
}