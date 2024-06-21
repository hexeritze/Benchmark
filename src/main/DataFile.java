package main;

public class DataFile implements Comparable<DataFile>{
	private String key;
	private int value = 1;
	
	public DataFile(String key) {
		this.key = key;
	}
	
	public DataFile(String key, Integer value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.getKey() +" "+ this.getValue();
	}
	
	@Override
	public int compareTo(DataFile data) {
		return this.getKey().compareTo(data.getKey());
	}
}
