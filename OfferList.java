import java.util.*;
import java.lang.*;
import java.io.*;

public class OfferList implements Serializable{

    private static final long serialVersionUID = 1L;
    private List offers = new LinkedList();
    private static OfferList offerList;

    private OfferList(){
      
    }

    public static OfferList instance(){
        if(offerList == null){
            return (offerList = new OfferList());
        }
        else
          return offerList;
    }

    public boolean addOffers(Offer offer){
        offers.add(offer);
        return true;
    }

    public Iterator getOfferList(){
        return offers.iterator();
    }

    

    public String toString(){
        return offers.toString();
    }
}