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

Methods in inheritance

all methods in java are virtual ==> dynamic bindings

public class Product {
	public String getName() {
		return "Prd";
	}
	public double getPrice() {
		return 100;
	}
}


public class Mobile extends Product {
	// override
	public double getPrice() {
		return 999;
	}

	public String getConnectivity() {
		return "5G";
	}
}


Mobile m = new Mobile();
m.getPrice(); // 999;
m.getName(); // Prd


Product p1 = new Mobile(); // upcasting
p1.getName(); // Prd
p1.getPrice(); // 999
p1.getConnectivty(); // Compilation ERROR

====================================================



		Product[] products = new Product[500]; // Array of 5 Pointers
		products[0] = new Tv(133, "Sony Bravia", 135000.00, "LED"); // upcasting
		products[1] = new Mobile(453, "MotoG", 12999.00, "4G");
		products[2] = new MicroWave(..)
		products[3] = new Fridge(...)
		products[4] = new DishWasher(..);


Mobile[] mobiles = ...

for(Mobile m : mobiles) {
	///
}

Tv[] tvs = ...

for(Tv t: tvs) {
	/..
}

MW mws = ...

for(MW m : mws) {
	// ...
}

===


Product p = new Mobile();

(p instanceof Product) ==> true

(p instanceof Mobile) ==> true

(p instanceof Object) ==> true

(p instanceof Tv) ==> false

----

(p.getClass() === Product.class) ==> false
(p.getClass() === Mobile.class) ==>true

===============================

If we know method name in advance:
context.method();
Example:
acc.deposit();

method.invoke(context);


====

Product p = new Tv(133, "Sony Bravia", 135000.00, "LED");
Method[] methods = p.getClass().getMethods();

// p.getClass() ===> Tv.class

* getMethods(); ==> 
	String getScreenType()
	void setScreenType(String screenType) {
	public int getId() {
	public void setId(int id) {
	public String getName() {
	public void setName(String name) {
	+
	methods of Object

====================================================

Day 1 Recap:
OOP, JRE, JVM
Metaspace, Stack, Heap [Headers ==> class, hashcode, lock, ...; state of the object ==> instance variables]

static variables ==> Metaspace
local variables ==> Stack

constructor ==> to initailze the state of object

Generalization and Specialization relationship ==> Inheritance ==> keyword "extends"

Java Object is the root class for every class
Java doesn't support multiple-inheritance

Java all instance methods are virtual by default ==> dynamic binding happens if we override a method

static methods ==> static binding

OCP ==> upcasting
Reflection API

	methodPtr.invoke(context, arguments);


without reflection API:
	context.methodA(arguments);
	context.methodB(arguments);

======================

Day 2

"abstract" keyword

1) for class
"Product" is just for generalization purpose; in real world "Product" by itself doesn;t exist;
we are not supposed to create instance of product
public abstract class Product {
}

new Product(); // error an't instantiate abstract class


2) for method

public abstract boolean isExpensive();

like pure virtual functions


* abstract class need not have abstract methods
* if one of the method is declared abstract; then class also has to be declared abstract
* inherited class should implement abstract methods of base class else declare that class also as "abstract"

=========================


* Realization Relationship

An object will realize the contract/ rules specified by other object/component in order to communicate

achevied using interface in java

interface interfaceName {
	abstract methods
	constants
	// no instance variable
}


Example:
* entities ==> ER 
* interfaces

enteties and interfaces are shared as common module to all team members working on various modules

interface EmployeeDao {
	void addEmployee(Employee e);
	Employee getEmployee(int id);
}


Why Program to interface?
1) DESIGN 
2) IMPLEMETNTION
3) TESTING in ISOLATION
4) INTEGRATION
5) LOOSE COUPLING
6) OCP


MobileDao mobileDao = new MobileDaoMySqlImpl();

Advantages:
1) Loose coupling; easliy we can swithc to different implmentation

Disadvantages:
Swithcing between strategies involves changing different client code [ Web / Console / ...]
Exposing type of storage/usage to client 


Solution : use Factory Pattern


==============

Factory Method:
static Plants[] getPlants(String season) {
	case SUMMER: 
		///
	case WINTER:
		...
	case RAINY:
		...
	case SPRING:
		...
}




client 

Plants[] plants = getPlants("SUMMER");

Plants[] plants = getPlants("RAINY");

========================================================================

Generics

public class Rectangle {
	int width;
	int breadth;
	//
}


Rectangle r1 = new Retangle(3,4);




public class DRectangle {
	double width;
	double breadth;
	//
}

