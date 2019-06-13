/* Author: David Jefts
 *
 * Description: This is a password crunch program that takes in the length of required password
 * 				and the possible characters of the password. Then it generates a list of all possible combinations
 * 				of a password.
 *
 * Defect possibilities: There are multiple places where defects could be planted, and a few where they have already
 * 						 -Line 22, defect because the >= sign should be <=
 * 						 -Line 25, there are many possible defects, each one of the signs can be changed to radically
 * 						  affect the program. The correct code is:
 * 						    return fibonnacci(n - 2) + fibonnacci(n - 1)
 */
public class CRExample {
    public static void main(String[] args) {
        CRExample crExample = new CRExample();
        for (int i = 0; i < 20; i++) {
            System.out.println(crExample.fibonnacci(i));   //print out first 20 fibbonacci numbers
        }
    }

    private int fibonnacci(int n) {
        if (n >= 1) {   // Planted defect
            return n;
        } else {
            return fibonnacci(n - 2) - fibonnacci(n + 1); // Planted defect
            //return fibonnacci(n - 2) + fibonnacci(n - 1); // Correct code
        }
    }
}
