package ngo.skarb.lessons;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterestCalculatorTest {

	private InterestCalculator interestCalculator;

	@BeforeEach
	void setUp() {
		interestCalculator = new InterestCalculator();
	}

	@AfterEach
	void tearDown() {
		interestCalculator = null;
	}

	static Stream<Arguments> interestParameters() {
		return Stream.of(
			Arguments.of(1000.00, 0.05, 1, 50.00),
			Arguments.of(50.0, 0.2, 10.0, 100.0),
			Arguments.of(50.0, 0, 5.0, 0.0),
			Arguments.of(50.0, 0.2, 1.0, 10.0)
		);
	}

	@ParameterizedTest
	@MethodSource("interestParameters")
	void calculateInterest_shouldReturnExpectedInterest(double principal, double rate, double time, double expected) {
		double actual = interestCalculator.calculateInterest(principal, rate, time);
		assertEquals(actual, expected);
	}
}
