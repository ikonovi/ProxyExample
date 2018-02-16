package ik.proxy.java_api;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Set;

/**
 * Dynamic proxy of Set interface.
 * 
 * @author https://www.ibm.com/developerworks/ru/library/j-jtp08305/index.html
 *
 */
public class SetProxyFactoryExample {
	
	public static Set<?> getSetProxy(final Set<?> s) {
		
		return (Set<?>) Proxy.newProxyInstance(s.getClass().getClassLoader(), new Class[] { Set.class },
				
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						return method.invoke(s, args);
					}
				});
	}
}
