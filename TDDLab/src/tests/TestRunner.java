/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Jan 17, 2022
 */
package tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class TestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestCarLogic.class);
		
		for(Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		
		System.out.println(result.wasSuccessful());

	}

}
