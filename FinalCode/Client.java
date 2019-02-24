import java.io.Serializable;

public class Client implements Serializable {

	private int id;


	private float balance;
	private String name;

	public Client(int p_id, float p_balance, String p_name) {
		id = p_id;
		balance = p_balance;
		name = p_name;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public float getBalance() {
		return balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public String toString() {
		String string;
		string = "Client Name: " + name + " Client Id: " + id + " Client balance: " + balance;
		return string;
	}
}
