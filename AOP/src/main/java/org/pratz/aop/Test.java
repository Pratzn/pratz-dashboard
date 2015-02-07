package org.pratz.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
				"beans.xml");

		Adder adder = (Adder) ctx.getBean("adder");
		int result = adder.add(10, 10);
		System.out.println("Result = " + result);

		result = adder.add(0, 0);
		System.out.println("Result = " + result);
		ctx.registerShutdownHook();

	}

}
