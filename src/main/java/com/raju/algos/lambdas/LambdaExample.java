package com.raju.algos.lambdas;

import java.util.function.Consumer;

public class LambdaExample {

	public static void main(String[] args) {
		
		FuntionalInterfaceWithoutParam fintfwp = () -> System.out.println("Hola!!!");
		fintfwp.print();
		
		FunctionalInterface fintf1 = message -> System.out.println("fintf1 "+ message); 
		fintf1.print("Hola!");
		
		FunctionalInterfaceWithMultipleParams fintf2 = (one, two) -> System.out.println(one + two);
		fintf2.print("Hello ", 5);
		
		// Java 8 inbuilt functional interface
		Consumer<String> consumer = message -> System.out.println(message);
		consumer.accept("Hare Rama!");
	}
	
	interface FunctionalInterface {
		void print(String message);
	}
	
	interface FuntionalInterfaceWithoutParam {
		void print();
	}
	
	interface FunctionalInterfaceWithMultipleParams {
		void print(String one, int two);
	}
	
	//Interface with default implementation
	interface DefaultTest {
		default void print(String message) {
			System.out.println("Default Print: " + message);
			System.out.println(isNull(message));
			System.out.print(nullCheck(message));
		}
		
		static boolean isNull(String message) {
			return true;
		}
		
		default boolean nullCheck(String message) {
			return false;
		}
	}
}
