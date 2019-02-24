import java.util.*;
import java.lang.*;
import java.io.*;

public class ProductList implements Serializable{

    private static final long serialVersionUID = 1L;
    private static List pCatalog = new LinkedList();
    private static ProductList pList;

    private ProductList(){
      
    }

    public static ProductList instance(){
        if(pList == null){
            return (pList = new ProductList());
        }
        else
          return pList;
    }

    public static boolean addProduct(Product product){
        return pCatalog.add(product);
    }

    public Iterator getProductList(){
        return pCatalog.iterator();
    }

    //returns null if the product id is not in the list
    public Product searchProduct(int id){
        if(pCatalog.isEmpty())
            return null;
        else {
            ListIterator<Product> iter = pCatalog.listIterator();
            while(iter.hasNext()) {
                Product p = iter.next();
                if (p.getID() == id)
                    return p;
            }
        }
        return null;
    }

    public String toString(){
        return pCatalog.toString();
    }
}