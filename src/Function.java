
public class Function {
	private int serial;
	private String name;
	private int cost;
	
	public Function(int serial, String name, int cost) {
		super();
		this.serial = serial;
		this.name = name;
		this.cost = cost;
	}
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
}