DRectangle r2 = new DRectnagle(1.2, 3.4);

Solution:

public class Rectangle <T> {   ==> public class Rectangle {
	T width; 					==> Object width;
	T breadth; 					==> Object breadth;
} 								}




Rectangle<Integer> r1 = new Retangle<Integer>(3,4);
Rectangle<Double> r2 = new Retangle<Double>(1.3,4.4);
Rectangle<String> r3 = new Retangle<String>("a","b");


Generics can be used only for Object type and not for primitive type

Integer is a typewrapper for int
Double is a typewrapper for double

int x = 10;

Integer iX = x ; // boxing

int y = iX; // unboxing

y++;
y += 20;





public class Rectangle <T extends Number> {   ==> public class Rectangle {
	T width; 									==> Number width;
	T breadth; 									==> Number breadth;
} 								


Rectangle<Integer> r1 = new Retangle<Integer>(3,4); //valid
Rectangle<Double> r2 = new Retangle<Double>(1.3,4.4); // valid
Rectangle<String> r3 = new Retangle<String>("a","b"); // error


======================================================================

interface for OCP

public interface Comparable<T> {
	 public int compareTo(T o);
}

public class Product implements Comparable <Product> {
	...
	 public int compareTo(Product other) {
	 	// logic to compare "this" with "other" and return difference
	 }	
}


public class Rectangle implements Comparable<Rectangle> {
	///
	 public int compareTo(Rectangle other) {
	 	// logic to compare "this" area with "other" area

	 }
}


r1.compareTo(r2); // this ==> r1 ;  other ==> r2


===============

Task:

package com.adobe.prj.entity;

public class Book ....

	String title;
	double price;


SortClient.java

Book[] books = ....
books[0] =
books[1] =
books[2] =
books[3] =


Utility.sort(books); // don't change sort()

// print books books should be printed sorted based on title


=================================

"Brad".compareTo("Angelina")
 ==> 1

=================================


interface Flyable {
	fly();
}

interface Dance {
	dance();
}


interface Swim {
	swim();
}

// actor can dance
class Actor implements Dance {
	//
	dance() {

	}
}
// hero IS A Actor

class Hero extends Actor implements Flyable , Swim {
	fly() {..}
	swim() {..}
}

Flyable f = new Flyable(); // can't instantiate interface

Flyable f = new Hero(); // VALID

f.fly(); 

f.swim(); // ERROR, hero can swim() but Flyable can send only fly()

Swim s = (Swim) f;
s.swim(); // Hero is swimming


=========================

interface Flyable {
	void fly();
}

Flyable f = new Flyable(); // error ==> can't instantiate interface


class Bird implements Flyable {
	//state
	// behaviour

	public void fly() {
		///
	}
}

Bird b1 = new Bird("Eagle");
Bird b2 = new Bird("Crow");



class AeroPlane implements Flyable {
	// state
	// behaviour
	public void fly() {

	}
}

class Dummy implements Flyable {
	public void fly() {
		System.out.println("jump from 10th floor!!!");
	}
}

class Dummy2 implements Flyable {
	public void fly() {
		System.out.println("jump from 15th floor!!!");
	}
}

Flyable f = new Dummy();

// Anonymous class
Flyable f = new Flyable() {
	public void fly() {
		System.out.println("jump from 10th floor!!!");
	}
}

f.fly();

============================


interfaces with only one method to implement can be marked as @FunctionalInterface
Built-in @FunctionalInterface

1) 
@FunctionalInterface
public interface Predicate<T> {
  boolean test(T t);
}

2) 
@FunctionalInterface
public interface Consumer<T> {
	void accept(T t);
}

3) 

@FunctionalInterface
public interface Function<T, R> {
	R apply(T t);
}

4)
@FunctionalInterface
public interface BiFunction<T, U, R> {
	R apply(T t, U u);
}

5) 
@FunctionalInterface
public interface Runnable {
	 public abstract void run();
}


filter(data, new Predicate() {
	@Override
	public boolean test(Object e) {
		e -> e % 2 == 0
	}
});

Using Lambda
filter(data, e -> e % 2 == 0);

========================================


Data Containers ==> Java Collection Framework provides lots of data containers

* Array is a data container
--> size is fixed; can't grow / shrink
--> Adding / removing from arbitrary position is difficult

java.util package

Comparable ==> comparision based on logic written in the object ==> Natural Comparsion ==> Primary Key most of the time

	String ==> Lexical
	Employee, Product ==> based on id

Comparator ==> comarision based on client logic for various fields of object


