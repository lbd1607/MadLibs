package MadLibs;

public class Raven 
{
	public static void main(String[] args)
	{
		MadLibs ml = new MadLibs("Raven");
	    UserInterface ui = new StdStreamUI();
	    
	    //Originally from Edgar Allen Poe's "The Raven"
	    //original answers:
	    //ebony, bird, smiling, grave, stern, countenance, crest
	    //craven, wandering, nightly, shore, name, nevermore
	    
	    ml.addString("Then this ");
	    ml.addSlot("adjective");
	    ml.addString(" ");
	    ml.addSlot("noun");
	    ml.addString(" beguiling my sad fancy into ");
	    ml.addSlot("verb ending in \"ing\"");
	    ml.addString(", \nBy the ");
	    ml.addSlot("adjective");
	    ml.addString(" and ");
	    ml.addSlot("adjective");
	    ml.addString(" decorum of the ");
	    ml.addSlot("noun");
	    ml.addString(" it wore, \n\"Though thy ");
	    ml.addSlot("noun");
	    ml.addString(" be shorn and shaven, thou, \"I said, \"art sure no ");
	    ml.addSlot("noun");
	    ml.addString(", \nGhastly grim and ancient raven ");
	    ml.addSlot("verb");
	    ml.addString(" from the ");
	    ml.addSlot("adjective");
	    ml.addString(" ");
	    ml.addSlot("noun");
	    ml.addString("-- \nTell me what thy lordly ");
	    ml.addSlot("noun");
	    ml.addString(" is on the Night's Plutonian shore!\" \nQuoth the raven, \"");
	    ml.addSlot("adverb");
	    ml.addString(".\"");
	    System.out.println();
	    
	    ml.doLib(ui);
		ml.printAsTemplate(ui);
	}//end main

}//end Raven class
