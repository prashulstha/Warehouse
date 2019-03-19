import java.util.*;
import java.lang.*;
import java.io.*;

public class OfferList extends ParentList {

    private static OfferList offerList;

    private OfferList() {

    }

    public static OfferList instance() {
        if (offerList == null)
            return (offerList = new OfferList());
        else
            return offerList;
    }
}