Product
	id
	name
	price
	category

	compareTo() {
			based on id
	}

========

Client 1 needs to sort by price?
	logic to compare by price

client 2 by name
	logic to compare by name


LengthComparator.java
class LengthComparator implements Comparator {
	public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
}

Arrays.sort(names, new LengthComparator());


class PriceComparot implements Comparator {
	 
}

===

Arrays.sort(names, (o1, o2) -> o1.length() - o2.length());
	
sort(elems) {
	for i = 0 ; i< elems.length
	 for j = j + 1;  j< elems.length
	 	if(elem[i].compareTo(elem[j])> 0) {
	 		swap
	 	}
}

sort(elems, comparator) {
	for i = 0 ; i< elems.length
	 for j = j + 1;  j< elems.length
		if(comparator.compare(elem[i], elem[j])) {
			swap
		}
}

===============

Using lambda expression sort products by price

JCF:

List type of data container:
* can grow or shrink
* ordered
* supports duplicate elements
* supports index based operation
	add(obj, 5);
	remove(10);
	get(2);
* re-order ==> sort(), shuffle(), reverse()

implementations of List interface:
1) Vector (legacy)
2) ArrayList
3) LinkedList


ArrayList list = new ArrayList();
list.add(...)

Program to interface:
List list = new ArrayList();

list.add("a");
list.add(12);
list.add(new Product());

above code is not Type-Safe

if(list.get(i) instanceof Product) {
	Product p = list.get(1);
}

--

Prefer Generic collections

List<String> names = new ArrayList<String>();

	names.add("a"); // ok
	names.add(12); // complication error


=============

 Stream
 A stream is a sequence of data; on which we can be pipeline functionalities to produce the desired result.

HOF ==> High Order functions 
==> functions which accept other function as argument
==> function return function



* forEach ==> perform action on each element
* filter ==> subset
* map ==> transform data
* reduce ==> sum(), avg(), count() ==> aggregate of data
* collect
* limit 
* skip
* flatMap 


--
terminal functions:
forEach, reduce, collect

intermediate functions:
filter, map, limit, skip, flatMap


Data flows thro stream only if any terminal function is connected


// give me the names of mobiles
List<String> = products.stream()....

	List<String> ==> iPhone, OnePlus 6

================

learn 
* flatMap()
* read about HashSet
* Different comments [ single , multiline, javadoc]

===========================

