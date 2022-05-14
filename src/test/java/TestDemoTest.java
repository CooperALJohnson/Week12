import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Random;
import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;
public class TestDemoTest {
	private TestDemo testdemo;
	int a = 0, b = 0, expected = 0;
	boolean expectException = false;
	public int getRandomInt() {
		  Random random = new Random();
		  return random.nextInt(10) + 1;
		}
	
	public int addPositive(int i1, int i2) {
		return i1 + i2;
	}
	
	@BeforeEach
	void setUp() throws Exception {
		testdemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly() {
		if(!expectException) {
			assert(testdemo.addPositive(a, b) == expected);
			} else {
				assertThatThrownBy(() -> 
			    testdemo.addPositive(a, b))
			        .isInstanceOf(IllegalArgumentException.class);
			}
	}
	
	public static Stream argumentsForAddPositive() {
		return Stream.of(arguments(-1, 1, 0, true), 
				arguments(2, 4, 6, false),
				arguments(1, 1, 2, false),
				arguments(0, 1, 1, false),
				arguments(3, 5, 8, false) );
	}
	
	@Test
	private void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testdemo);
		doReturn(5).when(testdemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assert(fiveSquared) == 25;
	}
	
	
	
	
	
	
	
	
	
	
	
}