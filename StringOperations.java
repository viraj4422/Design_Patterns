import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Description - 
 * @author Viraj
 *
 */
public class StringOperations {

	private FileProcessor fileprocessor =null;
	private Map<String,Integer> countWords = null;
	/**
	 * 
	 * @param fileProcessor_In
	 */
	public StringOperations(FileProcessor fileProcessor_In) {
		fileprocessor= fileProcessor_In;
		countWords = new HashMap<String, Integer>();
	}
	public void processString(){
		 
		String line=null; 
		String tokens[] = null;
		while((line=fileprocessor.readLineFromFile())!=null){
			line = line.trim();
			if(line.contains("xs:element name")){
				tokens = line.split(" ");
				tokens[1] = tokens[1].substring(6, tokens[1].length()-1).toString();
				if(tokens[1].contains("\"")) {
					tokens[1] = tokens[1].substring(0, tokens[1].length()-1).toString();
				}
				if(countWords.containsKey(tokens[1])) {
					countWords.put(tokens[1], countWords.get(tokens[1])+1);
				} else {
					countWords.put(tokens[1], 1);
				}
				
			}
			
		}
	}
	
	public void finalOutput() {
		Entry<String,Integer> maxEntry = null;
		for(Entry<String,Integer> entry : countWords.entrySet()) {
		    if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
		        maxEntry = entry;
		    }
		}
		System.out.println("The most frequently occurring element is "+maxEntry.getKey()+".It appears "+maxEntry.getValue()+" times");
	}
	
}
