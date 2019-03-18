import java.util.*;
import java.lang.*;
import java.io.*;

public class TransactionList extends ParentList {

    private static final long serialVersionUID = 1L;
    private static TransactionList trList;

    public static TransactionList instance() {
		if (trList == null) {
			return (trList = new TransactionList());
		} else
			return trList;
    }
}