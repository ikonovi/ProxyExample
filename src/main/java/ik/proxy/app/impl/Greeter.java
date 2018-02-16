package ik.proxy.app.impl;

import ik.proxy.app.GreetAble;

public class Greeter implements GreetAble {

	private String greetingText;
	
	public Greeter(String greetingText) {
		this.greetingText = greetingText;
	}
	
	@Override
	public void greet() {		
		System.out.print(this.greetingText);
	}

}
