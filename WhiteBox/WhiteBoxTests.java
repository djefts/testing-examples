/* Author: Kaitlyn Leta
 * 
 * Description: This is a password crunch program that takes in the length of required password
 * 				and the possible characters of the password. Then it generates a list of all possible combinations
 * 				of a password.
 * 
 * Statement coverage, conditional coverage and branch coverage: This example allows for the demonstration of these
 * 																 types of techniques. Since there are conditions to be
 * 																 met and loops this provides different paths in a simple
 * 																 and short program. One could test different types of
 * 																 input parameters to achieve this as well as passing/failing
 * 																 conditions.
 */
public class WhiteBoxTests {

	public static void main(String[] args) {
		int input_length = 3; //k
		char[] input_characters = {'a', 'b', 'c'};
		String starter = "";
		int character_length = input_characters.length; //n
			
		CrunchPassword(input_length, input_characters, starter, character_length);
	}
	
	public static void CrunchPassword(int k, char[] c, String starter, int n){
		if(k==0){
			System.out.println(starter);
			return;
		}
		
		for(int i =0; i < n; i++){
			String addStarter = starter + c[i];
			CrunchPassword(k-1, c, addStarter, n);
		}
	}
}
