package hr.fer.zemris.java.hw02.demo;

import hr.fer.zemris.java.hw02.ComplexNumber;

/**
 * Class that demonstrates the use of ComplexNumber class.
 * 
 * @author Dinz
 *
 */
public class ComplexDemo {
	/**
	 * Method that runs the demonstration of ComplexNumber class.
	 * 
	 * @param args
	 *            Arguments of the program.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComplexNumber c1 = new ComplexNumber(2, 3);
		System.out.println(c1);
		ComplexNumber c2 = ComplexNumber.parse("2.5-3i");
		System.out.println(c2);
		ComplexNumber c4 = ComplexNumber.parse("-2.5-3i");
		System.out.println(c4);
		ComplexNumber c5 = ComplexNumber.parse("3i");
		System.out.println(c5);
		ComplexNumber c99 = ComplexNumber.parse("-3i");
		System.out.println(c99);
		ComplexNumber c6 = ComplexNumber.parse("13");
		System.out.println(c6);
		ComplexNumber c7 = ComplexNumber.parse("2+2i");
		System.out.println(c7);
		// Exception = ComplexNumber c9 = ComplexNumber.parse("Jambrek Prosinečki");
		// System.out.println(c9);
		ComplexNumber c3 = c1.add(ComplexNumber.fromMagnitudeAndAngle(2, 1.57)).div(c2).power(3).root(2)[1];
		ComplexNumber c8 = ComplexNumber.fromMagnitudeAndAngle(2, 1.57);
		System.out.println(c8.getImaginary());
		System.out.println(c3);
		System.out.println(c8.add(c1).div(c2).power(3));
	}

}
