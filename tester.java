import java.util.*;
import java.text.*;
import java.io.*;

class Tester{

    public static void main(String[] args) {

        System.out.println("This is a tester for Product and ProductList Class.");
        ProductList productList = ProductList.instance();

        //Creating Dummy Product 1 Object
        System.out.println("Creating Product 1 Object: ");
        Product product1 = new Product("Google Pixel", 534);
        System.out.println("Product 1: " + product1);

        //Creating Product 2 Object
        System.out.println("Creating Product 2 Object: ");
        Product product2 = new Product("Apple X", 535);
        System.out.println("Product 2: " + product2);


        //Adding all Dummy Objects to the List
        System.out.println("Adding all Products to the ProductList: ");
        productList.addProduct(product1);
        productList.addProduct(product2);

        //Calling the getProductList that returns Iterator
        System.out.println("Getting the Iterator for the List of Product. ");
        Iterator pList = productList.getProductList();

        System.out.println("Printing the List of Product from Iterator. ");

        while(pList.hasNext()){
            Product newProduct = (Product)( pList.next());

            System.out.println("Product Object: \n" + newProduct);

            }

    }
}