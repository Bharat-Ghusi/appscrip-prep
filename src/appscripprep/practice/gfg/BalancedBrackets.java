//https://practice.geeksforgeeks.org/problems/parenthesis-checker2744/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
/*
 * Given an expression string x. Examine whether the pairs and the orders of {,},(,),[,] are correct in exp.
For example, the function should return 'true' for exp = [()]{}{[()()]()} and 'false' for exp = [(]).

Note: The drive code prints "balanced" if function return true, otherwise it prints "not balanced".
 */
package appscripprep.practice.gfg;

import java.util.Stack;

public class BalancedBrackets {
	//O(N)
	public static boolean solve1(String x) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < x.length(); i++) {
			char ch = x.charAt(i);
			if(ch == '{' || ch == '[' || ch == '(') {
				stack.push(ch);
			}
			//It's a closing tag
			else if( ch == '}' || ch == ']' ||  ch == ')' ) {
				if(stack.isEmpty())return false;
				
				char top = stack.pop();
				if((top == '{' && ch != '}' ) || (top == '[' && ch != ']') || (top == '(' && ch != ')') ) {
					return false;
				}
				
			}
		}
		return stack.isEmpty();
	}
	public static void main(String[] args) {
//		System.out.println(solve1("[(])"));
//		System.out.println(solve1("[()]{}{[()()]()}"));
		System.out.println(solve1("("));
	}

}
