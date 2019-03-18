import java.util.*;

public class ProductList extends ParentList {

    private static final long serialVersionUID = 1L;
    private static ProductList productList;

    public static ProductList instance() {
		if (productList == null) {
			return (productList = new ProductList());
		} else
			return productList;
    }
    
    /// returns null if the product id is not in the list
    public Product searchProduct(int id) {
        if (list.isEmpty())
            return null;
        else {
            Iterator iter = productList.getList();
            while (iter.hasNext()) {
                Product p = (Product) iter.next();
                if (p.getID() == id)
                    return p;
            }
        }
        return null;
    }
}