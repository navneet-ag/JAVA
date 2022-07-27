package com.adobe.prj.client;

@FunctionalInterface
interface Computation {
	int compute(int x, int y);
}

 
public class InterfaceExample {
	public static void main(String[] args) {
		Computation c1 = new Computation() {
			@Override
			public int compute(int x, int y) {
				return x + y;
			}
		};
		doTask(c1);
		
		// java 8 Lambda expression ==> interface with only one metod to define
		Computation c2 = (x, y) -> x - y;
		doTask(c2);
	}

	private static void doTask(Computation c1) {
		System.out.println(c1.compute(4, 5));
	}

}
