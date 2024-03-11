package ngo.skarb.lessons;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

	private Calculator calculator;

	private final double a = 3;
	private final double b = 2;

	@BeforeEach
	public void init() {
		calculator = new Calculator();
	}

	@AfterEach
	public void tearDown() {
		calculator = null;
	}

	@Nested
	public class AdditionSubtractionTests {

		@Test
		@DisplayName("Addition test")
		@Disabled
		public void testAddition() {
			double result = calculator.add(a, b);
			final double expected = 5;
			assertEquals(expected, result);
		}

		@Test
		@DisplayName("Subtraction test")
		public void testSubtraction() {
			double result = calculator.subtract(a, b);
			final double expected = 1;
			assertEquals(expected, result);
		}
	}

	@Nested
	public class MultiplicationDivisionTests {

		@Test
		@DisplayName("Multiplication test")
		public void testMultiplication() {
			double result = calculator.multiply(a, b);
			final double expected = 6;
			assertEquals(expected, result);
		}

		@Test
		@DisplayName("Division test")
		public void testDivision() {
			double result = calculator.divide(a, b);
			final double expected = 1.5;
			assertEquals(expected, result);
		}
	}
}
