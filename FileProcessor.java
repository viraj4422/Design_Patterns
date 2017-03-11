import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {             
	private String fileName = null;
	private FileReader fileReader = null;
	private BufferedReader bufferedReader = null;

	public FileProcessor(String inputFileName) {
		fileName = inputFileName;
	}

	public void initliazeFile() {
		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			System.err.println("Unable to open file '" + fileName + "'");
			System.exit(1);
		}
	}

	/**
	 * 
	 * @return
	 */
	public String readLineFromFile() {

		String line = null;
		try {
			line = bufferedReader.readLine();

		} catch (IOException ex) {
			System.err.println("Error reading file '" + fileName + "'");
			System.exit(1);
		}
		return line;
	}

}
