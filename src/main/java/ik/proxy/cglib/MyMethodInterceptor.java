package ik.proxy.cglib;

import java.lang.reflect.Method;

import ik.proxy.app.impl.Greeter;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyMethodInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object enhancedObj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		proxy.invokeSuper(enhancedObj, args);
		Object output = proxy.invoke(new Greeter(" ...CGLib \n"), args);
		return output;
	}
}
