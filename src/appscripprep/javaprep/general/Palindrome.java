package appscripprep.javaprep.general;

public class Palindrome {
	//Number palindrome
	public static boolean solve1(int num) {
		int temp=num;
		int rem=0;
		int rev=0;
		while(temp != 0) {
			rem=temp%10;
			rev=rev*10 +rem;
			temp=temp/10;
		}
		return rev == num;
	}
	

	public static void main(String[] args) {
		System.out.println(solve1(121));
	}

}
