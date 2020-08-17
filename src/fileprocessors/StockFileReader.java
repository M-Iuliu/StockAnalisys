package fileprocessors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockFileReader {
	
	String filePath = null;
	
	public StockFileReader(String filePath){
		this.filePath = filePath;
	}
	
	public List<String> getHeaders() throws IOException{
		String line = readFirstLine(filePath);
		String [] header = line.split(",");
		List<String> values = new ArrayList<String>();
		values = Arrays.asList(header);
		
		return values;
	}
	
	static String readFirstLine(String path) throws IOException {
	    try (BufferedReader br =
	                   new BufferedReader(new FileReader(path))) {
	        return br.readLine();
	    }
	}
	/**
	 * Complete the body of this method.
	 * @return List
	 * @throws IOException
	 */
	public List<String> readFileData() throws IOException{
		List<String> lines = new ArrayList<String>();
		
		// Insert your code here..
		try(FileReader filereader = new FileReader(filePath);
			BufferedReader bufferreader = new BufferedReader(filereader);) {
			String line = bufferreader.readLine(); // skip first line
			// read from the second line onwards
			while(line != null) {
				line = bufferreader.readLine();
					if(line != null)
					lines.add(line);
			}
		}
		catch(FileNotFoundException e){
			System.out.println("File not found");	
		} 
		catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Problem reading the file");
		}
	    return lines;
	}
}
