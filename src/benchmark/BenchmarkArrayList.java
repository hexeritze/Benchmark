package benchmark;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;

import main.DataFile;

public class BenchmarkArrayList implements ICollections{
	
	public BenchmarkArrayList() {}
	
	private ArrayList<DataFile> collection = new ArrayList<DataFile>();
	private ArrayList<DataFile> result = new ArrayList<DataFile>();
	private String name = "ArrayList";
	public void resetFill() {
		collection = new ArrayList<DataFile>();
	}
	public void resetSearch() {
		result = new ArrayList<DataFile>();
	}
	public void putCollection(String word) {
		DataFile data = new DataFile(word);
		if(collection.size() == 0) {
			collection.add(data);
		}
		else {
			for (int i=0; i<collection.size(); i++) {
				if (data.getKey().equals(collection.get(i).getKey())) {
					collection.get(i).setValue(collection.get(i).getValue()+1);
					collection.set(i, collection.get(i));
					return;
				}
			}
			collection.add(data);
		}
		
	}
	
	public void searchWords(String prefix) {
		
		for(var word:collection) {
			if(word.getKey().startsWith(prefix)) {
				result.add(word);
			}
		}
		Collections.sort(result, new Comparator<DataFile>() {
			@Override
			public int compare(DataFile data1, DataFile data2) {
				if (data1.getValue() - data2.getValue() == 0) {
					return data1.getKey().compareTo(data2.getKey());
				}
				return (data1.getValue() - data2.getValue())*(-1);
			}
		});
	}
	public ArrayList<DataFile> getResult(){
		return result;
		
	}

	public void show() {
		for(var i = 0;i<result.size();i++) {
			System.out.println(result.get(i));
		}
	}
	
	public void doShow() {
		System.out.println("ArrayList:");
		
	}
	public String getName() {
		return name;
	}

	
	

}
