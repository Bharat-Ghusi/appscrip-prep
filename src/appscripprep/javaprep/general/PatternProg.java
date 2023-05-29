package appscripprep.javaprep.general;

public class PatternProg {
	public static void solve1(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = i; j >= 0 ; j--) {
				if(j == 0) {
					System.out.print(1+" ");
				}
				else if( j % 2 == 0) {
					System.out.print(1+" ");
				}
				else {
					System.out.print(0+" ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		solve1(5);
	}

}
