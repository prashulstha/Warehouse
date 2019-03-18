import java.util.*;
import java.lang.*;
import java.io.*;

public class ParentList implements Serializable {

	private static final long serialVersionUID = 1L;
	protected LinkedList<Thing> list = new LinkedList<Thing>();

	public boolean add(Thing obj) {
		list.add(obj);
		return true;
	}

	public Iterator<Thing> getList() {
		return list.iterator();
	}

	public String toString() {
		return getList().toString();
	}
}