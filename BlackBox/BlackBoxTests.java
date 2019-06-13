/* Author: Kaitlyn Leta
 * 
 * Description: This is a grading scale program. It takes in user input and returns that user's grade from 0-100.
 * 				The scale is 0-59 F, 60-69 D, 70-79 C, 80-89 B and 90-100 A
 * 
 * Boundary Value Analysis: This program can be used as an example of how to use proper boundary values to test
 * 							For example, one can choose the A scale boundary and test 89,90,91 lower boundary of the A scale. 
 * 							This example can also be used to find good equivalent classes and then use boundary value tests. 
 */
import java.util.Scanner;
public class BlackBoxTests {
	public static void main(String[] args) {
		Scanner input_grade = new Scanner(System.in);
		System.out.println("Enter student's test grade: ");
		double grade = input_grade.nextDouble();
		
		if((grade >= 90.0) && (grade <= 100.0)){
			System.out.println("A");
		}
		else if((grade >= 80) && (grade < 90)){
			System.out.println("B");
		}
		else if((grade >= 70) && (grade < 80)){
			System.out.println("C");
		}
		else if((grade >= 60) && (grade < 70)){
			System.out.println("D");
		}
		else if((grade >= 50) && (grade < 60)){
			System.out.println("F");
		}
		else{
			System.out.println("Invalid Input");
		}
	}
}
