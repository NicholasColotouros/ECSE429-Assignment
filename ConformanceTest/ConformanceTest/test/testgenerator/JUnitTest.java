package testgenerator;

/**
 * Data representation of a JUnit test
 */
public class JUnitTest 
{
	public enum AnnotationType{BeforeClass, Before, Test, After}
	
	private AnnotationType Annotation;
	private String MethodName;
	// TODO: add representation of asserts
	
	private int indentation = 0;
	
	public JUnitTest(AnnotationType a, String mName) 
	{
		Annotation = a;
		MethodName = mName;
	}

	public String ToString(int pIndentation)
	{
		indentation = pIndentation;
		
		String ret = Indent() + "@" + Annotation + "\n";
		ret = ret + Indent() + "public void " + MethodName + "() {\n";
		indentation++;
		// TODO: CODE TESTS
		
		indentation--;
		ret = ret + Indent() + "}";
		
		return ret;
	}
	
	private String Indent()
	{
		String output = "";
		for(int i = 0; i < indentation; i++)
		{
			output = output + "\t";
		}
		return output;
	}
}
