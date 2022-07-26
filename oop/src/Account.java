
public class Account {
	private double balance; // instance variable
	private static int count; // class variable
	
	// default constructor
	public Account() {
		count++;
	}
	
	// constructor parametrized
	public Account(double amt) {
			this.balance = amt;
			count++;	
	}
	// instance method
	public void deposit(double amt) {
		this.balance += amt;
	}
	
	// instance method
	public double getBalance() {
		return this.balance;
	}
	
	// class method
	public static int getCount() {
		return count;
	}
}
