
public class AccountExample {

	public static void main(String[] args) {
		Account a1 = new Account();
		Account a2 = new Account();
		
		a1.deposit(5000);
		a2.deposit(89000);
		
		System.out.println("Account a1 :");
		System.out.println("Balance :" + a1.getBalance());
		
		System.out.println("Account a2 :");
		System.out.println("Balance :" + a2.getBalance());
	}

}
