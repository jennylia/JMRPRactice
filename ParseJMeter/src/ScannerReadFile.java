import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class ScannerReadFile {
	public static void main(String[] args) throws IOException {
		File fileIn = new File("C:/Users/jlian/JMR/WFF_b4p/adminconfigGet requests.csv");
		try {
			Scanner input = new Scanner(fileIn);
			Integer counter = 0;
			String filename = "adminconfigGet requests";
			String params = input.nextLine();
			
			while (input.hasNext())
			{
				counter ++; 
				String nextLine = input.nextLine();
				System.out.println(counter + nextLine);
				
				
				// Writing to file new csv
				// Need to make sure that all the folders exist first
				File fileOut = new File("C:/Users/jlian/JMR/WFF_b4p_newTest/" + filename+ counter +".csv");
				System.out.println(fileOut);
				// if file doesn't exists, then create it
				if (!fileOut.exists()) {
					fileOut.createNewFile();
				}
				
				FileWriter fw = new FileWriter(fileOut.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				
				//writing the parameters as the first line of each file
				bw.write(params);
				bw.newLine();
				bw.write(nextLine);
				bw.close();
	 
				System.out.println("Done");
	 
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
