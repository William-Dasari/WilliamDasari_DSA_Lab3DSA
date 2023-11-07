/*Question 1)  Write a program of Balancing Brackets,
 * use a suitable data structure to print 
 * whether the string entered is a Balanced Brackets or Unbalanced String
 */
import java.util.Stack;
import java.util.Scanner;

public class Question1BalanceBrackets 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{

		// Taking the Brackets "({[]})" as Input by declaring the Scanner object

		Scanner scanner = new Scanner(System.in);
		String brackets = scanner.nextLine();

		// Declaring the object to check the balancing of brackets

		boolean result = isBracketIsBalanced(brackets);

		// final output after checking
		if (result == true) 
		{
			System.out.println("The entered String has Balanced Brackets");
		} 
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");
	}

	// Business logic for finding the balancing brackets

	private static boolean isBracketIsBalanced(String brackets) 
	{
		//Declaring the stack collection object
		Stack<Character> stack = new Stack<>();
		
		//for loop runs based on input length of brackets
		for (int i = 0; i < brackets.length(); i++) 
		{
			char character = brackets.charAt(i);
			
		
			if (character == '(' || character == '{' || character == '[') 
			{
				stack.push(character);
				continue;
			}
			if (stack.isEmpty())
				return false;
			char closing;
			switch (character) {
			case ')':
				closing = stack.pop();
				if (closing == '{' || closing == '[')
					return false;
				break;
			case ']':
				closing = stack.pop();
				if (closing == '{' || closing == '(')
					return false;
				break;
			case '}':
				closing = stack.pop();
				if (closing == '(' || closing == '[')
					return false;
				break;

			default:
				break;
		}
	}
	return stack.isEmpty();
}

}
