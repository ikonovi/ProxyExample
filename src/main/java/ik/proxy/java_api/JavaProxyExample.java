package ik.proxy.java_api;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

import ik.proxy.app.GreetAble;
import ik.proxy.app.impl.Greeter;

/**
 * Example of dynamic proxy class with use of Java API - java.lang.reflect
 * package.
 * 
 * @author ikonovi
 *
 */
public class JavaProxyExample {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		GreetAble origObj = new Greeter("Hello");

		ClassLoader loader = JavaProxyExample.class.getClassLoader();
		Class<?>[] interfaces = { GreetAble.class };
		MyInvocationHandler handler = new MyInvocationHandler(origObj);

		// Option #1
		Class<?> proxyClass = Proxy.getProxyClass(loader, interfaces);
		GreetAble proxyObj1 = (GreetAble) proxyClass.getConstructor(InvocationHandler.class).newInstance(handler);
		proxyObj1.greet();

		// Option #2
		GreetAble proxyObj2 = (GreetAble) Proxy.newProxyInstance(loader, interfaces, handler);
		proxyObj2.greet();

	}

}
