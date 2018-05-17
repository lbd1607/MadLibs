package MadLibs;

import java.util.ArrayList;

//The template implemented in MadLibs

public abstract class MadLibTemplate 
{
	protected String title;
	
	//creates new MadLibTemplate with the given title
	MadLibTemplate(String title){
		this.title = title;
	}//end MadLibTemplate()
	
	//get the title
	public String getTitle(){
		return this.title;
	}//end getTitle()
	
	//add text
	abstract void addString(String text);
	
	//add slot
	abstract void addSlot(String type);
	
	//print madlib as a template
	abstract void printAsTemplate(UserInterface ui);
	
	//prompts the user
	//ask for words in each slot, sub words, print final madlib
	abstract void doLib(UserInterface ui);
	
	//sends arraylist to print
	public void printy(ArrayList<String>response, String type, String string){}

}//end MadLibTemplate class
