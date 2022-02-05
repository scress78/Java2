/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Feb 5, 2022
 */
package model;

/**
 * @author sunga
 *
 */
public class NumberAdder {
	private int numberOne;
	private int numberTwo;
	private int sum;
	private int difference;
	private float product;
	private float quotient;
	private String concatenate;
	
	public String getConcatenate() {
		return concatenate;
	}

	public void setConcatenate(String concatenate) {
		this.concatenate = concatenate;
	}

	public int getNumberOne() {
		return numberOne;
	}

	public void setNumberOne(int numberOne) {
		this.numberOne = numberOne;
	}

	public int getNumberTwo() {
		return numberTwo;
	}

	public void setNumberTwo(int numberTwo) {
		this.numberTwo = numberTwo;
	}
	
	public int getDifference() {
		return difference;
	}

	public void setDifference(int difference) {
		this.difference = difference;
	}

	public float getProduct() {
		return product;
	}

	public void setProduct(float product) {
		this.product = product;
	}

	public float getQuotient() {
		return quotient;
	}

	public void setQuotient(float quotient) {
		this.quotient = quotient;
	}


	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	
	public NumberAdder() {
		super();
	}
	
	
	public NumberAdder(int numberOne, int numberTwo) {
		super();
		this.numberOne = numberOne;
		this.numberTwo = numberTwo;
		addNumbers(numberOne, numberTwo);
		subtractNumbers(numberOne, numberTwo);
		multiplyNumbers(numberOne, numberTwo);
		divideNumbers(numberOne, numberTwo);
		concatenateNumbers(numberOne, numberTwo);
	}
	
	private void addNumbers(int numberOne, int numberTwo) {
		setSum(numberOne + numberTwo);
	}
	
	private void subtractNumbers(int numberOne, int numberTwo) {
		setDifference(numberOne - numberTwo);
	}
	
	private void multiplyNumbers(int numberOne, int numberTwo) {
		setProduct(numberOne * numberTwo);
	}
	
	private void divideNumbers(int numberOne, int numberTwo) {
		float numOne = numberOne;
		float numTwo = numberTwo;
		setQuotient(numOne / numTwo);
	}
	
	private void concatenateNumbers(int numberOne, int numberTwo) {
		setConcatenate(Integer.toString(numberOne) + Integer.toString(numberTwo));
	}
	
	@Override
	public String toString() {
		return String.format("The sum of the numbers %2d and %2d is %2d", this.numberOne, this.numberTwo, this.sum);
	}
	
	
	

}
