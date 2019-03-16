import java.util.*;
import java.lang.*;
import java.io.*;

public class Manufacturer{

    String ManufacturerName;
    int ManufacturerID;

    public Manufacturer(String name){
        ManufacturerName = name;

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