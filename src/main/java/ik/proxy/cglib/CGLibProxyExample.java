package ik.proxy.cglib;

import ik.proxy.app.impl.Greeter;
import net.sf.cglib.proxy.Enhancer;

/**
 * Example of dynamic proxy class with use of CGLib.
 * 
 * @author ikonovi
 *
 */
public class CGLibProxyExample {

	public static void main(String[] args) {

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Greeter.class);
		enhancer.setCallback(new MyMethodInterceptor());

		Class<?>[] argumentTypes = { String.class };
		Object[] arguments = { "Hello" };

		Greeter proxyGreeter = (Greeter) enhancer.create(argumentTypes, arguments);
		proxyGreeter.greet();

	}
}
