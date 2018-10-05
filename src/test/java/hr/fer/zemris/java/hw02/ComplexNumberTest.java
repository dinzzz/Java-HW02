package hr.fer.zemris.java.hw02;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import hr.fer.zemris.java.hw02.ComplexNumber;

public class ComplexNumberTest {

	@Test
	public void fromRealTest() {
		ComplexNumber cn = ComplexNumber.fromReal(2.0);

		Assert.assertEquals(2.0, cn.getReal(), Double.MIN_VALUE);
	}

	@Test
	public void fromImaginaryTest() {
		ComplexNumber cn = ComplexNumber.fromImaginary(13.0);

		Assert.assertEquals(13.0, cn.getImaginary(), Double.MIN_VALUE);
	}

	@Test
	public void fromMagnitudeAndAngleTest() {
		ComplexNumber cn = ComplexNumber.fromMagnitudeAndAngle(5, Math.atan2(4, 3));

		Assert.assertEquals(4, cn.getImaginary(), Double.MIN_VALUE);
		Assert.assertEquals(3, cn.getReal(), Double.MIN_VALUE);
	}

	@Test
	public void parseBothPositiveTest() {
		ComplexNumber cn = ComplexNumber.parse("2+2i");

		Assert.assertEquals(2, cn.getImaginary(), Double.MIN_VALUE);
		Assert.assertEquals(2, cn.getReal(), Double.MIN_VALUE);
	}

	@Test
	public void parseBothNegativeTest() {
		ComplexNumber cn = ComplexNumber.parse("-2-2i");

		Assert.assertEquals(-2, cn.getImaginary(), Double.MIN_VALUE);
		Assert.assertEquals(-2, cn.getReal(), Double.MIN_VALUE);
	}

	@Test
	public void parsePositiveNegativeTest() {
		ComplexNumber cn = ComplexNumber.parse("2-2i");

		Assert.assertEquals(-2, cn.getImaginary(), Double.MIN_VALUE);
		Assert.assertEquals(2, cn.getReal(), Double.MIN_VALUE);
	}

	@Test
	public void parseNegativePositiveTest() {
		ComplexNumber cn = ComplexNumber.parse("-2+2i");

		Assert.assertEquals(2, cn.getImaginary(), Double.MIN_VALUE);
		Assert.assertEquals(-2, cn.getReal(), Double.MIN_VALUE);
	}

	@Test
	public void parseOnlyRealTest() {
		ComplexNumber cn = ComplexNumber.parse("2");

		Assert.assertEquals(0, cn.getImaginary(), Double.MIN_VALUE);
		Assert.assertEquals(2, cn.getReal(), Double.MIN_VALUE);
	}

	@Test
	public void parseOnlyImaginaryTest() {
		ComplexNumber cn = ComplexNumber.parse("-2i");

		Assert.assertEquals(-2, cn.getImaginary(), Double.MIN_VALUE);
		Assert.assertEquals(0, cn.getReal(), Double.MIN_VALUE);
	}

	@SuppressWarnings("unused")
	@Test
	public void parseFailTest() {
		try {
			ComplexNumber cn = ComplexNumber.parse("Fail");
			fail("Expected a IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException ex) {

		}
	}

	@Test
	public void getRealTest() {
		ComplexNumber cn = new ComplexNumber(2, 3);

		Assert.assertEquals(2, cn.getReal(), Double.MIN_VALUE);
	}

	@Test
	public void getImaginaryTest() {
		ComplexNumber cn = new ComplexNumber(2, 3);

		Assert.assertEquals(3, cn.getImaginary(), Double.MIN_VALUE);
	}

	@Test
	public void getMagnitudeTest() {
		ComplexNumber cn = new ComplexNumber(3, 4);

		Assert.assertEquals(5, cn.getMagnitude(), Double.MIN_VALUE);
	}

	@Test
	public void getAngleTest() {
		ComplexNumber cn = new ComplexNumber(3, 4);

		Assert.assertEquals(Math.atan2(4, 3), cn.getAngle(), Double.MIN_VALUE);
	}

	@Test
	public void addTest() {
		ComplexNumber cn = new ComplexNumber(3, 4);
		ComplexNumber cn2 = new ComplexNumber(5, 6);

		ComplexNumber cadd = cn.add(cn2);

		Assert.assertEquals(8, cadd.getReal(), Double.MIN_VALUE);
		Assert.assertEquals(10, cadd.getImaginary(), Double.MIN_VALUE);
	}

	@Test
	public void subTest() {
		ComplexNumber cn = new ComplexNumber(3, 4);
		ComplexNumber cn2 = new ComplexNumber(5, 7);

		ComplexNumber csub = cn.sub(cn2);

		Assert.assertEquals(-2, csub.getReal(), Double.MIN_VALUE);
		Assert.assertEquals(-3, csub.getImaginary(), Double.MIN_VALUE);
	}

	@Test
	public void mulTest() {
		ComplexNumber cn = new ComplexNumber(3, 4);
		ComplexNumber cn2 = new ComplexNumber(5, 6);

		ComplexNumber cmul = cn.mul(cn2);

		Assert.assertEquals(-9, cmul.getReal(), Double.MIN_VALUE);
		Assert.assertEquals(38, cmul.getImaginary(), Double.MIN_VALUE);
	}

	@Test
	public void divTest() {
		ComplexNumber cn = new ComplexNumber(3, 4);
		ComplexNumber cn2 = new ComplexNumber(5, 6);

		ComplexNumber cdiv = cn.div(cn2);

		Assert.assertEquals(39.0 / 61.0, cdiv.getReal(), Double.MIN_VALUE);
		Assert.assertEquals(2.0 / 61.0, cdiv.getImaginary(), Double.MIN_VALUE);
	}

	@Test
	public void powerTest() {
		ComplexNumber cn = new ComplexNumber(3, 4);

		ComplexNumber cpower = cn.power(3);

		Assert.assertEquals(125 * Math.cos(3 * Math.atan2(4.0, 3.0)), cpower.getReal(), Double.MIN_VALUE);
		Assert.assertEquals(125 * Math.sin(3 * Math.atan2(4.0, 3.0)), cpower.getImaginary(), Double.MIN_VALUE);
	}

	@Test
	public void rootTest() {
		ComplexNumber cn = new ComplexNumber(3, 4);

		ComplexNumber croot = cn.root(3)[1];

		Assert.assertEquals(Math.pow(5, 1 / 3) * Math.cos((Math.atan2(4, 3) + 2 * Math.PI) / 3), croot.getReal(),
				Double.MIN_VALUE);
		Assert.assertEquals(Math.pow(5, 1 / 3) * Math.sin((Math.atan2(4, 3) + 2 * Math.PI) / 3), croot.getImaginary(),
				Double.MIN_VALUE);
	}

}
