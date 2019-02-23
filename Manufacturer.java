import java.util.*;
import java.lang.*;
import java.io.*;

public class Manufacturer{

    String ManufacturerName;
    int ManufacturerID;

    Manufacturer(String name, int ID){
        ManufacturerName = name;
        ManufacturerID = ID;
    }

    String getManufacturerName(){
        return ManufacturerName;
    }

    int getManufacturerID(){
        return ManufacturerID;
    }

    public String toString() {
        return "Manufacturer Name: " + ManufacturerName + "\nManufacturer ID: " + ManufacturerID;
      }
}