Day 2:
	Comparable and Comparator ==> both are for comparision to sort(), max(), min()

	Comparable logic is part of class / object

	public class String implments Comprable<String> {

		int compareTo(String other) { NaturalComparision logic }
	}

	public class Product implments Comparable<Product> {
		int compareTo(Product other) { based on id}	
	}


	client:
		Product [] ....

		Arrays.sort()

		List<Product> products

		Collections.sort(products); // uses logic written within Product class


		// client needs other way of comparison other than based on ID
		Collections.sort(products, new Comparator(..) { ...})
		Collections.sort(products, (p1, p2) -> p1.getName().compareTo(p2.getName())); // compare based on name
		Collections.sort(products, Double.compare(p1.getPrice(), p2.getPrice()); //compare based on price

List<Product> products = new LinkedList<>();


Day 3:

Object equality: equals() vs == 


Rectangle r1 = new Rectangle(4,5);

Rectangle r2 = new Rectangle(4,5);

Rectangle r3 = new Rectangle(2,7);

Rectangle ref = r1; // reference

if(ref == r1) // true

if(r1 == r2) // false


if(r1.equals(r2)) // should evaluate to true

============


HashCode: Numerical value of Object

* 2 similar objects should have same hashcode

* Possiblity: 2 objects which are different can also have same hashcode

public class Rectangle {


	public int hashCode() {
		return w * b;
	}
}


Rectangle r1 = new Rectangle(4,5); ==> 20
Rectangle r1 = new Rectangle(5,4); ==> 20
Rectangle r1 = new Rectangle(10,2);
Rectangle r1 = new Rectangle(20,1);
Rectangle r1 = new Rectangle(2,10);



	public int hashCode() {
		return 2 pow 1 + w *  2 pow 2 + b;
	}
===

HashSet and HashMap  / Hashtable uses hashCode() and equals() to identify duplicates and placing data in container


Set<Product> products = new HashSetProduct>();
		products.add(new Product(645, "Hp Laptop", 135000.00, "computer"));
		products.add(new Product(224, "iPhone", 98000.00, "mobile"));
		products.add(new Product(834, "Logitech Mouse", 600.00, "computer"));
		products.add(new Product(5, "Sony Bravia", 125000.00, "tv"));
		products.add(new Product(912, "One Plus", 32000.00, "mobile"));
		products.add(new Product(88, "HP Printer", 19000.00, "computer"));
		products.add(new Product(834, "Logitech Mouse", 600.00, "computer")); // not added ==> duplicate elements

===============


Map ==> key / value pair

* Dictionary [ key ==> word; value ==> meaning]
* Registry

key ==> unique
value ==> can be duplicate

===

Set is a unique collection
not ordered
can't reorder ==> sort(), shuffle(), reverse() are not supported


========================================

Maven / Gradle / Ivy / Builder
*	Maven is a build automation tool used primarily for Java projects.
==> process of clean, build , test, deploy

==> Dependency managment ==> 3rd party libraries ==> smallest project may have 30+ dependecies [jar]

Project Object Model
pom.xml

<dependecies>
	<dependency>
    	<groupId>mysql</groupId>
    	<artifactId>mysql-connector-java</artifactId>
    	<version>8.0.30</version>
	</dependency>
	<dependency>
    	<groupId>org.springframework</groupId>
    	<artifactId>spring-core</artifactId>
    	<version>5.3.22</version>
	</dependency>
</dependecies>


install Docker Desktop

Docker is a set of platform as a service products that use OS-level virtualization to deliver software in packages called containers. 

image ==> download

docker pull mysql

Container ==> 

docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql

mysql ==> image
local-mysql ==> container

port 3306

================

once docker container is running

* access docker container

$ docker exec -it local-mysql bash
root@a89ad477d23e:/# mysql -u "root" -p
Enter Password: Welcome123

mysql> create database adobe_java;
mysql> use adobe_java;

================================================


groupID ==> reverse domain + projectname ==> com.adobe
artificatID ==> database
version => 1.0.0

Any changes to "pom.xml"

Right click Project ==> Maven ==> update project ==> Force Update ==> "OK button"

==========================

JDBC ==> Java Database Connectivity ==> to connect to RDBMS

==> JDBC is a set of interfaces
==> implementation classes are provided by database vendors [ Oracle / MySQL / Postgress]
	String of Java ==> VARCHAR2 in oracle
	String of Java ==> VARCHAR in MySQL
	String of Java ==> TEXT in SQL-SERVER

	<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.30</version>
		</dependency>


Steps to connect to database:

1) Load driver classes provided by database vendors

	Class.forName("driver class")

	Class.forName("com.mysql.cj.jdbc.Driver");
	Class.forName("oracle.jdbc.Driver");

2) Establish database connection
	Connection is interface provided by jdbc

	Connection con = DriverManager.getConnection(URL, USER, PWD);	

	getConnection() is a factory method creates OracleConnection / MySQLConnection ... based on URL passed


	Example:

	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adobe_java", "root", "Welcome123");	

  
	Connection con = DriverManager.getConnection("jdbc:oracle:@localhost:1521/adobe_java", "root", "Welcome123");	

https://sqlzoo.net/

3) SEND SQL statements
	3 interfaces are present to send SQL
	a) Statement
		id SQL is fixed ==> same sql for all requests
		"select * from products"

		https://owasp.org/Top10/A03_2021-Injection/

	b) PreparedStatement
		if SQL takes IN parameter 

		"select * from products where id = ?"

		"insert into users values (?,?,?)"


	c) CallableStatement
		==> to invoke stored procedures of database

	methods:
	a) int executeUpdate(SQL) ==> INSERT, DELETE and UPDATE SQL
	b) ResultSet executeQuery(SQL) ==> SELECT

4) Close connection


Avoid:
"select * from products where id = " + variable ==> SQL Hijacking

=======================================================================================

Exception Handling

* Exception ==> abnormal condition in application ==> occurs @ runtime ==> in java it is represented as object
--> What went wrong?
--> Why?
--> Where?

a) Unchecked type of exceptions
	compiler doesn't force developer to handle with try-catch syntax; expected to handle with conditional statement


	int x = 10;
	int y = 0;
	if(y != 0) {
		int res = x / y; ==> ArithmeticException ==> /0 
    }

    ---

    addProduct(null);

    addProduct(Product p) {
    	if(p != null) {
    		p.getName(); // can lead to NullPointerException
       }
    }

    Unchecked exceptions are a result of code running within JRE

 b) Checked type of exception
 	
 	Compiler forces developer to handle exception using try - catch syntax


 		try {
 			Class.forName("com.mysql.cj.jdbc.Driver");
 		} catch(ClassNotFoundException ex) {
 			// message or handling code
 		}


 		try {
 			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adobe_java", "root", "Welcome123");	
 		} catch(SQLException ex) {
 			//
 		}

 	These exceptions are a result of applicaitons outside of JRE

