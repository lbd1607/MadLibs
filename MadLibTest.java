package MadLibs;
import java.util.List;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.Formatter;

/**
 * Laura Davis 10 July 2017
 * Sets up a test for the MadLibs game
 */
public class MadLibTest extends TestCase
{
	MadLibs ml;
	ShimUI ui;
	
	final static String response = "shimmy!";
	
	private String generatePrompt(String type){
		return String.format("Please enter a %s: ", type);
	}//end generatePrompt()
	
	public void setUp(){
		ml = new MadLibs("title");
		ui = new ShimUI(response);
	}//end setUp()
	
	public void testTitle(){
		assertEquals("ml.getTitle() did not return correct title",
				"title", ml.getTitle());
		String s = "another title";
		MadLibs ml2 = new MadLibs(s);
		assertEquals ("ml2.getTitle() did not return correct title", 
				s, ml2.getTitle());
	}//end testTitle()
	
	public void testEmptyDoLib(){
		
		ml.doLib(ui);
		assertEquals("Empty MadLibs.dolib() should not prompt ui", 
				new ArrayList<String>(), ui.prompts);
		
		List<String> expectedOutputs = new ArrayList<String>();
		expectedOutputs.add("");
		assertEquals("Empty MadLibs.doLib() should write empty madLib", 
				expectedOutputs, ui.outputs);
	}//end testEmptyDoLib()
	
	public void testEmptyPrintAsTemplate(){
		
		ml.printAsTemplate(ui);
		assertEquals("Empty MadLib.printAsTemplate() should not prompt ui",
				new ArrayList<String>(),
				ui.prompts);
		
		List<String> expectedOutputs = new ArrayList<String>();
		expectedOutputs.add("");
		assertEquals("Empty MadLib.printAsTemplate() should write empty madlib",
				expectedOutputs, ui.outputs);
	}//end testEmptyPrintAsTemplate()
	
	public void testTextDoLib(){
		String testString = "test string";
		ml.addString(testString);
		ml.doLib(ui);
		
		assertEquals("Text-only MadLibs.doLib() should not prompt ui", 
				new ArrayList<String>(), ui.prompts);
		
		List<String> expectedOutputs = new ArrayList<String>();
		expectedOutputs.add(testString);
		assertEquals("Text-only MadLibs.doLib() should write text.", 
				expectedOutputs, ui.outputs);
	}//end testTextDoLib
	
	public void testTextPrintAsTemplate(){
		String testString = "test string";
		ml.addString(testString);
		ml.printAsTemplate(ui);
		
		assertEquals("Text-only MadLibs.printAsTemplate() should not prompt ui",
				new ArrayList<String>(), ui.prompts);
		List<String> expectedOutputs = new ArrayList<String>();
		expectedOutputs.add(testString);
		assertEquals("Text-only MadLibs.printAsTemplate() should write text.",
				expectedOutputs, ui.outputs);
	}//end of testTextPrintAsTemplate()
	
	public void testSlotDoLib(){
		
		String testString = "test string";
		ml.addSlot(testString);
		ml.doLib(ui);
		
		List<String> expectedPrompts = new ArrayList<String>();
		expectedPrompts.add(generatePrompt(testString));
		assertEquals("Slot-only MadLibs.printAsTemplate() should prompt ui.",
				expectedPrompts, ui.prompts);
		
		List<String> expectedOutputs = new ArrayList<String>();
		expectedOutputs.add(testString);
		assertEquals("Slot-only MadLibs.printAsTemplate() should write slot.",
				expectedOutputs, ui.outputs);
		
	}//end testSlotDoLib
	
	public void testSlotPrintAsTemplate(){
		
		String testString = "test string";
		ml.addString(testString);
		ml.printAsTemplate(ui);
		
		assertEquals("Slot-only MadLib.printAsTemplate() should not prompt ui",
				new ArrayList<String>(), ui.prompts);
		
		List<String> expectedOutputs = new ArrayList<String>();
		expectedOutputs.add(testString);
		assertEquals("Slot-only MadLibs.printAsTemplate() should write slot.",
				expectedOutputs, ui.outputs);
	}//end testSlotPrintAsTemplate
	
