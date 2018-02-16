package ik.proxy.java_api;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import ik.proxy.app.GreetAble;
import ik.proxy.app.impl.Greeter;

public class MyInvocationHandler implements InvocationHandler {

	private GreetAble origObj;

	public MyInvocationHandler(GreetAble originalFoo) {
		this.origObj = originalFoo;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		method.invoke(origObj, args);		
		Object output = method.invoke(new Greeter(" ...Java Reflection API\n"), args);		
		return output;
	}
}
