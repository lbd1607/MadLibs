package MadLibs; //<--Make your own package to import
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Laura Davis 10 July 2017
 * This program uses interfaces and abstract classes
 * to create a game of MadLibs.
 * 
 * Source code from MIT's OCW
 */
public class MadLibs extends MadLibTemplate
{
	ArrayList<String> response = new ArrayList<String>();
	ArrayList<String> txt = new ArrayList<String>();

	/**
	 * 
	 * @param title
	 */
	MadLibs(String title) {
		super(title);
		System.out.println(title);
		System.out.println();
	}//end MadLibs

	@Override
	void addString(String text) {
		//ArrayList<String> textcopy = new ArrayList<String>(txt);
	
	txt.add(text.toString());
		
	}//end void addString

	@Override
	void addSlot(String type) {

		Scanner keyboard = new Scanner(System.in); 
				
		System.out.println("Please enter a " + type + ": ");
		response.add(keyboard.nextLine());
	}//end void addSlot

	@Override
	void printAsTemplate(UserInterface ui) {

		/**
		 * This method works and prints both arrays,
		 * but it does not stagger them. 
		 */
		//int length = txt.size();
		//String printy = "";
		//
		//ArrayList<String> concatdAList = new ArrayList<String>();
		//concatdAList.addAll(txt);
		//concatdAList.addAll(response);
		//
		//for (int i = 0; i < length; i++)
		//{
		//	printy = concatdAList.toString();//.add(txt.get(i)) + " " + response.get(i);
		//}
		//System.out.println(printy);
		
		merge(txt, response);
		
	}//end printAsTemplate

	/**
	 * This method merges and staggers the two arraylists to be printed
	 * properly. This is the best method to accomplish this task.
	 * @param a = txt
	 * @param b = response
	 */
	private static void merge(ArrayList<String> aText, ArrayList<String>bResponse)
	{
		ArrayList<String> fin = new ArrayList<>(aText.size() + bResponse.size());
		for(int i = 0, j = 0; i < aText.size() || j < bResponse.size(); i++, j++)
		{
			if(i < aText.size()) fin.add(aText.get(i));
			if(j < bResponse.size()) fin.add(bResponse.get(j));
		}
		aText.clear();
		bResponse.addAll(fin);
		//StringBuilder allows you to format your own strings
		//So the merged values (if converted with .toString()) does
		//not include commas and brackets.
		StringBuilder builder = new StringBuilder();
		for(String value : fin)
		{
			builder.append(value);
		}
		String printy = builder.toString();
		System.out.println(printy);
		//fin.toString();
		//String.format("%s %s", aText, bResponse);
		//System.out.print(fin);
	}
		
	@Override
	void doLib(UserInterface ui) {
		
	}//end void doLib
	
	abstract class MadLibEntry{
		
		/** @return the value of this entry into a template**/
		abstract public String templateString();
		
		/** @return the value of this entry into a madlib**/
		abstract public String madLibString();
		
		/**Collect any relevant info from the user **/
		abstract public void doLib(UserInterface ui);
		
	}//end MadLibEntry class
	
	class TextEntry extends MadLibEntry{

		@Override
		public String templateString() {
			return null;
		}//end String templateString

		@Override
		public String madLibString() {
			return null;
		}//end public String madLibString

		@Override
		public void doLib(UserInterface ui) {
			
		}//end public void doLib
		
	}//end TextEntry class
	
	class Slot extends MadLibEntry{

		@Override
		public String templateString() {
			return null;
		}//end public String templateString

		@Override
		public String madLibString() {
			return null;
		}//end public String madLibString

		@Override
		public void doLib(UserInterface ui) {
			
		}//end public void doLib
		
	}//end Slot class

}//end MadLibs class
