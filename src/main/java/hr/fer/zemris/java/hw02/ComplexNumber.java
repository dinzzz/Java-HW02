package hr.fer.zemris.java.hw02;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.Math.tan;

/**
 * Class that implements the manipulation and the usage of the Complex numbers.
 * Complex numbers are defined by their real part and their imaginary part. The
 * class also supports the usage of the complex number's polar form for some of
 * their operations.
 * 
 * @author Dinz
 *
 */
public class ComplexNumber {

	private double real;
	private double imaginary;

	/**
	 * Constructs a new complex number from its real and imaginary part.
	 * 
	 * @param real
	 *            Real part of the complex number
	 * @param imaginary
	 *            Imaginary part of the complex number
	 */
	public ComplexNumber(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	/**
	 * Method that constructs a new complex number only from its real part, meaning
	 * the imaginary part is 0.
	 * 
	 * @param real
	 *            Real part of the complex number
	 * @return Newly formed complex number
	 */
	public static ComplexNumber fromReal(double real) {
		return new ComplexNumber(real, 0);
	}

	/**
	 * Method that constructs a new complex number only from its imaginary part,
	 * meaning the real part is 0.
	 * 
	 * @param imaginary
	 *            Imaginay part of the complex number
	 * @return Newly formed complex number
	 */
	public static ComplexNumber fromImaginary(double imaginary) {
		return new ComplexNumber(0, imaginary);
	}

	/**
	 * Method that constructs a new complex number from its magnitude and its angle.
	 * 
	 * @param magnitude
	 *            Magnitude of the complex number
	 * @param angle
	 *            Angle of the complex number
	 * @return Newly formed complex number
	 */
	public static ComplexNumber fromMagnitudeAndAngle(double magnitude, double angle) {
		double real = sqrt(pow(magnitude, 2) / (1 + pow(tan(angle), 2)));
		double imaginary = real * tan(angle);

		return new ComplexNumber(real, imaginary);

	}

	/**
	 * Method that parses the given string into a complex number. Throws an
	 * exception if the input is invalid.
	 * 
	 * @param s
	 *            Input string
	 * @return Newly formed complex number
	 */
	public static ComplexNumber parse(String s) {
		if (!s.contains("i")) {
			try {
				return new ComplexNumber(Double.parseDouble(s), 0);
			} catch (NumberFormatException ex) {
				System.out.println("Invalid number format");
			}
		} else if (s.equals("i"))
			return new ComplexNumber(0, 1);
		else if (s.length() == 2)
			return new ComplexNumber(0, Double.parseDouble(s.split("i")[0]));
		else if (s.length() == 3 && s.contains("-") && s.split("-")[0].length() == 0) {
			return new ComplexNumber(0, Double.parseDouble("-" + s.split("-")[1].split("i")[0]));
		} else if (s.contains("+")) {
			String[] split = s.split("\\+");
			return new ComplexNumber(Double.parseDouble(split[0]), Double.parseDouble(split[1].split("i")[0]));
		} else if (("_" + s + "_").split("-").length == 3) {
			return new ComplexNumber(Double.parseDouble("-" + ("_" + s + "_").split("\\-")[1]),
					Double.parseDouble("-" + ("_" + s + "_").split("\\-")[2].split("i")[0]));
		} else if (s.contains("-")) {
			return new ComplexNumber(Double.parseDouble(s.split("\\-")[0]),
					-1 * Double.parseDouble(s.split("\\-")[1].split("i")[0]));
		} else {
			throw new IllegalArgumentException("Not a valid input.");
		}
		return null; // Unreachable code

	}

	/**
	 * Gets the real part of the complex number.
	 * 
	 * @return real part of the complex number
	 */
	public double getReal() {
		return this.real;
	}

	/**
	 * Gets the imaginary part of the complex number.
	 * 
	 * @return imaginary part of the complex number
	 */
	public double getImaginary() {
		return this.imaginary;
	}

	/**
	 * Gets the magnitude of the complex number for its polar form.
	 * 
	 * @return magnitude of the complex number
	 */
	public double getMagnitude() {
		return sqrt(pow(this.real, 2) + pow(this.imaginary, 2));
	}

	/**
	 * Gets the angle of the complex number for its polar form
	 * 
	 * @return angle of the complex number
	 */
	public double getAngle() {
		return atan2(this.imaginary, this.real);
	}

	/**
	 * Method that adds two complex numbers
	 * 
	 * @param c
	 *            second complex number to add
	 * @return Newly formed complex number
	 */
	public ComplexNumber add(ComplexNumber c) {
		return new ComplexNumber(this.real + c.real, this.imaginary + c.imaginary);
	}

	/**
	 * Method that subtracts two complex numbers
	 * 
	 * @param c
	 *            complex number to subtract
	 * @return Newly formed complex number
	 */
	public ComplexNumber sub(ComplexNumber c) {
		return new ComplexNumber(this.real - c.real, this.imaginary - c.imaginary);
	}

	/**
	 * Method that multiplies two complex numbers
	 * 
	 * @param c
	 *            second complex number to multiply
	 * @return Newly formed complex number
	 */
	public ComplexNumber mul(ComplexNumber c) {
		return new ComplexNumber(this.real * c.real - this.imaginary * c.imaginary,
				this.imaginary * c.real + this.real * c.imaginary);
	}

	/**
	 * Method that divides two complex numbers
	 * 
	 * @param c
	 *            complex number to divide
	 * @return Newly formed complex number
	 */
	public ComplexNumber div(ComplexNumber c) {
		return new ComplexNumber(
				(this.real * c.real + this.imaginary * c.imaginary) / (pow(c.real, 2) + pow(c.imaginary, 2)),
				(this.imaginary * c.real - this.real * c.imaginary) / (pow(c.real, 2) + pow(c.imaginary, 2)));
	}

	/**
	 * Method that calculates the complex number to the power of a given number
	 * 
	 * @param n
	 *            Exponent
	 * @return Newly formed complex number
	 */
	public ComplexNumber power(int n) {
		double powerReal = pow(this.getMagnitude(), n) * cos(n * this.getAngle());
		double powerImaginary = pow(this.getMagnitude(), n) * sin(n * this.getAngle());

		return new ComplexNumber(powerReal, powerImaginary);
	}

	/**
	 * Method that calculates the root of the complex number to the given extent
	 * 
	 * @param n
	 *            Root value
	 * @return Array of the newly formed complex numbers
	 */
	public ComplexNumber[] root(int n) {
		ComplexNumber[] array = new ComplexNumber[n];
		for (int k = 0; k < n; k++) {
			double rootReal = pow(this.getMagnitude(), 1 / n) * cos((this.getAngle() + 2 * k * PI) / n);
			double rootImaginary = pow(this.getMagnitude(), 1 / n) * sin((this.getAngle() + 2 * k * PI) / n);

			array[k] = new ComplexNumber(rootReal, rootImaginary);
		}

		return array;
	}

	/**
	 * Method that transforms the complex number to the string.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (!(this.real == 0))
			sb.append(this.real);

		if (!(this.imaginary == 0)) {
			if (this.imaginary < 0)
				sb.append(("-"));
			else if (!(this.real == 0))
				sb.append("+");
			sb.append(abs(this.imaginary) + "i");
		}

		if (this.real == 0 && this.imaginary == 0)
			return "0";
		return sb.toString();
	}
}
