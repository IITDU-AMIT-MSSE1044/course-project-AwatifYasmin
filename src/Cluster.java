import java.util.ArrayList;

public class Cluster {
	private ArrayList<Integer> sequence;
	private int cost;
	private ArrayList<Integer> traces;
	
	public Cluster(int cost) {
		super();
		this.cost = cost;
		this.traces = new ArrayList<>();
	}
	
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public ArrayList<Integer> gettraces() {
		return traces;
	}
	public void settraces(ArrayList<Integer> traces) {
		this.traces = traces;
	}
	
	public void addtrace(int trace) {
		this.traces.add(trace);
	}
	public void removetrace(int trace) {
		int index = traces.indexOf(trace);
		this.traces.remove(index);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Sequence:" + sequence.toString() + " COST:"+ cost + " Traces:" + traces.toString();
	}

	public ArrayList<Integer> getSequence() {
		return sequence;
	}

	public void setSequence(ArrayList<Integer> sequence) {
		this.sequence = sequence;
	}
}
