import java.util.*;
import java.text.*;
import java.io.*;

class TestStage1 {

    public static void main(String[] args) {

        Warehouse warehouse = Warehouse.instance();
        System.out.println("Creating Objects for Products and Manufactureres.");

        Product product1 = new Product("Google Pixel", 534);
        Product product2 = new Product("Apple X", 535);
/*
        // Manufacturer manufacturer1 = new Manufacturer("Google LLC", 66);
        // Manufacturer manufacturer2 = new Manufacturer("Apple LLC", 98);
=======

        Manufacturer manufacturer1 = new Manufacturer("Google LLC");
        Manufacturer manufacturer2 = new Manufacturer("Apple LLC");
>>>>>>> 4148fcf451a4c6386d4402320c1c821c8c626438

        System.out.println("Adding all Products to the ProductList: ");
        warehouse.addProduct("Google Pixel", 534);
        warehouse.addProduct("Apple X", 535);

        System.out.println("Adding all Manufacturers to the ProductList: ");
        // warehouse.addMannufacturer("Google LLC", 66);
        // warehouse.addMannufacturer("Apple LLC", 98);

        System.out.println("Creating Offer for Product 1");
        Offer offer1 = new Offer(599.99, product1.getID(), manufacturer1.getManufacturerID());

        warehouse.addOffer(599.99, product1.getID(), manufacturer1.getManufacturerID());
        System.out.println("Offer Successfuly Made.");

        System.out.println("Creating 2 Offer for Product 1.");
        Offer offer2 = new Offer(699.99, product1.getID(), manufacturer2.getManufacturerID());
        warehouse.addOffer(699.99, product1.getID(), manufacturer2.getManufacturerID());
        System.out.println("Offer Successfuly Made.");

        System.out.println("Creating Offer for Product 2.");
        Offer offer3 = new Offer(899.99, product2.getID(), manufacturer2.getManufacturerID());
        warehouse.addOffer(899.99, product2.getID(), manufacturer2.getManufacturerID());
        System.out.println("Offer Successfuly Made.");

        System.out.println("\n\nPrinting Details: ");

        System.out.println("Product 1 Name: " + product1.getName());
        System.out.println("Product 1 ID: " + product1.getID());

        System.out.println("\nProduct 2 Name: " + product2.getName());
        System.out.println("Product 2 ID: " + product1.getID());

        System.out.println("Manufacturer 1 Name: " + manufacturer1.getManufacturerName());
        System.out.println("Manufacturer 1 ID: " + manufacturer1.getManufacturerID());
*/
        System.out.println("Getting All Offers: ");
        Iterator offerList = warehouse.getOffers();
        Product newProduct;
        if (offerList != null) {
            while (offerList.hasNext()) {
                Offer newOffer = (Offer) (offerList.next());
                int searchProductID = newOffer.getProductID();

                newProduct = (warehouse.searchProduct(searchProductID));
                Manufacturer newManufacturer = (Manufacturer) warehouse.searchManufacturer(newOffer.manufacturerID);

                if (newProduct == null) {
                    System.out.println("Sorry no Product Found!");
                } else {
                    System.out.println("Offer for Product: " + searchProductID);
                    System.out.println("Offer Price: " + newOffer.Price);
                    System.out.println("Offer Product ID: " + newProduct.getID());
                    System.out.println("Offer Product Name: " + newProduct.getName());
                    System.out.println("Offer Manufacturer ID: " + newOffer.manufacturerID);
                    System.out.println("Offer Manufacturer Name: " + newManufacturer.getManufacturerName());
                }
            }
        } else
            System.out.println("Sorry no Offers Found!");

    }
}