package appscripprep.javaprep.general;

public class Factorial {
	public static void solve1(int n) {
		int res=1;
		for (int i = 2; i <= n; i++) {
			
			res=res* i;
		}
		System.out.println(res);
	}
	
	//
	public static int solve2(int num) {
		if(num == 1) {
			return 1;
		}
		return solve2(num-1)*num;
	}
	public static void main(String[] args) {
		System.out.println(solve2(4));
	}
}