	public void testBiggerLib(){
		
		String testString = "test string";
		ml.addString("This is a ");
		ml.addSlot("noun");
		ml.addString(" all about how ");
		ml.addSlot("pronoun");
		
		ml.printAsTemplate(ui);
		List<String> expectedPrompts = new ArrayList<String>();
		assertEquals("Bigger MadLib.printAsTemplate() should not prompt ui",
				expectedPrompts, ui.prompts);
		
		List<String> expectedOutputs = new ArrayList<String>();
		assertEquals("Bigger MadLibs.printAsTemplate() should write correctly.",
				expectedOutputs, ui.outputs);
		
		//now do the MadLib while keeping the previous output
		ml.doLib(ui);
		
		expectedPrompts.add(generatePrompt("noun"));
		expectedPrompts.add(generatePrompt("pronoun"));
		assertEquals("Bigger MadLib.doLib() should prompt ui twice", 
				expectedPrompts, ui.prompts);
		
		expectedOutputs.add(String.format("This is a %s all about how %s", 
				response, response));
		assertEquals("Bigger MadLib.doLib() should write correctly.", 
				expectedOutputs, ui.outputs);
	}//end of testBiggerLib()
	
	public void testMultiResponse(){
		List<String> responses = new ArrayList<String>();
		responses.add("alpha");
		responses.add("beta");
		responses.add("GAMMA");
		MultiShimUI mui = new MultiShimUI(responses);
		
		ml.addString("A ");
		ml.addSlot("first letter");
		ml.addString(" B ");
		ml.addSlot("second letter");
		ml.addString(" C ");
		ml.addSlot("third letter");
		
		ml.printAsTemplate(mui);
		List<String> expectedPrompts = new ArrayList<String>();
		assertEquals("MultiResponse MadLib.printAsTemplate() should not prompt ui",
				expectedPrompts, mui.prompts);
		List<String> expectedOutputs = new ArrayList<String>();
		expectedOutputs.add(String.format("A %s B %s C %s",
				"<first letter>", "<second letter>", "<third letter>"));
		assertEquals("MultiResponse MadLib.printAsTemplate() should write correctly.",
				expectedOutputs, mui.outputs);
		
		//again, do the MadLib
		ml.doLib(mui);
		
		expectedPrompts.add(generatePrompt("first letter"));
		expectedPrompts.add(generatePrompt("second letter"));
		expectedPrompts.add(generatePrompt("third letter"));
		assertEquals("MultiResponse MadLibs.printAsTemplate() should prompt ui three times.",
				expectedPrompts, mui.prompts);
		
		expectedOutputs.add(String.format("A %s B %s C %s",
											"alpha", "beta", "GAMMA"));
		assertEquals("MultiResponse MadLiv.doLib() should write correctly.",
				expectedOutputs, mui.outputs);
	}//end testMultiResponse()

}//end MadLibTest class

class ShimUI implements UserInterface
{
	//The prompts it has seen
	List<String> prompts;
	//The strings it has been asked to output;
	List<String> outputs;
	//The response that it gives from test user
	String response;
	
	public ShimUI(String response){
		prompts = new ArrayList<String>();
		outputs = new ArrayList<String>();
		this.response = response;
	}//end ShimUI()
	
	public String promptUser(String prompt){
		prompts.add(prompt);
		return response;
	}//end promptUser()
	
	public void writeString(String s){
		//System.out.println("writeString(" + s + ") called");
		outputs.add(s);
	}//end writeString()

}//end ShimUI class

/** Allows multiple response types from a single shim. **/
class MultiShimUI extends ShimUI{
	
	List<String> responses;
	int responseIndex;
	
	public MultiShimUI(List<String> responses){
		super(null);
		this.responses = responses;
		responseIndex = 0;
	}//end MultiShim()
	
	public String getResponse(){
		String rval = this.responses.get(responseIndex % this.responses.size());
		responseIndex++;
		return rval;
	}//end getResponse
	
	public String promptUser(String prompt){
		super.promptUser(prompt);
		return getResponse();
	}//end promptUser
	
}//end MultiShimUI class
