package MadLibs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 * Laura Davis 10 July 2017
 * Source code from MIT's OCW
 * A StdStreamUserInterface is a UI that uses stdin for
 * input and stdout for output
 */
public class StdStreamUI implements UserInterface {
	
	private BufferedReader input;
	
	public StdStreamUI() {
		this.input = new BufferedReader(new InputStreamReader(System.in));
	}//end StdStreamUI()
	
	public String promptUser(String prompt){
		System.out.println(prompt);
		try{
			return this.input.readLine();
		} catch (IOException e) {
			System.err.println("ERROR: There was a problem reading your" +
		"input. Returning and empty string. ");
			System.err.println(e);
			e.printStackTrace();
			return "";
		}
	}//end promptUser()
	
	public void writeString(String s) {
		System.out.println(s);
	}//end writeString()

}//end StdStreamUI class

