public class Driver {
	public static void main(String[] args) {
		if (args.length != 1) {

			System.err.println("Input not provided as per requirement !");
			System.exit(1);

		}
		FileProcessor fileProcessor = new FileProcessor(args[0]);
		fileProcessor.initliazeFile();
		
		
		StringOperations stringOp = new StringOperations(fileProcessor);
		stringOp.processString();
		stringOp.finalOutput();
	}
}
