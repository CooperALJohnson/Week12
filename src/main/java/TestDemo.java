import java.util.Random;

public class TestDemo {

	int i1;
	int i2;
	int ans;
	
	public int addPositive (int i1, int i2) {
		if(i1 < 0 && i2 < 0) {
			throw new IllegalArgumentException("Both peramiters must be positive!");
		} else {
			return i1 + i2;
		}
	}
	public int randomNumberSquared() {
		getRandomInt();
		return ans * ans;
	}
	
	public int getRandomInt() {
		  Random random = new Random();
		  return random.nextInt(10) + 1;
		}

}