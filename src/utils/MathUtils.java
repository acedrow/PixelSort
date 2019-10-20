package utils;

public class MathUtils {
	public static int getRandomInRange(int start, int end){
		if (start >= end){
			System.err.println("Invalid random range, returning 0");
			return 0;
		}
		int random = 0;
		double seed = Math.random();
		random = (int) Math.floor(seed * (end - start));
		random += start;
		
		return random;
		
	}
}
