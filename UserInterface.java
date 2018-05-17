package MadLibs;

/**
 * Laura Davis 10 July 2017
 * This is the user interface for the MadLibs game
 */
public interface UserInterface 
{
	
	//prompt the user and return user's response
	public String promptUser(String prompt);
	
	//write string to the user
	public void writeString(String s);

}//end interface UserInterface