====================================================================

interface UserDao {
	void register(User u) throws SQLException;
}

class UserDaoJdbcImpl implements UserDao {
	public void register(User u) throws PersistenceException{
		try {

			} catch(SQLException ex) {
				throw new PersistenceException("user with id already exists")
			}
	}
}


class UserDaoMongoDbImpl implements UserDao {
	public void register(User u) throws PersistenceException{
		try {

			} catch(MongoException ex) {
				throw new PersistenceException("user with id already exists")
			}
	}
}



=========

$ docker exec -it local-mysql bash
root@a89ad477d23e:/# mysql -u "root" -p
Enter Password: Welcome123

mysql> create database adobe_java;
mysql> use adobe_java;


mysql> create table products (id int PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), price double, quantity int);

mysql> insert into products values (0, 'LG AC', 45000.00, 100);
mysql> insert into products values (0, 'Samsung Fold', 165000.00, 100);
mysql> select * from products;


======================================================

JEE ==> Web application Development

ServletTechnology ==> Java Server side code runs within ServletEngine / ServletContainer / WebContainer


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

}

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

}


ServletEngine / ServletContainer / WebContainer manages the life cycle of Servlet


HTTP Methods
* GET ==> address, url
* POST ==> send payload to server 
* PUT
* DELETE
* PATCH

GET http://localhost:8080/products


@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		..
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		..
	}
}



older apis:
public class RegisterServlet extends HttpServlet {

}

web.xml ==> deployment descriptor

<servlet>
	<servlet-name>A</servlet-name>
	<servlet-class>pkg.RegisterServlet</servlet-class>
</servlet>

<servlet-mapping>
	<servlet-name>A</servlet-name>
	<url-pattern>/register</url-pattern>
</servlet-mapping>

================================


Project ==> Right click ==> Run As ==> Maven build
Goals: jetty:run 

Browser:
http://localhost:8080/


===

Project ==> Right click ==> Run As ==> Maven build
Goals: package

war file "C:\Trainings WS\Adobe\July2022\JAVA\database\target\database-1.0.0.war"
create should be taken to deployment server

=============

https://www.baeldung.com/lombok-ide

Day 3 Recap:

JDBC ==> Integration library for Java to connect to RDBMS
Connection, Statement, PreparedStatement and ResultSet 

Exceptions ==> User Defined Exception class ==> try - catch - finally

Servlet engine / Web container
Servlet ==> Request , Response programming model

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	doGet(HttpServletRequest req, HttpServletResponse res) {}
	doPost(HttpServletRequest req, HttpServletResponse res) {}
	doPut(HttpServletRequest req, HttpServletResponse res) {}
	doDelete(HttpServletRequest req, HttpServletResponse res) {}
}

Run Jetty on different port

Goals:jetty:run -Djetty.port=9999

------------------------------

Day 4

Spring Framework

==> provides lightweight container for building enterprise application
==> Core Spring container provides life-cycle management of beans [objects managed by spring ] and Dependency injection

1) XML as metadata

interface ProductDao { insert();}
public class ProductDaoJdbcImpl implements ProductDao { insert() {}}
public class ProductDaoMonogoImpl implements ProductDao { insert() { }}

public class OrderService {
	private ProductDao productDao;

	public void setProductDao(ProductDao pdao){
		this.productDao = pdao;
	}

	public void doTask() {
		this.productDao.insert();
	}
}

beans.xml

<beans id="jdbc" class="pkg.ProductDaoJdbcImpl" />
<beans id="mongo" class="pkg.ProductDaoMongoImpl" />

<beans id="service" class="pkg.OrderService">
	<property name="productDao" ref="jdbc" />
</beans>


========

public class OrderService {
	private ProductDao firstDao;
	private ProductDao secondDao;

	public void setFirst(ProductDao pdao){
		this.firstDao = pdao;
	}

	public void setSecond(ProductDao pdao){
		this.secondDao = pdao;
	}
	public void doTask() {
		this.productDao.insert();
	}
}


<beans id="service" class="pkg.OrderService">
	<property name="first" ref="jdbc" />
	<property name="second" ref="mongo" />
</beans>

==================================================================

2) Annotation as metadata

Spring creates objects of classes which has one of these annotations at class-level
1) Component
2) Repository
3) Service
4) Configuration
5) Controller
6) RestControlller


