package tests;

public class ChartData {
	private Long time;
	private String name;
	private String count;
	
	public ChartData(Long time,String name,String count) {
		this.time = time;
		this.name = name;
		this.count = count;
	}
	public Long getTime() {
		return time;
	}
	public String getName() {
		return name;
	}
	public String getCount() {
		return count;
	}
}
