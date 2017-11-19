
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import ca.pfv.spmf.algorithms.sequentialpatterns.spam.AlgoSPAM;


/**
 * Example of how to use the SPAM algorithm in source code.
 * @author Philippe Fournier-Viger
 */
public class Main {

	public static void main(String [] arg) throws IOException{    
		// Load a sequence database
		String traces = "stacktraces.txt";
		String input = "input.txt";
		String output = "output.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(new File(traces)));
		String firstLine = br.readLine();
		String[] strs = firstLine.split(" ");
		int numberOfMethods = Integer.parseInt(strs[0]);
		int numberOfTraces = Integer.parseInt(strs[1]);
		
		for(int i=0; i<numberOfMethods; i++) {
			String str = br.readLine();
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(input)));
		for(int i=0; i<numberOfTraces; i++) {
			String str = br.readLine();
			bw.write(str+" -1 -2");
			bw.newLine();
		}
		
		br.close();
		bw.close();
		// Create an instance of the algorithm 
		AlgoSPAM algo = new AlgoSPAM(); 
		algo.setMinimumPatternLength(3);
		
        // if you set the following parameter to true, the sequence ids of the sequences where
        // each pattern appears will be shown in the result
		algo.showSequenceIdentifiersInOutput(true);
		
		// execute the algorithm with minsup = 4 sequences  (33 %)
		algo.runAlgorithm(input, output, .33);    
		algo.printStatistics();
	}
}