interface ProductDao { insert();}

@Repository
public class ProductDaoJdbcImpl implements ProductDao { insert() {}}

id created will be "productDaoJdbcImpl"


@Repository("jdbc")
public class ProductDaoJdbcImpl implements ProductDao { insert() {}}
	
id created will be "jdbc"

@Service
public class OrderService {
	@Autowired
	private ProductDao firstDao;

	public void doTask() {
		this.productDao.insert();
	}
}


Bytecode instrumentation is a technique for changing the code of compiled Java applications

@Autowired
private ProductDao productDao;


can get converted into:
a) private ProductDao productDao = new ProductDaoJdbcImpl();
or
b) private ProductDao productDao = ProductDaoFactory.getProductDao();

Byte code instrumentation libraries:
1) ByteBuddy
2) JavaAssist
3) CGLib

=============

Eclipse ==> Help ==> Eclipse Marketplace ==> Search for STS

Spring Tools 4 ==> 4.15.1.RELEASE

if problem ==> Spring Tools 3

Restart eclipse

Check

New ==> Spring Starter Project

=============================================

https://www.baeldung.com/lombok-ide

java -jar lombok-1.18.4.jar

=======================


Spring Framework 5.x

a) Create Spring container with XML as metadata
ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");


b) create spring container with Annotation as metadata

ApplicationContext ctx = new AnnotationConfigApplicationContext();
ctx.scan("com.adobe"); // find classes with annotations in this package and sub-pacakges


---------


Spring Boot is a framework on top of Spring Framework provides lots of configurations out-of-the box
* for RDMBS ==> database connection pool is configured out-of-the box
* for web based application ==> tomcat container is configured out-of-box

<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
</dependency>


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}


SpringApplication.run() ==> starts Spring Container uses Annotation "scans for packges" in "com.example.demo" and sub-packges

@SpringBootApplication contains:
1) @ComponentScan ==> scans for classes in "com.example.demo" and sub-packges and creates objects
2) @EnableAutoConfiguration ==> scans libraries and creates objects 


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		
		SampleService service =  ctx.getBean("sampleService", SampleService.class);
		
		service.doTask();
		
	}

}

=====

1) 

@Service
public class SampleService {
	
	@Autowired
	private EmployeeDao empDao;

2) 

@Service
public class SampleService {

	private EmployeeDao empDao;

	@Autowired
	public void setDependencies(EmployeeDao dao) {
			// validation
		this.empDao = dao;
	}


============

* Spring instantiates beans by invoking default constructor only.
* 3rd party classes to be used along with spring framework


Solution ==> Factory pattern

===========================================================

ORM ==> Object Relational Mapping ==> framework to simpilify CRUD operations using JDBC

Java Application ==> ORM [Hibernate / TopLink / KODO / OpenJPA / Eclipse Link ] ==> JDBC ==> database

JPA is a specification for ORM ==> helps easily switch between different ORM [ only interfaces]

Java applicaiton == JPA ==> ORM ==> JDBC ==> database

===

New Spring starter Project
Dependencies ==> MySQL , JPA


spring.jpa.hibernate.ddl-auto=update

* if database table doesn't exist for the mapping ==> create table
* if table already exist ==> map to existing table ==> if required alter table

---

spring.jpa.hibernate.ddl-auto=create

* if database table doesn't exist for the mapping ==> create table
* if table already exist ==> drop table and re-create ==> good for testing

spring.jpa.hibernate.ddl-auto=verify
* if table already exist ==> map to existing table 
* if not exists ==> throw error


@Table(name="employees")
public class Employee {}


========

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

em.save(p); 
em.find(Product.class, 4); 

in console ==> insert into 
	products 
		values (....)

=============

HikariDataSource  => DB connection pool

Spring Data JPA ==> simplifies using ORM

public interface ProductDao extends JpaRepository<Product, Integer> {
}

Spring DATA JPA will generate @Repository class for this interface with pre-defined methods for CRUD operations

================

Order Application ==> Association between entites

Customer has many orders [ one - to - many]
May orders can be placed by a customer [many - to -one]

Order can have many items [ one - to - many]
many items can be a part of ORder [ many-to -one]

Product can be part of many orderitems [ one - to - many]
many items can referer to a product [ many-to-one]

==========================


Order has 4 items;

save(order);
save(item1);
save(item2);
save(item3);
save(item4);

--

delete(order);
delete(item1);
delete(item2);
delete(item3);
delete(item4);


With Cascade

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="order_fk")
	private List<Item> items = new ArrayList<>();

