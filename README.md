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


Resume @ 2:00

 
