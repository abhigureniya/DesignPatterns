package com.abhi.pattern.singleton;

//import java.awt.Desktop;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BreakingSingletonByReflection {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
		enumSingleton.doSomething();
		//Desktop d = Desktop.getDesktop();
		//Runtime r = Runtime.getRuntime();
		ThreadSafeSingleton instanceOne = ThreadSafeSingleton.getInstanceUsingDoubleLocking();
		ThreadSafeSingleton instanceTwo = null;
		for(Constructor c : ThreadSafeSingleton.class.getDeclaredConstructors()) {
			c.setAccessible(true);
			instanceTwo = (ThreadSafeSingleton)c.newInstance();
		}
		System.out.println(instanceOne == instanceTwo);
	}
	
}
/**
 * Notes:-
 >Java Singleton
Singleton pattern restricts the instantiation of a class and ensures that only one instance of the class exists in the java virtual machine.
The singleton class must provide a global access point to get the instance of the class.
Singleton pattern is used for logging, drivers objects, caching and thread pool.
Singleton design pattern is also used in other design patterns like Abstract Factory, Builder, Prototype, Facade etc.
Singleton design pattern is used in core java classes also, for example java.lang.Runtime, java.awt.Desktop.

>Java Singleton Pattern
To implement Singleton pattern, we have different approaches but all of them have following common concepts.

Private constructor to restrict instantiation of the class from other classes.
Private static variable of the same class that is the only instance of the class.
Public static method that returns the instance of the class, this is the global access point for outer world to get the instance of the singleton class.

In further sections, we will learn different approaches of Singleton pattern implementation and design concerns with the implementation.

1. Eager initialization
2. Static block initialization
3. Lazy Initialization
4. Thread Safe Singleton
5. Bill Pugh Singleton Implementation
6. Using Reflection to destroy Singleton Pattern
7. Enum Singleton
8. Serialization and Singleton
 * */
