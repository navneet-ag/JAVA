
public class AccountExample {

	public static void main(String[] args) {
		System.out.println(Account.getCount()); // 0
		Account a1 = new Account(500); // parameterized
		
		System.out.println(a1.getCount()); // 1
		
		Account a2 = new Account(); // default
		
		System.out.println(Account.getCount()); // 1
		
		a1.deposit(5000); // deposit(a1, 5000);
		a2.deposit(89000);
		
		System.out.println("Account a1 :");
		System.out.println("Balance :" + a1.getBalance());
		
		System.out.println("Account a2 :");
		System.out.println("Balance :" + a2.getBalance());
		
		Account rahulAcc = new Account();
		System.out.println(Account.getCount()); // 3
	}

}
