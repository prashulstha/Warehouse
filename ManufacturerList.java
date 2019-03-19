import java.util.*;
import java.lang.*;
import java.io.*;

public class ManufacturerList extends ParentList {
    
    private static ManufacturerList manufacturerList;

    private ManufacturerList() {

    }

    public static ManufacturerList instance() {
        if (manufacturerList == null) {
            return (manufacturerList = new ManufacturerList());
        } else
            return manufacturerList;
    }
}