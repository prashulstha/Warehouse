import java.util.*;
import java.lang.*;
import java.io.*;

public class WaitListedOrderList extends ParentList {

	private static final long serialVersionUID = 1L;
	private static WaitListedOrderList wloList;

	public static WaitListedOrderList instance() {
		if (wloList == null)
			return (wloList = new WaitListedOrderList());
		else
			return wloList;
	}
}