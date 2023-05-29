package appscripprep.javaprep.general;

public class PerfectSquare {
	public static boolean solve1(int num) {
		if(Math.pow(Math.sqrt(num), 2) == num) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(solve1(64));
	}

}
