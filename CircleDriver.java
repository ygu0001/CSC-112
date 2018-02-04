
/*
 * Name: Clair Yiting Gu
 * Date: 2/3/2018
 * Course Number:CSC-112
 * Course Name: Intermediate Topics in Java Programming
 * Email: ygu0001@student.stcc.edu
 * Circle Class Creation/Testing
 */

import java.util.Scanner;

public class CircleDriver {

	private static Circle buildCircle(Scanner sc, String prompt) {
		double x;
		double y;
		double radius;
		do {
			System.out.print(prompt);
			x = sc.nextDouble();
			y = sc.nextDouble();
			radius = sc.nextDouble();
			sc.nextLine();  // Clear Keyboard
			if (radius >= 0)
				break;
			System.out.println("Not a valid circle! radius is invalid. Value must be greater than 0. Please try again.");
		} while (true);
		return new Circle(x, y, radius);
	}

	// **********************************************

	private static void testThemCircles(Circle c1, Circle c2) {
		System.out.printf("Circle 1 centet is = %s\n", c1.toString(c1));
		System.out.printf("Area of Circle c1 = %.3f, the perimeter = %.3f\n", c1.getArea(), c1.getPerimeter());
		System.out.printf("Circle 2 center is= %s\n", c2.toString(c2));
		System.out.printf("Area of Circle c2 = %.3f, the perimeter = %.3f\n", c2.getArea(), c2.getPerimeter());
		
		double radiusDist = Math.sqrt(Math.pow(c1.getX() - c2.getX(), 2) + Math.pow(c1.getY() - c2.getY(), 2));
		System.out.printf("The distance between their centers is: %.3f\n", radiusDist);
		

		if (c2.contains(c1))
			System.out.println("c2 contains c1");
		else if (c1.contains(c2))
			System.out.println("c1 contains c2");
		else if (c2.overlaps(c1))
			System.out.println("Circle c1 and Circle c2 overlap.");
		else
			System.out.println("Circle c1 and Circle c2 do not overlap and neither contain each other.");
	}

	// **********************************************

	private static void testThosePoints(Scanner sc, Circle c1, Circle c2) {
		System.out.println("Now, please enter any point (x,y): ");
		double px = sc.nextDouble();
		double py = sc.nextDouble();
		sc.nextLine();
		System.out.println("Circle 1 " + (c1.contains(px, py) ? "contains " : "does not contain ") + "this point.");
		System.out.println("Circle 2 " + (c2.contains(px, py) ? "contains " : "does not contain ") + "this point.");
	}

	// **********************************************

	private static void process(Scanner sc, String args[]) {
		Circle c1 = buildCircle(sc, "Enter x and y values for the center (x,y) followed by the radius for Circle 1: ");
		Circle c2 = buildCircle(sc, "Enter x and y values for the center (x,y) followed by the radius for Circle 2: ");
		testThemCircles(c1, c2);
		testThosePoints(sc, c1, c2);
	}

	// **********************************************

	private static boolean doThisAgain(Scanner sc, String prompt) {
		System.out.print(prompt);
		String doOver = sc.nextLine();
		return doOver.equalsIgnoreCase("Y");
	}

	// **********************************************

	public static void main(String args[]) {
		final String TITLE = "CSC-112 Testing Circles Program ";
		final String CONTINUE_PROMPT = "Do this again? [y/N] ";

		System.out.println("Welcome to " + TITLE);
		Scanner sc = new Scanner(System.in);
		do {
			process(sc, args);
		} while (doThisAgain(sc, CONTINUE_PROMPT));
		sc.close();
		System.out.println("Thank you for using " + TITLE);
	}
}