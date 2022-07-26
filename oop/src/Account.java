
public class Account {
	private double balance; // instance variable
	
	// instance method
	public void deposit(double amt) {
		this.balance += amt;
	}
	
	// instance method
	public double getBalance() {
		return this.balance;
	}
}
