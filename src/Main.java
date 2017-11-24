
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

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
		
		ArrayList<Function> functions = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new FileReader(new File(traces)));
		String firstLine = br.readLine();
		String[] strs = firstLine.split(" ");
		int numberOfMethods = Integer.parseInt(strs[0]);
		int numberOfTraces = Integer.parseInt(strs[1]);
		
		for(int i=0; i<numberOfMethods; i++) {
			String str = br.readLine();
			String[] methodstr = str.split(" ");
			Function f = new Function(Integer.parseInt(methodstr[0]), methodstr[1], Integer.parseInt(methodstr[2]));
			functions.add(f);
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
		
		ArrayList<Cluster> clusters = new ArrayList<>();
		br = new BufferedReader(new FileReader(new File(output)));
		
		while(true){
			String str = br.readLine();
			if(str == null){
				break;
			}
			
			int cost = 0;
			
			String[] seq = str.split("-1")[0].split(" ");
			
			ArrayList<Integer> fseq = new ArrayList<>();
			
			for(int i=0;i<seq.length;i++){
				if(seq[i] == "") {
					continue;
				}
				else {
					int f = Integer.parseInt(seq[i]);
					cost += functions.get(f).getCost();
					fseq.add(f);
				}
			}
			
			Cluster c = new Cluster(cost);
			c.setSequence(fseq);
			
			String[] traceslist = str.split("#SID: ")[1].split(" ");
			
			for(int i=0;i<traceslist.length;i++){
				if(traceslist[i] == "") {
					continue;
				}
				else {
					int f = Integer.parseInt(traceslist[i]);
					c.addtrace(f);
				}
			}
			
			clusters.add(c);
		}
		
		Collections.sort(clusters, new Comparator<Cluster>() {
		    @Override
		    public int compare(Cluster lhs, Cluster rhs) {
		        return lhs.getCost() > rhs.getCost() ? -1 : 0;
		    }
		});
		
		ArrayList<Integer> addedTraces = new ArrayList<>();
		
		for (Cluster cluster : clusters) {
			ArrayList<Integer> removeTrace = new ArrayList<>();
			for (int trace : cluster.gettraces()) {
				if(addedTraces.contains(trace)){
					removeTrace.add(trace);
				}
				else {
					addedTraces.add(trace);
				}
			}
			for (int trace: removeTrace){
				cluster.removetrace(trace);
			}
			System.out.println(cluster);
		}
	}
}