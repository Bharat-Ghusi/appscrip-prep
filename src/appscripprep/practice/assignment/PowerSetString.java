package appscripprep.practice.assignment;

public class PowerSetString {
	//
	public static void solve1(String str, int index, String curr) {
		if (index == str.length()) {
			System.out.println(curr);
			return;
		}
		solve1(str, index + 1, curr + str.charAt(index)); // Left side
		solve1(str, index + 1, curr); // Right side
	}

	public static void main(String[] args) {
		String str = "ABC";
		String curr = "";
		solve1(str, 0, curr);
		/* [ABC]
		 *  ABC AB AC A BC B C
		 * 
		 * 
		 */
	}
}
