package benchmark;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import main.DataFile;

public class BenchmarkLinkedList implements ICollections{
	private LinkedList<DataFile> collection = new LinkedList<DataFile>();
	private LinkedList<DataFile> result = new LinkedList<DataFile>();
	private String name = "LinkedList";
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
				if (Math.abs(data1.getValue() - data2.getValue())< 0.1) {
					return data1.getKey().compareTo(data2.getKey());
				}
				return (data1.getValue() - data2.getValue())*(-1);
			}
		});
	}
	public LinkedList<DataFile> getResult(){
		return result;
	}
	
	public void show() {
		for(var i = 0;i<result.size();i++) {
			System.out.println(result.get(i));
		}
	}

	@Override
	public void resetFill() {
		collection = new LinkedList<DataFile>();
		
	}

	@Override
	public void resetSearch() {
		result = new LinkedList<DataFile>();
	}

	public void doShow() {
		System.out.println("LinkedList:");
		
	}
	public String getName() {
		return name;
	}
	
}
