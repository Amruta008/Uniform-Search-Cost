import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/* Finding the path from one node to other*/
public class Find_Route{
	
	private static Navigate navigate;

	public static void main(String[] args) {
		
		//Variables used
		navigate = new Navigate();
		
		String inputFile = args[0];
		String source = args[1];
		String destination = args[2];
		
		ArrayList <String> inputText = new ArrayList<String>();
		ArrayList <String> heuristicText = new ArrayList<String>();
		
		//read the inputText till the END OF INPUT is reached
		try {
			FileReader inputFileReader = new FileReader(inputFile);
			BufferedReader inputBufferedReader = new BufferedReader(inputFileReader);
			
			String inputParameters;
			
			while((inputParameters = inputBufferedReader.readLine().toString()).equals("END OF INPUT") == false){
				inputText.add(inputParameters.toLowerCase());
	    	}
			
			//checking if the heuristicText has been sent through the command line arguments
			if (args.length == 4) {
				String heuristicFile = args[3];
				FileReader heuristicFileReader = new FileReader(heuristicFile);
				BufferedReader heuristicBufferedReader = new BufferedReader(heuristicFileReader);
				
				String heuristicLine;
				
				while ((heuristicLine = heuristicBufferedReader.readLine().toString()).equals("END OF INPUT") == false) {
					heuristicText.add(heuristicLine.toLowerCase());
				}
				heuristicBufferedReader.close();
			}
			inputBufferedReader.close();
		}
		//Exception handling if right file is not given or permission issues are faced
		catch (FileNotFoundException e) {
			System.out.println("Unable to read/open file!");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		//call to the right function depending on the arguments 
		if (args.length == 3) {
			navigate.UninformerdSearch(inputText, source.toLowerCase(), destination.toLowerCase());
		}
		else {
			navigate.InformedSearch(inputText, source.toLowerCase(), destination.toLowerCase(), heuristicText);
		}
		
	}

}
