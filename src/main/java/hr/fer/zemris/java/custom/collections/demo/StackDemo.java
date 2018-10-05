package hr.fer.zemris.java.custom.collections.demo;

import hr.fer.zemris.java.custom.collections.EmptyStackException;
import hr.fer.zemris.java.custom.collections.ObjectStack;

/**
 * Class that demonstrate the usage of the ObjectStack class. The program gets
 * the arguments from a string in a command line, parse the string into valid
 * operators and performs the operations using the stack. In the end, the
 * program prints the evaluation of the expression. If there is an invalid
 * number of arguments, the program will notify the user and close. Same goes to
 * the expression being invalid and ending up in dividing by zero or trying to
 * do operations on an empty stack.
 * 
 * @author Dinz
 *
 */
public class StackDemo {
	/**
	 * Class that executes the demonstration of the ObjectStack class.
	 * 
	 * @param args
	 *            Arguments of the program.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			checkArguments(args);
		} catch (IllegalArgumentException ex) {
			System.out.println("Invalid number of inputted arguments.");
			System.exit(0);
		}

		String[] input = args[0].split(" +");
		ObjectStack stack = new ObjectStack();

		for (int i = 0; i < input.length; i++) {
			if (input[i].equals("+"))
				add(stack);
			else if (input[i].equals("-"))
				subtract(stack);
			else if (input[i].equals("/")) {
				try {
					divide(stack);
				} catch (IllegalArgumentException ex) {
					System.out.println("You can't divide with zero!");
					System.exit(0);
				}

			} else if (input[i].equals("*"))
				multiply(stack);
			else if (input[i].equals("%"))
				reminder(stack);
			else {
				try {
					int number = Integer.parseInt(input[i]);
					stack.push(number);
				} catch (NumberFormatException ex) {
					System.out.println("You entered an unknown operator.");
					System.exit(0);
				}

			}

		}

		try {
			checkStack(stack);
		} catch (IllegalArgumentException ex) {
			System.out.println("Your input is not a valid expression.");
			System.exit(0);
		}

		System.out.println("Expression evaluates to " + stack.pop() + ".");
	}

	/**
	 * Method that represents multiplication by popping two elements from the top of
	 * the stack, multiplying them and pushing the result on the top. The method
	 * cancels the operation if the stack is empty.
	 * 
	 * @param stack
	 *            Stack
	 */
	public static void multiply(ObjectStack stack) {
		try {
			int a = (int) stack.pop();
			int b = (int) stack.pop();

			stack.push(b * a);
		} catch (EmptyStackException ex) {
			System.out.println("The stack is empty - No arguments available to execute the operation.");
			System.exit(0);
		}

	}

	/**
	 * Method that represents division by popping two elements from the top of the
	 * stack, dividing them and pushing the result on the top. The method cancels
	 * the operation if the stack is empty.
	 * 
	 * @param stack
	 *            Stack
	 */
	public static void divide(ObjectStack stack) {
		try {
			int a = (int) stack.pop();
			int b = (int) stack.pop();

			if (a == 0)
				throw new IllegalArgumentException("You can't divide by zero!");

			stack.push(b / a);
		} catch (EmptyStackException ex) {
			System.out.println("The stack is empty - No arguments available to execute the operation.");
			System.exit(0);
		}

	}

	/**
	 * Method that represents addition by popping two elements from the top of the
	 * stack, adding them and pushing the result the top. The method cancels the
	 * operation if the stack is empty.
	 * 
	 * @param stack
	 *            Stack
	 */
	public static void add(ObjectStack stack) {
		try {
			int a = (int) stack.pop();
			int b = (int) stack.pop();

			stack.push(b + a);
		} catch (EmptyStackException ex) {
			System.out.println("The stack is empty - No arguments available to execute the operation.");
			System.exit(0);
		}

	}

	/**
	 * Method that represents subtraction by popping two elements from the top of
	 * the stack, subtracting them and pushing the result on the top. The method
	 * cancels the operation if the stack is empty.
	 * 
	 * @param stack
	 *            Stack
	 */
	public static void subtract(ObjectStack stack) {
		try {
			int a = (int) stack.pop();
			int b = (int) stack.pop();

			stack.push(b - a);
		} catch (EmptyStackException ex) {
			System.out.println("The stack is empty - No arguments available to execute the operation.");
			System.exit(0);
		}
	}

	/**
	 * Method that represents the reminder of the division by popping two elements
	 * from the top of the stack, dividing them and pushing the reminder on the top.
	 * The method cancels the operation if the stack is empty.
	 * 
	 * @param stack
	 *            Stack
	 */
	public static void reminder(ObjectStack stack) {
		try {
			int a = (int) stack.pop();
			int b = (int) stack.pop();

			stack.push(b % a);
		} catch (EmptyStackException ex) {
			System.out.println("The stack is empty - No arguments available to execute the operation.");
			System.exit(0);
		}
	}

	/**
	 * Method that checks the number of the arguments of the program. Throws the
	 * IllegalArgumentException if the number of the arguments is invalid.
	 * 
	 * @param args
	 *            Arguments of the program
	 */
	public static void checkArguments(String[] args) {
		if (args.length != 1)
			throw new IllegalArgumentException("Invalid number of arguments.");
	}

	/**
	 * Method that checks the stack size after processing all the given operators.
	 * Throws an IllegalArgumentException if the stack size is different then 1.
	 * 
	 * @param stack
	 *            Stack
	 */
	public static void checkStack(ObjectStack stack) {
		if (stack.size() != 1)
			throw new IllegalArgumentException("Invalid expression.");
	}

}