save(order); ==> saves all items also
delete(order); ==> delete all items also

No need for ItemDao.java

===================================

placing an order client passes
	{
		"customer" : "banu@gmail.com",
		"items" : [
			{"product": {"id" : 3}, qty : 2},
			{"product": {"id" : 1}, qty : 1}
		]
	}


form the data sent program has to compute "amount" of "item"; order total


=======================

New Project: ==> new database

Entites:
1) Customer
2) Vehicle
3) Driver
4) Rental


Write codes to add data into customer, vehicle and Driver  tables


Use case 1: 
Customer rents a vehicle

==============



Day 4:
JPA is a specification to use ORM (Hibernate)

Object Relational Mapping ==> Java Class <=== Mapped to ===> database table ==> @Table
	Java class fields <==== mapped to ===> database columns ==> by default all class fields are mapped to columns with same same
		In case if db columns are different from java field ==> @Column

	@Transient on top of field ==> this java field will not be mapped to DB column

	class Customer {
		firstName;
		lastName;

		@Transient
		name; ==> firstName + lastName; ==> no column called "name" in db
	}

* Primary Key is a must ==> mapped using @Id
* composite Primary Key ==> we are not covering in this training

@GeneratedValue(strategy=IDENTITY) ==> PK is auto_increment

-----------------------------

JpaRepository ==> any interface extended from JpaRepository ==> methods for CRUD operations are made available
out-of-box ==> Spring Data JPA will generated classes based on the interface ==> no need for @Repository classes

-----------------------

Mapping between entites ==> ER

* one-to-many
* many-to-one
* many-to-many
* one-to-one


@OneToMany
@JoinColumn(--- FK --)

@ManyToOne()
@JoinColumn( ---FK---)


@JoinColumn if used with @OneToMany will introdnuce FK in child class ==> other class ==> to which field  annotation is placed


class Project {

	@OneToMany
	@JoinColumn(name="project_fk")
	List<Employee> employess = ...
}

here "projecT_fk" will be in "employess" table

---

@JoinColumn if used with @ManyToOne will introduce FK in owing entity


class Project {

	@ManyToOne()
	@JoinColumn(name="client_fk")
	private Client client;
}


client_fk will be made available in "projects" table

===================


Cascade ===> ALL, PERSIST, DELETE


class Order 
@OneToMany(cascade=CascadeType.ALL)
List<Item> items = ...

	saving order saves items also
	deleting order will delete items also

	==> No need for ItemDao; complete management by OrderDao

================================================================================



@Component is generally placed on classes which are utilitity class ==> helper classes

@Repository is placed on classes which do CRUD operation ==> connect to DB

@Service ==> for service classes

=================================================

 @Id
 @GeneratedValue(strategy=SEQUENCE, generator="order_id")
 String orderId;


 MySQL:

 DELIMITER $$ 
 CREATE PROCEDURE order_id() 
 BEGIN     START TRANSACTION;     
 	UPDATE sequence SET id=LAST_INSERT_ID(id + 1);     
 	SELECT LAST_INSERT_ID() AS number;     
 COMMIT; 
 END $$ DELIMITER ;

 ======================

 in Hibernate ORM we use em.merge(object) ==> for update

 JPA doesn't have merge() for update;

 Solution is:

 @Transactional
 public void method() {
 	pull the entity from backend
 	set new values; ==> dirty check will trigger update
 }

 ====================================


@Service
public class RentalService {

	// return vehicle
	@Transactional
	public void rentalReturn(int rentalId) {
		Rental r = rentalDao.findById(rentalId).get();
		r.setReturnDate(new Date();
	}
}

=============================================================================


Day 5:

JpaRepository provides basic CRUD opertions

* how to add custom methods for JpaRepositry

public interface ProductDao extends JpaRepository<Product, Integer>{

}

above interface provided methods for save(), findById(), findAll(), delete(), ..

* get products by existing field

public interface ProductDao extends JpaRepository<Product, Integer>{
	List<Product> findByName(String name); // select * from products where name = ?
	List<Product> findByQuantity(int qty); // select * from products where quantity = ?
	List<Product> findByQuantityAndPrice(int qty,  double price); 
	// select * from products where quantity = ? and price = ?
}

* custom queries

public interface ProductDao extends JpaRepository<Product, Integer>{

	@Query()
	List<Product> fetchByRange(double lower, double higher);
}


public interface RentalDao extends JpaRepository<Rental, Integer> {

	@Query(value = "select * rentals where vehicle_fk = :regno and rental_date is NULL", nativeQuery=true)
	List<Rental> getByRegNo(@Param("regNo") String regNo);
}


================


SQL vs JP-QL
 

