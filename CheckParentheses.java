import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author Gopal 19CSU115 
 *
 */
public class CheckParentheses {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the Expression: ");
		
		String expression = sc.nextLine();
		
		//Calling replaceAll() to replace all spaces(Whitespace) with no Space;
		//  "//s" is single space in unicode
		expression = expression.replaceAll("\\s", "");
		
		try {
			findWrongExpression(expression, sc);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	/**
	* @param expression String Entered by User
	 * @param sc Scanner object to read value
	 * @throws InterruptedException 
	*/
	private static void findWrongExpression(String expression, Scanner sc) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Stack<Character> expStack = new Stack<>();
		boolean isBalanced = true;
		
		for (int i = 0; i < expression.length(); i++) {
			
			if (expression.charAt(i) == '(' || expression.charAt(i) == '{' || expression.charAt(i) == '[') { //{ [b ⋅ b – (4 ⋅ a ⋅ c ) ] / (2 ⋅ a) }
				expStack.push(expression.charAt(i));
				
			}if(expression.charAt(i) == ')') {
					
					if(!expStack.isEmpty() && expStack.peek() == '(') {
						if(!expStack.isEmpty())
						expStack.pop();
					}else {
						isBalanced = false;
						System.out.println("Expression has un-balanced Parentheses, misssing opening: " + "(");
						break;
					}
					
			} if (expression.charAt(i) == '}') {
					
					if (!expStack.isEmpty() && expStack.peek() == '{') {
						if(!expStack.isEmpty())
						expStack.pop();
						
					}else {
						isBalanced = false;
						System.out.println("Expression has un-balanced Parentheses, misssing opening: " + "{" );
						break;
					}
					
			} if(expression.charAt(i) == ']') {
					
					if ( !expStack.isEmpty() && expStack.peek() == '[' ) {
						expStack.pop();
					}else {
						isBalanced = false;
						System.out.println("Expression has un-balanced Parentheses, misssing opening: " + "[");
						break;
				}
			}					
		}			
		if(isBalanced && expStack.isEmpty()) {
			System.out.println("Expression has balanced Parentheses");
		}else {
			if(!expStack.isEmpty())
			System.out.println("Expression has un-balanced Parentheses, extra: " + expStack.pop());
		}
		
		Thread.sleep(1000);
		System.out.println("\n\nPress\n1)For Enter Expression again.\n2)To Exit");
		
		byte choice = sc.nextByte();  //Used Byte to save Memory
		switch(choice) {		
		case 1:
			main(null);
			break;
		case 2 :
			System.out.println("Exiting Program");
			break;
		default: 
			System.out.println("Exiting Program Wrong Input");				
		}
	}
}










