package appscripprep.javaprep.sort;

public class OperatorPrecedence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve2();
	}

	private static void solve1() {
		// Defining variables.
        int x = 5, y = 10, z = 3;

        // Calcuating result.
        int ans = x + y * z / 10;

        // Printing it.
        System.out.println(ans); 
	}
	private static void solve2() {
		// Defining variables.
        int x = 10, y = 20, z = 5;

        // Calculating result.
        int ans = x + --y - ++z;

        // Printing it.
        System.out.println(ans); 
	}
	private static void solve3() {
		// Defining variables.
        int x = 2, y = 3, z = 4;

        // Calculating result.
        int ans = ++x + ++y + 5 << 1 | 2;

        // Printing it.
        System.out.println(ans); 
	}

}