 LazyInitializationException

 by default OneToMany mapping is Lazy Fetch

 by default ManyToOne is EAGER Fetch

 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
 @JoinColumn(name="order_fk")
 private List<Item> items = new ArrayList<>();


============================================

Check:
1) ProductDao.java ==> added custom methods
2) OrderService ==> calling new ProductDao.java methods
3) Order.java ==> fetch EAGER and LAZY ==> try both
 
 ================

Bi-Directional relationship

@Entity
@Table(name="orders")
public class Order {
	 
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(mappedBy="order")
	private List<Item> items = new ArrayList<>();

===



@Entity
@Table(name="items")
public class Item {
 	...
	@ManyToOne
	@JoinColumn(name="order_fk")
	private Order order;
	 

==

public interface ItemDao extends JpaRepository<Item, Integer> {

}

Item item = itemDao.findById(100).get();

Order o = item.getOrder(); // complete order
o.getCustomer(); // customer info can be get

===

n + 1 problem

fetching all orders
assume 10 orders exist

select * from items where order_id = 1;
select * from items where order_id = 2;
select * from items where order_id = 3;
select * from items where order_id = 4;
select * from items where order_id = 5;
select * from items where order_id = 6;
select * from items where order_id = 7;
select * from items where order_id = 8;
select * from items where order_id = 9;
select * from items where order_id = 10;

To avoid write Joins on your own

========================
JPQL
@Query("select new com.adobe.prj.entity.ReportDTO(o.orderDate, o.total, c.firstName, c.lastName) from Order o inner join o.customer c")
	List<ReportDTO> getReport();

SQL:
@Query(value="select
        order0_.order_date as col_0_0_,
        order0_.total as col_1_0_,
        customer1_.first_name as col_2_0_,
        customer1_.last_name as col_3_0_ 
    from
        orders order0_ 
    inner join
        customers customer1_ 
            on order0_.customer_fk=customer1_.email", nativeQuery=true)
     List<ReportDTO> getReport();

================
public class Product {
	@Column(name="name", unique=true)
	private String name;
}

============================================

RESTful web services

REST ==> REpresentation State Transfer

Resource? info on server

State ==> value of the resource at a given point of time

Representaton ==> state info is given to client in various formats ==> JSON / XML / CSV

===

GET product whose id = 3

 3 | iPad           |  35000 |      498

XML: 
 <product id="3">
 	<name>iPad</name>
 	<price>35000</price>
 	<quantity>498</quantity>
 </product>

JavaScript Object Notation:
 {
 	id: 3,
 	name: "iPad"
 	price : 35000
 }

==============================================

HTTP headers

Accept: application/json
content-type: application/json


Accept: text/xml
content-type: text/xml

Accept ==> server should send json / xml represetntation
content-type ==> what payload client is sending to server


Each Resource should be identified by plural nouns "products", "customers", "orders"

Use HTTP Methods for verbs "GET" , "POST" , "PUT" , "DELETE"

1) 
GET
http://localhost:8080/api/products

get all products in XML or JSON based on "accept" header


2) Use Query parameters for sub-set ?

GET
http://localhost:8080/api/products?category=mobile
http://localhost:8080/api/products?page=1&size=20 

get sub-set of resource


3)  use path-parameter for fetch based on PK /
GET
http://localhost:8080/api/products/4

get one product whose id is "4"

or to get child data

GET
http://localhost:8080/api/customers/a@adobe.com/orders

get all orders of "a@adobe.com" customer

---

4) 
based on content-type header client sends data to be added to resource
POST
http://localhost:8080/api/products

payload contains data

5) 
PUT
http://localhost:8080/api/products/4

payload contains new data for product with id "4" to update

5) 
DELETE
http://localhost:8080/api/products/4

===================================================


@RestController
@RequestMapping("/api/products")
public class ProductController {

	@GetMapping()
	m1() {}

	@PostMapping()
	m2() {}
}



@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@GetMapping()
	m1() {}

	@PostMapping()
	m2() {}
}

==

By adding
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
</dependency>

we get:
1) Tomcat embedded web server 
2) Spring boot provided DispatcherServlet is provided to hanndle all HTTP request [ @WebServlet("*")]

3) HandlerMapping to map URL to @RestController
4) HttpMessageHandlers/ ContentNegotiationHandler to handle Java <---> JSON is provided

===========

http://localhost:8080/api/products

====================

Try:

GET

http://localhost:8080/api/customers




