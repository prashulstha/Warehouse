import java.util.*;
import java.lang.*;
import java.io.*;

public class ProductList implements Serializable{

    private static final long serialVersionUID = 1L;
    private List products = new LinkedList();
    private static ProductList productList;

    private ProductList(){
      
    }

    public static ProductList instance(){
        if(productList == null){
            return (productList = new ProductList());
        }
        else
          return productList;
    }

    public boolean addProduct(Product product){
        products.add(product);
        return true;
    }

    public Iterator getProductList(){
        return products.iterator();
    }
  //returns null if the product id is not in the list
  public Product searchProduct(int id){
    if(products.isEmpty())
        return null;
    else {
        Iterator iter = productList.getProductList();
        while(iter.hasNext()) {
            Product p = (Product) iter.next();
            if (p.getID() == id)
                return p;
        }
    }
    return null;
}

    public String toString(){
        return products.toString();
    }
}