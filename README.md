# JAVA

Trainer: Banuprakash C

Full Stack Architect,

Co-founder Lucida Technologies Pvt Ltd.,

Corporate Trainer,

Email: banuprakashc@yahoo.co.in; banu@lucidatechnologies.com

https://www.linkedin.com/in/banu-prakash-50416019/


https://github.com/BanuPrakash/JAVA

===================================



Softwares Required:
1) Java 8+
	https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html

2) Eclipse for JEE  
	https://www.eclipse.org/downloads/packages/release/2020-03/m1/eclipse-ide-enterprise-java-developers

3) MySQL  [ Prefer on Docker]

Install Docker Desktop

Docker steps:

a) docker pull mysql

b) docker run --name local-mysql –p 3306:3306 -e MYSQL_ROOT_PASSWORD=Welcome123 -d mysql

container name given here is "local-mysql"

For Mac:
docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql

docker run -p 3316:3306 -d --name local-mysql2 -e MYSQL_ROOT_PASSWORD=Welcome123 mysql


c) CONNECT TO A MYSQL RUNNING CONTAINER:

$ docker exec -t -i <container_name> /bin/bash

d) Run MySQL client:

bash terminal> mysql -u "root" -p

mysql> exit

======================================================

OOP ==> Object Oriented Programming 

* Real world applications

Object has interface; message thro interface; interface exposes what messages an object receive [abstraction]

SOLID design principles

S ==> Single Responsilibity 

O ==> Open Close Principle
	Closed for a change; open for extension

	sort(data) {
		// code is OCP
	}

	sort(employees)

	sort(products)

	sort(string)

	sort(number)

L ==> Liskov Substitution Principle
	At any point of time we should be able to get the functionalities of generalized compoment with specialized component

I ==> Interface seggregation

D ==> Dependency Injection (Inversion Of Control)

===============================================================================

Java ==> Technology ==> Platform & APIs to execute bytecode

Bytecode is compiled code

Java as programming ==> JDK ==> javac ==> bytecode
Kotlin ==> KDK ==> bytecode

Bytecode


=======================

Employee.java

public class Employee {
	private String name;
	private int age;

	public void setName(String n) {
		this.name = n;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}
}
Compilation:
javac Employee.java ==> Employee.class [bytecode]

Test.java

public class Test {
	public static void main(String[] args) {
		Employee danny = new Employee();
		danny.setName("Danny");

		Employee swetha = new Employee();
		swetha.setName("Swetha");

		System.out.println(swetha.getName() + ", " + swetha.getAge());

	}
}

javac Test.java ==> Test.class

Runtime environment
java Test 

==================================

Constructors

* used to initialize an object

* special methods which has same name as that of class

* can be overloaded [  more than one]

* compiler creates default constructor if no constructors are written

* If we write any parametrized constructor on our own; then we need to write default constructor if required

================

* Need to track how many account instances are created


public static int getCount() {
		// can't access the state of object
		return count;
}

a1.getCount(); ==> Account.getCount(); ==> "this" pointer is not passed to getCount()

================

Local variables ==> stack

Instance variables ==> Heap [ copy per object]

static variables ==> metaspaces along with class data [ one copy per class]

===============================================================


Logically grouping of classes:

1) entity / domain / model classes
	==> they represent business data; long lived data; survive system crush
	==> replica of your data store

	RDBMS Product table with id; name; price columns

	class Product {
		int id;
		String name;
		double price
	}

	Swiggy application:
	entities: Customer; Item; Order; DeliveryPerson; Address

	Uber application:
	entities: Customer, Vehicle, Driver, Trip, Payment, Address

	==> avoid any business logic in these classes;
	==> they contain instance variables; static variables; constructors, getters, setters, equals() 

2) DAO ==> Data Access Object 

	==> CRUD operations on persistent store
	CREATE READ UPDATE DELETE ==> RDBMS (MySQL) / NOSQL (mongoDB) / File system

	public class ProductDao {

		addProduct(Product p) {
			"insert into products values ...." // db.products.insert({})

		}

		Product[] getProducts() {
				"select * from products"; // db.products.find();
		}
	}


	public class AccountDao {
		getBalance(Account a) {
			"select * from accounts where no =" + a.getNo()
		}

		updateAccount(Account a) {
			"update accounts set balance = ... where no = .."
		}
	}
3) Service class
	==> layer on top of DAO and business logic
	==> groups dao calls and provides as one call to client [ Atomic]

	public class BankingService {
		public void transferFunds(Account fromAcc, Account toAcc, double amt) {
			// dao call to check funds in "fromAcc" // accountDao.getBalance(fromAcc)
			// dao call to update "fromAcc"  // accountDao.update(fromAcc);
			// dao call to update "toAcc" // accountDao.update(toAcc);
			// dao call to insert into "transaction" table
			// send SMS
		}
	}
4) Exception class
	==> any abnormal condition in appliaction is represented as Object

5) UI tier
	==> web, standalone command line, android

===

java packages ==> internally folders ==> for logically grouping classes

without packages codes are not reusable

=========================================

Java Tools:
1) IDE ==> Eclipse / InteliJ / NetBeans /..
2) Maven ==> build tool 
3) CheckStyle ==> Static code analysis ==> good naming conventions / white spaces / comments
4) PMD / SpotBugs / FindBugs ==> Coding Stds
	4.1) empty blocks [ conditional / catch]
	4.2) unreachable code
	4.3) Copy & Paste Code ==> Apply DRY

5) Jenkins ==> CI / CD

Sonar ==> checkstyle + SpotBugs


Relationship between objects
1) Generalization and Specialization
2) Realization
3) Association
4) Uses A




Generalization and Specialization relationship in OOP we call it as inheritance

public class Product {}

public class Mobile extends Product {}

public class Tv extends Product {}

Product implicitly extends Object

Object is the root of all classes in Java // single root hierarchy

---

* Java doesn't support multiple inheritance

public class Mobile extends Product, Toy {} // ERROR

===============================


constructors in inheritance:

public class Product {
	public Product() {
		"p1"
	}

	public Product(int id, String name) {
		"p2"
	}
}

public class Mobile extends Product {
	public Mobile() {
		"m1"
	}

	public Mobile(int id, String name, String connectivity) {
		"m2"
	}
}

new Mobile(); // "p1" & "m1" ==> Object() ==> Product() ==> Mobile()

new Mobile(123, "iPhone", "4G"); // "p1" & "m2"

===

make changes:
public Mobile(int id, String name, String connectivity) {
		super(id, name);
		"m2"
}

new Mobile(123, "iPhone", "4G"); // "p2" & "m2"

by default:
public Mobile() {
		super();
		"m1"
	}

public Mobile(int id, String name, String connectivity) {
		super();
		"m2"
}

=================



